/**generator自动生成类，不允许随意修改，添加字段*/
package com.netease.user.mapper;

import com.netease.user.po.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component(value = "userMapper")
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByCount(@Param("username") String username, @Param("password") String password);

    int update();
}