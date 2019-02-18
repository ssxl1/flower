package com.ypf.cn.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ypf.cn.dao.ResumeMapper;
import com.ypf.cn.domain.Resume;
@Service
public class ResumeService implements ResumeMapper {
	@Autowired
	ResumeMapper resumeMapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return resumeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Resume record) {
		// TODO Auto-generated method stub
		return resumeMapper.insert(record);
	}

	@Override
	public int insertSelective(Resume record) {
		// TODO Auto-generated method stub
		return resumeMapper.insertSelective(record);
	}

	@Override
	public Resume selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return resumeMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Resume record) {
		// TODO Auto-generated method stub
		return resumeMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Resume record) {
		// TODO Auto-generated method stub
		return resumeMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Resume> selectByMap(Map map) {
		// TODO Auto-generated method stub
		return resumeMapper.selectByMap(map);
	}

	@Override
	public int findcountbycondition(Map map) {
		// TODO Auto-generated method stub
		return resumeMapper.findcountbycondition(map);
	}

}
