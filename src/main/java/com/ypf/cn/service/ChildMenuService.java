package com.ypf.cn.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ypf.cn.dao.ChildmenusMapper;
import com.ypf.cn.domain.Childmenus;
import com.ypf.cn.domain.Comment;
@Service
public class ChildMenuService implements ChildmenusMapper {
	@Autowired
	ChildmenusMapper childmenusMapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return childmenusMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Childmenus record) {
		return childmenusMapper.insert(record);
	}

	@Override
	public int insertSelective(Childmenus record) {
		return childmenusMapper.insertSelective(record);
	}

	@Override
	public Childmenus selectByPrimaryKey(Integer id) {
		return childmenusMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Childmenus record) {
		return childmenusMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Childmenus record) {
		return childmenusMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Childmenus> selectByMap(Map map) {
		return childmenusMapper.selectByMap(map);
	}

	@Override
	public int findcountbycondition(Map map) {
		return childmenusMapper.findcountbycondition(map);
	}

	@Override
	public int deleteByMenuid(Integer id) {
		return childmenusMapper.deleteByMenuid(id);
	}

}
