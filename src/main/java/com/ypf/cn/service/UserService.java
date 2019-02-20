package com.ypf.cn.service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ypf.cn.dao.UserMapper;
import com.ypf.cn.domain.User;
import com.ypf.cn.domain.Users;
import com.ypf.cn.util.PageUtil;
import com.ypf.cn.util.RestResult;

@Service
public class UserService implements UserMapper {
	@Autowired
	UserMapper userMapper;

	@Override
	public int insert(User record) {
		return userMapper.insert(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insertSelective(User record) {
		return userMapper.insertSelective(record);
	}

	@Override
	public User selectByPrimaryKey(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		return userMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKey(User record) {
		return userMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<User> selectByMap(Map map) {
		return userMapper.selectByMap(map);
	}

	@Override
	public int findCountByCondition(Map map) {
		return userMapper.findCountByCondition(map);
	}

	public RestResult selectAllUser(int limit, int page, String jsonString) {
		Map map = new HashMap<>();
		Map mapjson = new HashMap<>();
		if (!"".equals(jsonString) && jsonString != null) {
			JSONObject json = JSONObject.parseObject(jsonString);
			Map cMap = (Map) json;
			if (cMap != null && !cMap.isEmpty()) {
				Iterator it = cMap.keySet().iterator();
				while (it.hasNext()) {
					String name = (String) it.next();
					if (name.equals("name")) {// 名称查询
						try {
							map.put("name", java.net.URLDecoder.decode((String) cMap.get(name), "UTF-8"));
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}

					} else if (name.equals("author")) {
						try {
							/*
							 * criteria.andBookauthorLike("%"+
							 * java.net.URLDecoder.decode((String)cMap.get(name),"UTF-8") +"%");
							 */
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else if (name.equals("shelveTime")) {
					} else if (name.equals("borrow")) {
					}
				}
			}
		}
		int count = 0;
		int startPos = 0;
		if (limit < 0) {
			limit = 2;
		}
		map.put("limit", limit);
		PageUtil pageUtil = new PageUtil();
		count = userMapper.findCountByCondition(map);
		if (count > 0) {
			pageUtil.setPageSize(limit);
			pageUtil.setTotalPage((int) count);
			mapjson.put("count", count);
		}
		if (page > 0) {
			startPos = (page - 1) * limit;
			map.put("startPos", startPos);
		} else {
			page = 1;
			map.put("startPos", startPos);
		}
		List<User> list = userMapper.selectByMap(map);
		mapjson.put("data", list);
		String code = "";
		String msg = "";
		if (list.size() >= 0) {
			code = "200";
			msg = "查询成功";
		} else {
			code = "500";
			msg = "查询error或无符合条件的数据";
		}
		RestResult result = new RestResult<>(code, msg, mapjson);

		return result;

	}

	@Override
	public User selectByLogin(User map) {
		// TODO Auto-generated method stub
		return userMapper.selectByLogin(map);
	}
}
