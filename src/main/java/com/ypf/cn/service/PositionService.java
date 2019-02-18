package com.ypf.cn.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ypf.cn.dao.PositionMapper;
import com.ypf.cn.domain.Position;
@Service
public class PositionService implements PositionMapper {
	@Autowired
	PositionMapper positionMapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return positionMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Position record) {
		// TODO Auto-generated method stub
		return positionMapper.insert(record);
	}

	@Override
	public int insertSelective(Position record) {
		// TODO Auto-generated method stub
		return positionMapper.insertSelective(record);
	}

	@Override
	public Position selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return positionMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Position record) {
		// TODO Auto-generated method stub
		return positionMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Position record) {
		// TODO Auto-generated method stub
		return positionMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Position> selectByMap(Map map) {
		// TODO Auto-generated method stub
		return positionMapper.selectByMap(map);
	}

	@Override
	public int findcountbycondition(Map map) {
		// TODO Auto-generated method stub
		return positionMapper.findcountbycondition(map);
	}

}
