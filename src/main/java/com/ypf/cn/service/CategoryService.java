package com.ypf.cn.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ypf.cn.dao.CategoryMapper;
import com.ypf.cn.dao.UserMapper;
import com.ypf.cn.domain.Category;
import com.ypf.cn.domain.Product;

@Service
public class CategoryService implements CategoryMapper{
	@Autowired
	CategoryMapper categoryMapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return categoryMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Category record) {
		return categoryMapper.insert(record);
	}

	@Override
	public int insertSelective(Category record) {
		return categoryMapper.insertSelective(record);
	}

	@Override
	public Category selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return categoryMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Category record) {
		// TODO Auto-generated method stub
		return categoryMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Category record) {
		// TODO Auto-generated method stub
		return categoryMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Product> selectByMap(Map map) {
		// TODO Auto-generated method stub
		return categoryMapper.selectByMap(map);
	}

	@Override
	public int findcountbycondition(Map map) {
		// TODO Auto-generated method stub
		return categoryMapper.findcountbycondition(map);
	}

}
