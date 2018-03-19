package com.netease.cart.service;

import com.netease.cart.mapper.CartMapper;
import com.netease.cart.po.Cart;
import com.netease.cart.po.Product;
import com.netease.cart.vo.AjaxResult;
import com.netease.cart.vo.BigCart;
import com.netease.cart.vo.CartDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能说明
 *
 * @author wangliang01 on 2018/2/24
 */
@Service
public class CartService {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    public AjaxResult insert(Long pid, Long uid){
        Cart cart = cartMapper.selectByPid(pid);
        if(cart != null){
            if(cart.getCleared() == 0){
                cart.setCount(cart.getCount()+1);
                cartMapper.updateByPrimaryKey(cart);
                return AjaxResult.newSuccessResult();
            }else{
                return AjaxResult.newFailResult("该商品已购买过");
            }
        }else{
            Cart newCart = new Cart();
            newCart.setPid(pid);
            newCart.setUid(uid);
            newCart.setCount(1);
            cartMapper.insertSelective(newCart);
            return AjaxResult.newSuccessResult();
        }
    }

    @Transactional
    public AjaxResult buyAll(){
        List<Cart> list = cartMapper.getNotCleared();
        for( Cart cart : list ) {
            Product product = restTemplate.getForObject("http://product-of-store/product/sale/" + cart.getPid() + "/" + cart.getCount(), Product.class);
            cart.setBuyedPrice(product.getPrice());
            int i = cartMapper.buyOne(cart);
            if(i==0){
                throw new RuntimeException("清除购物车失败。id is " + cart.getId());
            }
        }

        return AjaxResult.newSuccessResult();
    }

    public AjaxResult notBuyAll(){
        int res = cartMapper.notBuyAll();
        return AjaxResult.newSuccessResult();
    }

    public BigCart getNotCleared(){
        List<Cart> list = cartMapper.getNotCleared();
        List<CartDetail> cartDetailList = new ArrayList<>();
        Float total = 0f;
        for( Cart cart : list) {
//            http://localhost:9001/product/sale/2/0
            Product product = restTemplate.getForObject("http://product-of-store/product/sale/" + cart.getPid() + "/0", Product.class);
            CartDetail cartDetail = new CartDetail();
            cartDetail.setCount(cart.getCount());
            cartDetail.setPid(cart.getPid());
            cartDetail.setPrice(product.getPrice());
            cartDetail.setTitle(product.getTitle());
            cartDetailList.add(cartDetail);
            total += product.getPrice() * cart.getCount();
        }

        BigCart bigCart = new BigCart();
        bigCart.setCarts(cartDetailList);
        bigCart.setTotalPrice(total);
//        return AjaxResult.newSuccessResult(bigCart);
        return bigCart;
    }

    public BigCart getAllBuyed() {
        List<Cart> list = cartMapper.getCleared();
        List<CartDetail> cartDetailList = new ArrayList<>();
        Float total = 0f;
        for( Cart cart : list) {
            Product product = restTemplate.getForObject("http://product-of-store/product/sale/" + cart.getPid() + "/0", Product.class);
            CartDetail cartDetail = new CartDetail();
            cartDetail.setTitle(product.getTitle());
            cartDetail.setImg(product.getImg());
            cartDetail.setTime(cart.getUpdated());
            cartDetail.setPrice(cart.getBuyedPrice());
            cartDetail.setCount(cart.getCount());
            cartDetail.setPid(cart.getPid());
            cartDetailList.add(cartDetail);
            total += cart.getBuyedPrice() * cart.getCount();
        }

        BigCart bigCart = new BigCart();
        bigCart.setCarts(cartDetailList);
        bigCart.setTotalPrice(total);
//        return AjaxResult.newSuccessResult(bigCart);
        return bigCart;
    }

}
