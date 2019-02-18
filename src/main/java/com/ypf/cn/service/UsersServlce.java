package com.ypf.cn.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ypf.cn.dao.UsersMapper;
import com.ypf.cn.domain.Users;
@Service
public class UsersServlce implements UsersMapper {
	@Autowired
	UsersMapper usersMapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return usersMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Users record) {
		// TODO Auto-generated method stub
		return usersMapper.insert(record);
	}

	@Override
	public int insertSelective(Users record) {
		// TODO Auto-generated method stub
		return usersMapper.insertSelective(record);
	}

	@Override
	public Users selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return usersMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Users record) {
		// TODO Auto-generated method stub
		return usersMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Users record) {
		// TODO Auto-generated method stub
		return usersMapper.updateByPrimaryKey(record);
	}

	@Override
	public Users selectByLogin(Users map) {
		// TODO Auto-generated method stub
		return usersMapper.selectByLogin(map);
	}

	@Override
	public List<Users> selectByMap(Map map) {
		// TODO Auto-generated method stub
		return usersMapper.selectByMap(map);
	}

	@Override
	public int findcountbycondition(Map map) {
		// TODO Auto-generated method stub
		return usersMapper.findcountbycondition(map);
	}

}
