package com.ypf.cn.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ypf.cn.domain.Arts;
import com.ypf.cn.domain.Middle_rolemenu;
@Mapper //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
public interface Middle_rolemenuMapper {
    int deleteByPrimaryKey(Integer mid);
    
    int deleteByRoleid(Integer mid);
    
    int insert(Middle_rolemenu record);

    int insertSelective(Middle_rolemenu record);

    Middle_rolemenu selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(Middle_rolemenu record);

    int updateByPrimaryKey(Middle_rolemenu record);
    
    //多条件查询
    List<Middle_rolemenu> selectByMap(Map map);
    
    //获得总记录数
    int  findcountbycondition(Map map);
}