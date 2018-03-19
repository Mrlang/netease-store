package com.netease.store.controller;

import com.netease.store.vo.AjaxResult;
import com.netease.store.vo.BigCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 功能说明
 *
 * @author wangliang01 on 2018/2/25
 */
@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    //获取未结算的商品
    @RequestMapping("/")
    public ModelAndView getNotCleared(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        if(request.getSession().getAttribute("login_user") == null){
            modelAndView.setViewName("redirect:/index");
            return modelAndView;
        }
        BigCart bigCart = restTemplate.getForObject("http://cart-of-store/cart/getNotCleared", BigCart.class);
        modelAndView.addObject("bigCart", bigCart);
        modelAndView.setViewName("cart/cart");
        return modelAndView;
    }

    //将一件商品加入购物车
    @RequestMapping("/add/{pid}/{number}")
    @ResponseBody public  AjaxResult insert(@PathVariable  Long pid, @PathVariable int number, @RequestParam(required = true, defaultValue = "1") Long uid){
        System.out.println("uid is " + uid);
        AjaxResult ajaxResult = restTemplate.getForObject("http://cart-of-store/cart/add/" + pid, AjaxResult.class);
        return ajaxResult;
    }

    //买下购物车中所有商品
    @RequestMapping("/buyAll")
    public String buyAll(){
        AjaxResult ajaxResult = restTemplate.getForObject("http://cart-of-store/cart/buyAll", AjaxResult.class);
        return "cart/cart";
    }

    //购物车中所有商品清除不要
    @RequestMapping("/notBuyAll")
    @ResponseBody
    public AjaxResult notBuyAll(){
        AjaxResult ajaxResult = restTemplate.getForObject("http://cart-of-store/cart/notBuyAll", AjaxResult.class);
        return ajaxResult;
    }

    //查看所有已在购物车结算购买的商品记录
    @RequestMapping("/finace")
    public ModelAndView getAllBuyed(ModelAndView modelAndView, HttpServletRequest request){
        if(request.getSession().getAttribute("login_user") == null){
            modelAndView.setViewName("redirect:/index");
            return modelAndView;
        }else{
            BigCart bigCart = restTemplate.getForObject("http://cart-of-store/cart/getAllBuyed", BigCart.class);
            modelAndView.setViewName("/cart/allBuyed");
            modelAndView.addObject("bigCart", bigCart);
            return modelAndView;
        }

    }

    @ResponseBody
    @RequestMapping("/delete/{pid}")
    public AjaxResult delete(@PathVariable int pid){
        AjaxResult res = restTemplate.getForObject("http://cart-of-store/cart/delete/" + pid, AjaxResult.class);
        return res;
    }

    @ResponseBody
    @RequestMapping("/addTotal/{pid}/{count}")
    public AjaxResult addTotal(@PathVariable int count, @PathVariable int pid){
        AjaxResult res = restTemplate.getForObject("http://cart-of-store/cart/addTotal/" + pid + "/" + count, AjaxResult.class);
        return res;
    }



}
