package com.ypf.cn.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ypf.cn.domain.Arts;
import com.ypf.cn.domain.CountExcel;
import com.ypf.cn.domain.News;
@Mapper //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
public interface CountExcelMapper {
 /*   int deleteByPrimaryKey(Integer id);

    int insert(Arts record);

    int insertSelective(Arts record);

    Arts selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Arts record);

    int updateByPrimaryKey(Arts record);*/
    
    //多条件查询
    List<CountExcel> selectByMonth(Map map);
    
    List<CountExcel> selectByTmonth(Map map);
    
    List<CountExcel> selectByYear(Map map);
    
    
    //获得总记录数
}