package com.netease.product.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.netease.product.mapper.ProductMapper;
import com.netease.product.po.Product;
import com.netease.product.service.ProductService;
import com.netease.product.vo.AjaxResult;
import com.netease.product.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

/**
 * 功能说明
 *
 * @author wangliang01 on 2018/1/31
 */

@RestController
@RequestMapping("/product")
public class IndexController {

    @Autowired
    private ProductMapper productMapper;

    @Resource
    private ProductService productService;

    @RequestMapping("/{id}")
    public Product getProduct(@PathVariable Long id){
        Product product = productMapper.selectByPrimaryKey(id);
        return product;
    }

    @RequestMapping("/getPage/{page}/{size}")
    public Page<Product> getPage(@PathVariable int page, @PathVariable int size){
        return productService.getPage(page, size);
    }

    @RequestMapping("/getNotBuyedPage/{page}/{size}")
    public Page<Product> getNotBuyedPage(@PathVariable int page, @PathVariable int size){
        return productService.getNotBuyedPage(page, size);
    }


    @RequestMapping("/delete/{id}")
    public Boolean delete(@PathVariable Long id){
        if(productMapper.deleteByPrimaryKey(id) > 0) {
            return true;
        }else{
            return false;
        }
    }

    @RequestMapping("/edit")
    public Boolean edit(String jsonString){
        System.out.println("str is " + jsonString);
        if(jsonString.charAt(jsonString.length()-1) != '}') {
            jsonString = jsonString + "}";
        }
        Product product = JSONObject.parseObject(jsonString, Product.class);
        int i = productMapper.updateByPrimaryKeySelective(product);
        if(i > 0){
            return true;
        }else{
            return false;
        }
    }

    @RequestMapping("/add/{str}/{ext}")
    public Boolean add(@PathVariable String str, @PathVariable String ext){
        System.out.println("str is " + str);
        if(str.charAt(str.length()-1) != '}') {
            str = str + "}";
        }
        Product product = JSONObject.parseObject(str , Product.class);
        product.setImg("/upload/" + product.getImg() + "." + ext);
        int i = productMapper.insertSelective(product);
        if(i > 0 ){
            return true;
        }else{
            return false;
        }
    }

    //某商品已从购物车付款结算
    @GetMapping("/sale/{pid}/{count}")
    public Product sale(@PathVariable Long pid, @PathVariable int count){
        return productService.sale(pid, count);
    }

//
//    @RequestMapping("/listAll")
//    public List<Product> listAll(){
//        return productMapper.listAll();
//    }
//
//
//
//    @RequestMapping("/listNotBuyed")
//    public AjaxResult listNotBuyed(){
//        return AjaxResult.newSuccessResult(productMapper.listNotBuyed());
//    }



//
//    @RequestMapping("/insert/{}")
//    public AjaxResult insert(@RequestBody Product product){
//        productMapper.insertSelective(product);
//        return null;
//    }

    @RequestMapping("/test")
    public void a(){
        Product product = new Product();
        product.setId(new Long(2));
        product.setDescription("简介");
        product.setContent("全文");
        productMapper.updateByPrimaryKeySelective(product);
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}