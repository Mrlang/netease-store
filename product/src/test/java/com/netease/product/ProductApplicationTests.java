package com.netease.product;

import com.netease.product.dao.ProductDao;
import com.netease.product.mapper.ProductMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductApplicationTests {
    @Autowired
    ProductDao dao;
    @Autowired
    private ProductMapper productMapper;
	@Test
	public void contextLoads() {
        productMapper.selectByPrimaryKey(new Long(1));
	}

}
