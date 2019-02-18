package com.ypf.cn.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ypf.cn.domain.Middleteacher;
import com.ypf.cn.domain.Partteacher;
@Mapper //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
public interface PartteacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Partteacher record);

    int insertSelective(Partteacher record);

    Partteacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Partteacher record);

    int updateByPrimaryKey(Partteacher record);
    
    //多条件查询
    List<Partteacher> selectByMap(Map map);
    
    //获得总记录数
    int  findcountbycondition(Map map);
}