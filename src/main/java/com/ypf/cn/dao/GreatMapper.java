package com.ypf.cn.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ypf.cn.domain.Great;
import com.ypf.cn.domain.Instrument;
@Mapper //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
public interface GreatMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Great record);

    int insertSelective(Great record);

    Great selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Great record);

    int updateByPrimaryKey(Great record);
    //多条件查询
    List<Great> selectByMap(Map map);
    
    //获得总记录数
     int  findcountbycondition(Map map);
}