package com.ypf.cn.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ypf.cn.dao.RoleMapper;
import com.ypf.cn.domain.Role;
@Service
public class RoleService implements RoleMapper {
	@Autowired
	RoleMapper roleMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return roleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Role record) {
		// TODO Auto-generated method stub
		return roleMapper.insert(record);
	}

	@Override
	public int insertSelective(Role record) {
		// TODO Auto-generated method stub
		return roleMapper.insertSelective(record);
	}

	@Override
	public Role selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Role record) {
		// TODO Auto-generated method stub
		return roleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Role record) {
		// TODO Auto-generated method stub
		return roleMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Role> selectByMap(Map map) {
		// TODO Auto-generated method stub
		return roleMapper.selectByMap(map);
	}

	@Override
	public int findcountbycondition(Map map) {
		// TODO Auto-generated method stub
		return roleMapper.findcountbycondition(map);
	}

}
