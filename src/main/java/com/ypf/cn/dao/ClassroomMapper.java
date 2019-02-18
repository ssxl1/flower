package com.ypf.cn.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ypf.cn.domain.Classroom;
@Mapper //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
public interface ClassroomMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Classroom record);

    int insertSelective(Classroom record);

    Classroom selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Classroom record);

    int updateByPrimaryKey(Classroom record);
    
    int updateByStatus(Classroom record);
    
    List<Classroom> selectByJoin(Map map);
    //多条件查询
    List<Classroom> selectByMap(Map map);
    
    //获得总记录数
     int  findcountbycondition(Map map);
     
     List<Classroom> selectByJoinDetail(Map map);
     
    
}