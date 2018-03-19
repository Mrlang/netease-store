package com.netease.product.dao;

import com.netease.product.mapper.ProductMapper;
import com.netease.product.po.Product;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {
    private static final String nameSpace = ProductDao.class.getName();

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    private ProductMapper productMapper;

    public int insert(Product product) {
        return productMapper.insert(product);
    }

    public int insertSelective(Product product) {
        return productMapper.insertSelective(product);
    }

    public int deleteByPrimaryKey(Long id) {
        return productMapper.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKey(Product product) {
        return productMapper.updateByPrimaryKey(product);
    }

    public int updateByPrimaryKeySelective(Product product) {
        return productMapper.updateByPrimaryKeySelective(product);
    }

    public Product selectByPrimaryKey(Long id) {
        return productMapper.selectByPrimaryKey(id);
    }
}