package com.ypf.cn.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ypf.cn.dao.NewsMapper;
import com.ypf.cn.dao.UsersMapper;
import com.ypf.cn.domain.News;
@Service
public class NewsService implements NewsMapper {
	@Autowired
	NewsMapper newsMapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return newsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(News record) {
		// TODO Auto-generated method stub
		return newsMapper.insert(record);
	}

	@Override
	public int insertSelective(News record) {
		// TODO Auto-generated method stub
		return newsMapper.insertSelective(record);
	}

	@Override
	public News selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return newsMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(News record) {
		// TODO Auto-generated method stub
		return newsMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(News record) {
		// TODO Auto-generated method stub
		return newsMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<News> selectByMap(Map map) {
		// TODO Auto-generated method stub
		return newsMapper.selectByMap(map);
	}

	@Override
	public int findcountbycondition(Map map) {
		// TODO Auto-generated method stub
		return newsMapper.findcountbycondition(map);
	}

}
