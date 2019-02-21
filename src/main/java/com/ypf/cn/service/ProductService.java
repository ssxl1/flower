package com.ypf.cn.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ypf.cn.dao.ProductMapper;
import com.ypf.cn.domain.Product;

@Service
public class ProductService implements ProductMapper{
	@Autowired
	ProductMapper productMapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return productMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Product record) {
		// TODO Auto-generated method stub
		return productMapper.insert(record);
	}

	@Override
	public int insertSelective(Product record) {
		// TODO Auto-generated method stub
		return productMapper.insertSelective(record);
	}

	@Override
	public Product selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return productMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Product record) {
		// TODO Auto-generated method stub
		return productMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Product record) {
		// TODO Auto-generated method stub
		return productMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Product> selectByMap(Map map) {
		// TODO Auto-generated method stub
		return productMapper.selectByMap(map);
	}

	@Override
	public int findcountbycondition(Map map) {
		// TODO Auto-generated method stub
		return productMapper.findcountbycondition(map);
	}

}
