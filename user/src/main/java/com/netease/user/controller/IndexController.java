package com.netease.user.controller;

import com.netease.user.mapper.UserMapper;
import com.netease.user.po.User;
import com.netease.user.vo.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * 功能说明
 *
 * @author wangliang01 on 2018/1/31
 */

@RestController
@RequestMapping("/user")
public class IndexController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/get/{id}")
    public AjaxResult getUser(@PathVariable Long id){
        User user = userMapper.selectByPrimaryKey(id);
        if(user != null){
            return AjaxResult.newSuccessResult(user);
        }else{
            return AjaxResult.newFailResult();
        }
    }

    @RequestMapping("/login/{username}/{password}")
    public User login(@PathVariable String username, @PathVariable String password){
        User user = userMapper.selectByCount(username, password);
        if(user != null){
            return user;
        }else{
            return null;
        }
    }

    @RequestMapping("/get/info")
    public AjaxResult getInfo(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user != null){
            return AjaxResult.newSuccessResult(user);
        }else{
            return AjaxResult.newFailResult();
        }
    }

    @RequestMapping("/logout")
    public AjaxResult logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return AjaxResult.newSuccessResult();
    }


    @RequestMapping("/hello")
    public String hello(){
        userMapper.update();
        return "hello";
    }
}