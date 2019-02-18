package com.ypf.cn.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ypf.cn.dao.UsersMapper;
import com.ypf.cn.dao.VideocourseMapper;
import com.ypf.cn.domain.Videocourse;
@Service
public class VideoService implements VideocourseMapper {
	@Autowired
	VideocourseMapper videocourseMapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return videocourseMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Videocourse record) {
		// TODO Auto-generated method stub
		return videocourseMapper.insert(record);
	}

	@Override
	public int insertSelective(Videocourse record) {
		// TODO Auto-generated method stub
		return videocourseMapper.insertSelective(record);
	}

	@Override
	public Videocourse selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return videocourseMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Videocourse record) {
		// TODO Auto-generated method stub
		return videocourseMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Videocourse record) {
		// TODO Auto-generated method stub
		return videocourseMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Videocourse> selectByMap(Map map) {
		// TODO Auto-generated method stub
		return videocourseMapper.selectByMap(map);
	}

	@Override
	public int findcountbycondition(Map map) {
		// TODO Auto-generated method stub
		return videocourseMapper.findcountbycondition(map);
	}

}
