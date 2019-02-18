package com.ypf.cn.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ypf.cn.dao.CountExcelMapper;
import com.ypf.cn.domain.CountExcel;
@Service
public class CountService implements CountExcelMapper {
	@Autowired
	CountExcelMapper countExcelMapper;
	@Override
	public List<CountExcel> selectByMonth(Map map) {
		return countExcelMapper.selectByMonth(map);
	}

	@Override
	public List<CountExcel> selectByTmonth(Map map) {
		return countExcelMapper.selectByTmonth(map);
	}

	@Override
	public List<CountExcel> selectByYear(Map map) {
		return countExcelMapper.selectByYear(map);
	}

}
