package com.ypf.cn.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ypf.cn.dao.GreatMapper;
import com.ypf.cn.domain.Great;
import com.ypf.cn.domain.Instrument;
@Service
public class GreatService implements GreatMapper {
	@Autowired
	GreatMapper greatMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return greatMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Great record) {
		// TODO Auto-generated method stub
		return greatMapper.insert(record);
	}

	@Override
	public int insertSelective(Great record) {
		// TODO Auto-generated method stub
		return greatMapper.insertSelective(record);
	}

	@Override
	public Great selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return greatMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Great record) {
		// TODO Auto-generated method stub
		return greatMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Great record) {
		// TODO Auto-generated method stub
		return greatMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Great> selectByMap(Map map) {
		// TODO Auto-generated method stub
		return greatMapper.selectByMap(map);
	}

	@Override
	public int findcountbycondition(Map map) {
		// TODO Auto-generated method stub
		return greatMapper.findcountbycondition(map);
	}

}
