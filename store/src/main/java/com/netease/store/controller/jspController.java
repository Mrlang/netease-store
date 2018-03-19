package com.netease.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 功能说明
 *
 * @author wangliang01 on 2018/2/25
 */
@Controller

public class jspController {
    @RequestMapping("/jsp")

    public String helloJsp(Map<String,Object> map){


        map.put("hello", "123");

        return "index";

    }
}
