package com.ypf.cn.dao;

import java.util.List;
import java.util.Map;

import com.ypf.cn.domain.Category;
import com.ypf.cn.domain.Product;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
    
    //多条件查询
    List<Product> selectByMap(Map map);
    
    //获得总记录数
    int  findcountbycondition(Map map);
}