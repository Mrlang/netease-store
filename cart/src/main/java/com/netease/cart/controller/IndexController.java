package com.netease.cart.controller;

import com.netease.cart.mapper.CartMapper;
import com.netease.cart.po.Cart;
import com.netease.cart.po.Product;
import com.netease.cart.service.CartService;
import com.netease.cart.vo.AjaxResult;
import com.netease.cart.vo.BigCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 功能说明
 *
 * @author wangliang01 on 2018/1/31
 */

@RestController
@RequestMapping("/cart")
public class IndexController {

    @Autowired
    private CartMapper cartMapper;

    @Resource
    private CartService cartService;

    @RequestMapping("/get/{id}")
    public AjaxResult getUser(@PathVariable Long id){
        Cart cart = cartMapper.selectByPrimaryKey(id);
        if(cart != null){
            return AjaxResult.newSuccessResult(cart);
        }else{
            return AjaxResult.newFailResult();
        }
    }

    //获取购物车中待处理的商品
    @RequestMapping("/getNotCleared")
    public BigCart getNotCleared(){
        return cartService.getNotCleared();
    }


    @RequestMapping("/getAllBuyed")
    public BigCart getAllBuyed(){
        return cartService.getAllBuyed();
    }


    @RequestMapping("/add/{pid}")
    public AjaxResult insert(@PathVariable Long pid, @RequestParam(required = false, defaultValue = "1") Long uid){
        System.out.println("uid is " + uid);
        return cartService.insert(pid, new Long(1));
    }

    @RequestMapping("/buyAll")
    public AjaxResult buyAll(){
        try{
            return cartService.buyAll();
        }catch(RuntimeException e) {
            return AjaxResult.newFailResult();
        }

    }

    @RequestMapping("/notBuyAll")
    public AjaxResult notBuyAll(){
        return cartService.notBuyAll();
    }



    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/delete/{pid}")
    public AjaxResult delete(@PathVariable int pid){
        int i = cartMapper.deleteByPid(pid);
        if( i>0 ){
            return AjaxResult.newSuccessResult();
        }else{
            return AjaxResult.newFailResult("从购物车删除失败");
        }

    }

    @RequestMapping("/addTotal/{pid}/{count}")
    public AjaxResult addTotal(@PathVariable Long pid, @PathVariable int count){
        Cart cart = cartMapper.selectByPid(pid);
        cart.setCount(cart.getCount() + count);
        cartMapper.updateCountByPid(cart);
        return AjaxResult.newSuccessResult();
    }
}