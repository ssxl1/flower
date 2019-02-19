package com.ypf.cn.service;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ypf.cn.dao.UserMapper;
import com.ypf.cn.domain.User;
import com.ypf.cn.domain.Users;

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
	public List<Users> selectByMap(Map map) {
		return userMapper.selectByMap(map);
	}

	@Override
	public int findCountByCondition(Map map) {
		return userMapper.findCountByCondition(map);
	}
	public Map<String,Object> selectAllUserk(int begin,int length,String jsonString){

		if(!"".equals(jsonString)&&jsonString!=null){
			JSONObject json = JSONObject.parseObject(jsonString);
			Map cMap = (Map)json;
			if (cMap != null && !cMap.isEmpty()) {
				Iterator it = cMap.keySet().iterator();
				while(it.hasNext()){
					String name = (String)it.next();
					if(name.equals("type")){//类型查询
					}else if(name.equals("author")){
						try {
							/*criteria.andBookauthorLike("%"+ java.net.URLDecoder.decode((String)cMap.get(name),"UTF-8") +"%");*/
						} catch (Exception e) {
							e.printStackTrace();
						}
					}else if(name.equals("shelveTime")){
					}else if(name.equals("borrow")){
					}
				}
			}
		}


		return null;
		
	}
}
