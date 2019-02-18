package com.ypf.cn.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ypf.cn.domain.Users;
import com.ypf.cn.domain.Videocourse;
@Mapper //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
public interface VideocourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Videocourse record);

    int insertSelective(Videocourse record);

    Videocourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Videocourse record);

    int updateByPrimaryKey(Videocourse record);
    
    //多条件查询
    List<Videocourse> selectByMap(Map map);
    
    //获得总记录数
     int  findcountbycondition(Map map);
}