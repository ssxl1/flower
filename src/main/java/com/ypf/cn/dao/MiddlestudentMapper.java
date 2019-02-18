package com.ypf.cn.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ypf.cn.domain.Comment;
import com.ypf.cn.domain.Middlestudent;
@Mapper //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
public interface MiddlestudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Middlestudent record);

    int insertSelective(Middlestudent record);

    Middlestudent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Middlestudent record);

    int updateByPrimaryKey(Middlestudent record);
    
    //多条件查询
    List<Middlestudent> selectByMap(Map map);
    
    //获得总记录数
    int  findcountbycondition(Map map);
}