package com.netease.user.dao;

import com.netease.user.mapper.UserMapper;
import com.netease.user.po.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    private static final String nameSpace = UserDao.class.getName();

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    private UserMapper userMapper;

    public int insert(User user) {
        return userMapper.insert(user);
    }

    public int insertSelective(User user) {
        return userMapper.insertSelective(user);
    }

    public int deleteByPrimaryKey(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKey(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    public int updateByPrimaryKeySelective(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public User selectByPrimaryKey(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}