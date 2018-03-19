/**generator自动生成类，不允许随意修改，添加字段*/
package com.netease.product.mapper;

import com.netease.product.po.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKeyWithBLOBs(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> listAll();

    List<Product> listNotBuyed();

    List<Product> getPage(@Param("begin") int begin, @Param("offset") int offset);

    List<Product> getNotBuyedPage(@Param("begin") int begin, @Param("offset") int offset);

    int selectTotalCount();
}