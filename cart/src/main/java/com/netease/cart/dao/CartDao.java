package com.netease.cart.dao;

import com.netease.cart.mapper.CartMapper;
import com.netease.cart.po.Cart;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartDao {
    private static final String nameSpace = CartDao.class.getName();

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    private CartMapper cartMapper;

    public int insert(Cart cart) {
        return cartMapper.insert(cart);
    }

    public int insertSelective(Cart cart) {
        return cartMapper.insertSelective(cart);
    }

    public int deleteByPrimaryKey(Long id) {
        return cartMapper.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKey(Cart cart) {
        return cartMapper.updateByPrimaryKey(cart);
    }

    public int updateByPrimaryKeySelective(Cart cart) {
        return cartMapper.updateByPrimaryKeySelective(cart);
    }

    public Cart selectByPrimaryKey(Long id) {
        return cartMapper.selectByPrimaryKey(id);
    }
}