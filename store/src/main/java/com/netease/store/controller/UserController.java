package com.netease.store.controller;

import com.netease.store.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 功能说明
 *
 * @author wangliang01 on 2018/2/25
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage(User user){
        return "user/userLogin";
    }


    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String doLogin(String username, String password, HttpServletRequest request){
        User user = restTemplate.getForObject("http://user-of-store/user/login/" + username + "/" + password, User.class);
        if(user != null) {
            user.setPassword(null);
            HttpSession session = request.getSession();
            if(user.getUsername().equals("buyer")){
                session.setAttribute("login_user", user);
            }else{
                session.setAttribute("login_admin", user);
            }
            return "redirect:/";
        }else {
            return "redirect:/user/login?errorPwd=true";
        }

    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/";
    }
}
