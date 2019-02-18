package com.ypf.cn.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ypf.cn.dao.UserMapper;
import com.ypf.cn.domain.User;
import com.ypf.cn.domain.Users;

@Service
public class UserService implements UserMapper {
	@Autowired
	UserMapper userMapper;

	@Override
	public int insert(User record) {
		return userMapper.insert(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insertSelective(User record) {
		return userMapper.insertSelective(record);
	}

	@Override
	public User selectByPrimaryKey(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		return userMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKey(User record) {
		return userMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Users> selectByMap(Map map) {
		return userMapper.selectByMap(map);
	}

	@Override
	public int findCountByCondition(Map map) {
		return userMapper.findCountByCondition(map);
	}
}
