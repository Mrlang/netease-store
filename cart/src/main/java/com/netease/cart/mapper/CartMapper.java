/**generator自动生成类，不允许随意修改，添加字段*/
package com.netease.cart.mapper;

import com.netease.cart.po.Cart;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    Cart selectByPid(Long pid);

    int buyOne(Cart cart);

    List<Cart> getNotCleared();

    List<Cart> getCleared();

    int notBuyAll();

    int deleteByPid(int pid);

    int updateCountByPid(Cart record);
}