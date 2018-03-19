package com.netease.product.service;

import com.netease.product.mapper.ProductMapper;
import com.netease.product.po.Product;
import com.netease.product.vo.AjaxResult;
import com.netease.product.vo.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 功能说明
 *
 * @author wangliang01 on 2018/2/24
 */
@Service
public class ProductService {

    @Resource
    private ProductMapper productMapper;

    public Page getPage(int page, int size){
        List<Product> productList = productMapper.getPage( (page-1)*size, size);
        int totalCount = productMapper.selectTotalCount();
        Page<Product> pageObj = new Page(page, size);
        pageObj.setResult(productList);
        pageObj.setTotalCount(totalCount);
        return pageObj;
    }

    public Page getNotBuyedPage(int page, int size){
        List<Product> productList = productMapper.getNotBuyedPage( (page-1)*size, size);
        Page<Product> pageObj = new Page(page, size);
        pageObj.setResult(productList);
        pageObj.setTotalCount(productList.size());
        return pageObj;
    }

    public Product sale(Long pid, int count){
        Product product = productMapper.selectByPrimaryKey(pid);
        if(count == 0) {
            return product;
        }
        product.setSaled(count);
        productMapper.updateByPrimaryKeySelective(product);
        return product;
    }
//
//    public AjaxResult edit(){
//        return null;
//    }
//
//    public AjaxResult insert(Product product){
//        int res = productMapper.insertSelective(product);
//        if(res > 0){
//            return AjaxResult.newSuccessResult();
//        }else{
//            return AjaxResult.newFailResult();
//        }
//    }


}
