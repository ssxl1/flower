package com.ypf.cn.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ypf.cn.domain.Childmenus;
import com.ypf.cn.domain.Comment;
@Mapper //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
public interface ChildmenusMapper {
    int deleteByPrimaryKey(Integer id);
    
    int deleteByMenuid(Integer id);
    
    int insert(Childmenus record);

    int insertSelective(Childmenus record);

    Childmenus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Childmenus record);

    int updateByPrimaryKey(Childmenus record);
    
    //多条件查询
    List<Childmenus> selectByMap(Map map);
    
    //获得总记录数
    int  findcountbycondition(Map map);
}