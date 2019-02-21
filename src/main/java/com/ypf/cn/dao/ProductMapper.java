package com.ypf.cn.dao;

import java.util.List;
import java.util.Map;

import com.ypf.cn.domain.Product;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
    //多条件查询
    List<Product> selectByMap(Map map);
    
    //获得总记录数
    int  findcountbycondition(Map map);
}