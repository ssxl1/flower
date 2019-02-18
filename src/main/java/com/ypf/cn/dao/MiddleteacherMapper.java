package com.ypf.cn.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ypf.cn.domain.Middleteacher;
@Mapper //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
public interface MiddleteacherMapper {
    int deleteByPrimaryKey(Integer id);
    
    int deleteByCid(Integer id);
    int insert(Middleteacher record);

    int insertSelective(Middleteacher record);

    Middleteacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Middleteacher record);

    int updateByPrimaryKey(Middleteacher record);
    
    //多条件查询
    List<Middleteacher> selectByMap(Map map);
    
    //获得总记录数
    int  findcountbycondition(Map map);
}