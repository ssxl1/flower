package com.ypf.cn.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ypf.cn.domain.Partteacher;
import com.ypf.cn.domain.Position;
@Mapper //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
public interface PositionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);
    
    //多条件查询
    List<Position> selectByMap(Map map);
    
    //获得总记录数
    int  findcountbycondition(Map map);
}