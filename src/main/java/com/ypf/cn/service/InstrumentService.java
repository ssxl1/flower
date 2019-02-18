package com.ypf.cn.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ypf.cn.dao.InstrumentMapper;
import com.ypf.cn.domain.Instrument;
@Service
public class InstrumentService implements InstrumentMapper {
	@Autowired
	InstrumentMapper instrumentMapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return instrumentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Instrument record) {
		// TODO Auto-generated method stub
		return instrumentMapper.insert(record);
	}

	@Override
	public int insertSelective(Instrument record) {
		// TODO Auto-generated method stub
		return instrumentMapper.insertSelective(record);
	}

	@Override
	public Instrument selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return instrumentMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Instrument record) {
		// TODO Auto-generated method stub
		return instrumentMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Instrument record) {
		// TODO Auto-generated method stub
		return instrumentMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Instrument> selectByMap(Map map) {
		// TODO Auto-generated method stub
		return instrumentMapper.selectByMap(map);
	}

	@Override
	public int findcountbycondition(Map map) {
		// TODO Auto-generated method stub
		return instrumentMapper.findcountbycondition(map);
	}

}
