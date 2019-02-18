package com.ypf.cn.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ypf.cn.dao.ClassroomMapper;
import com.ypf.cn.domain.Classroom;
@Service
public class ClassRoomService implements ClassroomMapper {
	
	@Autowired
	ClassroomMapper classroomMapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return classroomMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Classroom record) {
		// TODO Auto-generated method stub
		return classroomMapper.insert(record);
	}

	@Override
	public int insertSelective(Classroom record) {
		// TODO Auto-generated method stub
		return classroomMapper.insertSelective(record);
	}

	@Override
	public Classroom selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return classroomMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Classroom record) {
		// TODO Auto-generated method stub
		return classroomMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Classroom record) {
		// TODO Auto-generated method stub
		return classroomMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByStatus(Classroom record) {
		// TODO Auto-generated method stub
		return classroomMapper.updateByStatus(record);
	}

	@Override
	public List<Classroom> selectByMap(Map map) {
		// TODO Auto-generated method stub
		return classroomMapper.selectByMap(map);
	}

	@Override
	public int findcountbycondition(Map map) {
		// TODO Auto-generated method stub
		return classroomMapper.findcountbycondition(map);
	}

	@Override
	public List<Classroom> selectByJoin(Map map) {
		// TODO Auto-generated method stub
		return classroomMapper.selectByJoin(map);
	}

	@Override
	public List<Classroom> selectByJoinDetail(Map map) {
		// TODO Auto-generated method stub
		return classroomMapper.selectByJoinDetail(map);
	}

}
