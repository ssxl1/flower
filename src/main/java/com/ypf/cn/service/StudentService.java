package com.ypf.cn.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ypf.cn.dao.MiddlestudentMapper;
import com.ypf.cn.domain.Middlestudent;
@Service
public class StudentService implements MiddlestudentMapper {
	
	@Autowired
	MiddlestudentMapper studentMapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return studentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Middlestudent record) {
		// TODO Auto-generated method stub
		return studentMapper.insert(record);
	}

	@Override
	public int insertSelective(Middlestudent record) {
		// TODO Auto-generated method stub
		return studentMapper.insertSelective(record);
	}

	@Override
	public Middlestudent selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return studentMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Middlestudent record) {
		// TODO Auto-generated method stub
		return studentMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Middlestudent record) {
		// TODO Auto-generated method stub
		return studentMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Middlestudent> selectByMap(Map map) {
		// TODO Auto-generated method stub
		return studentMapper.selectByMap(map);
	}

	@Override
	public int findcountbycondition(Map map) {
		// TODO Auto-generated method stub
		return studentMapper.findcountbycondition(map);
	}

}
