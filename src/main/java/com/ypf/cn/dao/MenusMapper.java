package com.ypf.cn.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ypf.cn.domain.Comment;
import com.ypf.cn.domain.Menus;
@Mapper //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
public interface MenusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menus record);

    int insertSelective(Menus record);

    List<Menus> selectByJoin(Map map);
    
    Menus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menus record);

    int updateByPrimaryKey(Menus record);
    //多条件查询
    List<Menus> selectByMap(Map map);
    
    //获得总记录数
    int  findcountbycondition(Map map);
}