package com.ypf.cn.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ypf.cn.dao.ArtsMapper;
import com.ypf.cn.domain.Arts;
@Service
public class ArtsService implements ArtsMapper {
	@Autowired
	ArtsMapper artsMapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return artsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Arts record) {
		// TODO Auto-generated method stub
		return artsMapper.insert(record);
	}

	@Override
	public int insertSelective(Arts record) {
		// TODO Auto-generated method stub
		return artsMapper.insertSelective(record)
		;
	}

	@Override
	public Arts selectByPrimaryKey(Integer id) {
		return artsMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Arts record) {
		return artsMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Arts record) {
		return artsMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Arts> selectByMap(Map map) {
		return artsMapper.selectByMap(map);
	}

	@Override
	public int findcountbycondition(Map map) {
		// TODO Auto-generated method stub
		return artsMapper.findcountbycondition(map);
	}

}
