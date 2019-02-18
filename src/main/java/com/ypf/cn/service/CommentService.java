package com.ypf.cn.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ypf.cn.dao.CommentMapper;
import com.ypf.cn.domain.Comment;
@Service
public class CommentService implements CommentMapper{
	@Autowired
	CommentMapper commentMapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return commentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Comment record) {
		// TODO Auto-generated method stub
		return commentMapper.insert(record);
	}

	@Override
	public int insertSelective(Comment record) {
		// TODO Auto-generated method stub
		return commentMapper.insertSelective(record);
	}

	@Override
	public Comment selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return commentMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Comment record) {
		// TODO Auto-generated method stub
		return commentMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Comment record) {
		// TODO Auto-generated method updateByPrimaryKey
		return commentMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Comment> selectByMap(Map map) {
		// TODO Auto-generated method stub
		return commentMapper.selectByMap(map);
	}

	@Override
	public int findcountbycondition(Map map) {
		// TODO Auto-generated method stub
		return commentMapper.findcountbycondition(map);
	}

	public int updateByIds(Map map) {
		// TODO Auto-generated method stub
		return commentMapper.updateByIds(map);
	}

}
