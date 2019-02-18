package com.ypf.cn.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ypf.cn.dao.Middle_rolemenuMapper;
import com.ypf.cn.domain.Middle_rolemenu;
@Service
public class RoleMenuService implements Middle_rolemenuMapper {
	@Autowired
	Middle_rolemenuMapper mapper;
	@Override
	public int deleteByPrimaryKey(Integer mid) {
		return mapper.deleteByPrimaryKey(mid);
	}

	@Override
	public int insert(Middle_rolemenu record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(Middle_rolemenu record) {
		return mapper.insertSelective(record);
	}

	@Override
	public Middle_rolemenu selectByPrimaryKey(Integer mid) {
		return mapper.selectByPrimaryKey(mid);
	}

	@Override
	public int updateByPrimaryKeySelective(Middle_rolemenu record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Middle_rolemenu record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Middle_rolemenu> selectByMap(Map map) {
		return mapper.selectByMap(map);
	}

	@Override
	public int findcountbycondition(Map map) {
		return mapper.findcountbycondition(map);
	}

	@Override
	public int deleteByRoleid(Integer mid) {
		// TODO Auto-generated method stub
		return mapper.deleteByRoleid(mid);
	}

}
