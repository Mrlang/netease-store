package com.netease.user;

import com.netease.user.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserApplicationTests {

    @Resource
    UserDao userDao;

    @Test
	public void contextLoads() {
	    System.out.println(userDao.selectByPrimaryKey(new Long(1)));
    }

}
