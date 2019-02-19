package com.ypf.cn.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ypf.cn.domain.User;
import com.ypf.cn.service.UserService;
import com.ypf.cn.util.RestResult;

@RestController
public class UsersController {
	// 依赖注入 
	@Autowired
	UserService userService;

	@RequestMapping(value = "/rest/User", method = RequestMethod.POST, produces = "application/json")
	public RestResult saveUser(@RequestBody User user) {

		int result = userService.insertSelective(user);
		String code = "";
		String msg = "";
		if (result > 0) {
			code = "200";
			msg = "新增成功";
		} else {
			code = "500";
			msg = "新增error";
		}
		RestResult<Object> results = new RestResult<>(code, msg);
		return results;
	}

	@RequestMapping(value = "/rest/User/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public RestResult deleteUser(@PathVariable int id) {

		int result = userService.deleteByPrimaryKey(id);
		String code = "";
		String msg = "";
		if (result > 0) {
			code = "200";
			msg = "删除成功";
		} else {
			code = "500";
			msg = "删除error";
		}
		RestResult<Object> results = new RestResult<>(code, msg);
		return results;
	}

	@RequestMapping(value = "/rest/User/{id}", method = RequestMethod.PUT, produces = "application/json")
	public RestResult updateUser(@PathVariable int id, @RequestBody User user) {
		user.setId(id);
		int result = userService.deleteByPrimaryKey(id);
		
		
		String code = "";
		String msg = "";
		if (result > 0) {
			code = "200";
			msg = "更新成功";
		} else {
			code = "500";
			msg = "更新error";
		}
		RestResult<Object> restResult = new RestResult<>(code, msg);
		return restResult;

	}

	@RequestMapping(value = "/rest/User/{id}", method = RequestMethod.GET, produces = "application/json")
	public RestResult<Object> getUser(@PathVariable int id) {
		User user = userService.selectByPrimaryKey(id);
		String code = "";
		String msg = "";
		if (user != null) {
			code = "200";
			msg = "查询成功";
		} else {
			code = "500";
			msg = "查询error";
		}
		RestResult<Object> restResult = new RestResult<>(code, msg, user);
		return restResult;
	}

}
