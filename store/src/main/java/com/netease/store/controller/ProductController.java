package com.netease.store.controller;

import com.alibaba.fastjson.JSON;
import com.netease.store.po.Product;
import com.netease.store.vo.AjaxResult;
import com.netease.store.vo.Page;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.PrimitiveIterator;

/**
 * 功能说明
 *
 * @author wangliang01 on 2018/2/25
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/")
    public ModelAndView getPage(ModelAndView model, HttpServletRequest request){
        Page<Product> page = new Page(request);
        page = restTemplate.getForObject("http://product-of-store/product/getPage/" + page.getPageNo() + "/" + page.getPageSize(), Page.class);
        model.addObject("page", page);
        model.setViewName("product/productList");
        return model;
    }

    @RequestMapping("/listNotBuyed")
    public ModelAndView listNotBuyed(HttpServletRequest request){
        Page<Product> page = new Page(request);
        page = restTemplate.getForObject("http://product-of-store/product/getNotBuyedPage/" + page.getPageNo() + "/" + page.getPageSize(), Page.class);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("page", page);
        modelAndView.setViewName("product/productList");
        return modelAndView;
    }

    @RequestMapping("/{pid}")
    public ModelAndView getPeoduct(@PathVariable Long pid){
        Product product = restTemplate.getForObject("http://product-of-store/product/" + pid, Product.class);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product/productView");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id, ModelAndView modelAndView, HttpServletRequest request){
        if(request.getSession().getAttribute("login_admin") == null){
            return "redirect:/product/";
        }
        Boolean res  = restTemplate.getForObject("http://product-of-store/product/delete/" + id, Boolean.class);
        return "redirect:/product/";
    }

    @RequestMapping(value = "/edit/{pid}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable Long pid, ModelAndView modelAndView, HttpServletRequest resquest){
        if(resquest.getSession().getAttribute("login_admin") == null){
            modelAndView.setViewName("redirect:/product/");
            return modelAndView;
        }
        Product product = restTemplate.getForObject("http://product-of-store/product/" + pid, Product.class);
        modelAndView.addObject("product", product);
        modelAndView.setViewName("product/productEdit");
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(Product product, @RequestParam("imgFile") MultipartFile imgFile, ModelAndView modelAndView, HttpServletRequest request) throws IOException {
        System.out.println("product is " + JSON.toJSONString(product) );
        System.out.println("old filename is " + imgFile.getOriginalFilename());
        String ext = StringUtils.substringAfter(imgFile.getOriginalFilename(), ".");
        Long time = System.currentTimeMillis();
        String newName = time + "." + ext;
        String path = request.getSession().getServletContext().getRealPath("/upload");
        System.out.println("path is " + path);
        File destFile = new File(path + File.separator + newName);
        imgFile.transferTo(destFile);
        product.setImg("/upload/" + newName);

        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        String str = JSON.toJSONString(product);
        requestEntity.add("jsonString", str);
        Boolean res = restTemplate.postForObject("http://product-of-store/product/edit", requestEntity, Boolean.class);
        modelAndView.setViewName("redirect:/product/");
        return modelAndView;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String add(){
        return "product/productNew";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String add(Product product, @RequestParam("imgFile") MultipartFile imgFile, HttpServletRequest request) throws IOException {
        System.out.println("product is " + JSON.toJSONString(product));
        System.out.println("old filename is " + imgFile.getOriginalFilename());
        String ext = StringUtils.substringAfter(imgFile.getOriginalFilename(), ".");
        Long time = System.currentTimeMillis();
        String newName = time + "." + ext;
        String path = request.getSession().getServletContext().getRealPath("/upload");
        System.out.println("path is " + path);
        File destFile = new File(path + File.separator + newName);
        imgFile.transferTo(destFile);
        product.setImg(time + "");
        Boolean res = restTemplate.getForObject("http://product-of-store/product/add/{productString}/" + ext, Boolean.class, JSON.toJSONString(product));
        return "redirect:/product/";
    }


//    @GetMapping("/sale/{pid}/{count}")
//    public Product sale(@PathVariable Long pid, @PathVariable int count){
//        AjaxResult ajaxResult = restTemplate.getForObject("http://product-of-store/product/sale/" + pid + "/" + count, AjaxResult.class);
//        return null;
//    }
//
//    @RequestMapping(value = "/listAll")
//    public ModelAndView listAll(ModelAndView model, HttpServletRequest request){
//        Page page = restTemplate.getForObject("http://product-of-store/product/listAll", Page.class);
//        model.addObject("page", page);
//        model.setViewName("product/productList");
//        return model;
//    }
//
//
//
//
//
//
//
//    @RequestMapping("/insert/{}")
//    public AjaxResult insert(@RequestBody Product product){
////        AjaxResult ajaxResult = restTemplate.getForObject("http://product-of-store/product/insert/", AjaxResult.class);
//        return null;
//    }

}
