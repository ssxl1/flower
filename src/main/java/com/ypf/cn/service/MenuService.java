package com.ypf.cn.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ypf.cn.dao.MenusMapper;
import com.ypf.cn.domain.Menus;
@Service
public class MenuService implements MenusMapper {
	@Autowired
	MenusMapper menusMapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return menusMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Menus record) {
		// TODO Auto-generated method stub
		return menusMapper.insert(record);
	}

	@Override
	public int insertSelective(Menus record) {
		// TODO Auto-generated method stub
		return menusMapper.insertSelective(record);
	}

	@Override
	public List<Menus> selectByJoin(Map map) {
		// TODO Auto-generated method stub
		return menusMapper.selectByJoin(map);
	}

	@Override
	public Menus selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return menusMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Menus record) {
		// TODO Auto-generated method stub
		return menusMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Menus record) {
		// TODO Auto-generated method stub
		return menusMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Menus> selectByMap(Map map) {
		// TODO Auto-generated method stub
		return menusMapper.selectByMap(map);
	}

	@Override
	public int findcountbycondition(Map map) {
		// TODO Auto-generated method stub
		return menusMapper.findcountbycondition(map);
	}

}
