package com.netease.store.controller;

import com.netease.store.po.Cart;
import com.netease.store.po.User;
import com.netease.store.vo.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 功能说明
 *
 * @author wangliang01 on 2018/1/31
 */

@Controller
//@RequestMapping("/xhr/{productId}/vi")

public class IndexController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping(value = {"/", "/index"})
    public ModelAndView index(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("test", "test");
        httpSession.setAttribute("str", "JSP get session by'${}'");
        return new ModelAndView("index");
    }

    @RequestMapping("/cart/{id}")
    @ResponseBody
    public AjaxResult getCart(@PathVariable Long id){
        AjaxResult c = restTemplate.getForObject("http://cart-of-store/cart/get/" + id, AjaxResult.class);
        return c;
    }

    @RequestMapping("/user/{id}")
    @ResponseBody
    public User getUser(@PathVariable Long id){
        return restTemplate.getForObject("http://user-of-store/" + id, User.class);
    }

    @RequestMapping("/hello")
    @ResponseBody
    public User hello(){
        User u = new User();
        u.setUsername("wangliang");
        return u;
    }

    @GetMapping("/log-user-instance")
    public void logUserInstance() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("user-of-store");
        // 打印当前选择的是哪个节点
        System.out.println(serviceInstance.getServiceId() + "," +serviceInstance.getHost() +","+ serviceInstance.getPort());
    }

    @RequestMapping("/test")
    public String adf(){
        return "index";
    }

    @RequestMapping(value = "/combine/getParentSkuInfo.json")
    @ResponseBody
    public String parentItemQuery(@PathVariable("productId") String productId, @RequestParam("skuId") Long skuId){
        return "123";
    }


}