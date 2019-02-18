package com.ypf.cn.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ypf.cn.dao.MiddleteacherMapper;
import com.ypf.cn.domain.Middleteacher;
@Service
public class TeacherService implements MiddleteacherMapper {
	@Autowired
	MiddleteacherMapper teacherMapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return teacherMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Middleteacher record) {
		// TODO Auto-generated method stub
		return teacherMapper.insert(record);
	}

	@Override
	public int insertSelective(Middleteacher record) {
		// TODO Auto-generated method stub
		return teacherMapper.insertSelective(record);
	}

	@Override
	public Middleteacher selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return teacherMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Middleteacher record) {
		// TODO Auto-generated method stub
		return teacherMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Middleteacher record) {
		// TODO Auto-generated method stub
		return teacherMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Middleteacher> selectByMap(Map map) {
		// TODO Auto-generated method stub
		return teacherMapper.selectByMap(map);
	}

	@Override
	public int findcountbycondition(Map map) {
		// TODO Auto-generated method stub
		return teacherMapper.findcountbycondition(map);
	}

	@Override
	public int deleteByCid(Integer id) {
		// TODO Auto-generated method stub
		return teacherMapper.deleteByCid(id);
	}

}
