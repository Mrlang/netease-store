package com.netease.store.controller;

import com.netease.store.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能说明
 *
 * @author wangliang01 on 2018/2/22
 */
@Controller
@RequestMapping("/home")
public class HomeController {
    @RequestMapping("/hello")
    @ResponseBody
    public User hello(){
        User u = new User();
        u.setUsername("wangliang");
        return u;
    }
}
