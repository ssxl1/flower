package com.ypf.cn.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ypf.cn.domain.Instrument;
import com.ypf.cn.domain.News;
@Mapper //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
public interface InstrumentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Instrument record);

    int insertSelective(Instrument record);

    Instrument selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Instrument record);

    int updateByPrimaryKey(Instrument record);
    
    //多条件查询
    List<Instrument> selectByMap(Map map);
    
    //获得总记录数
     int  findcountbycondition(Map map);
    
}