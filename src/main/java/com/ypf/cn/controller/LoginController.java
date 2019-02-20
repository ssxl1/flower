package com.ypf.cn.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ypf.cn.domain.User;
import com.ypf.cn.service.UserService;
import com.ypf.cn.util.StringUtil;

@Controller
public class LoginController {
	// 依赖注入
	@Autowired
	UserService userService;
	// 请登录zz.253.com 获取创蓝API账号(非登录账号,示例:N1234567)
	public static String account = "N6144211";
	
	// 请登录zz.253.com 获取创蓝API密码(非登录密码)
	public static String pswd = "N2zUHcCQKs438d";
	// 登录
	@ResponseBody
	@RequestMapping(value = "/loginuser")
	public Map register2(@RequestBody User user3, HttpServletRequest request) {
		Map mapjson = new HashMap();

		User user = userService.selectByLogin(user3);

		if (StringUtil.isNotEmpty(user.getName())) {
			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("name", user.getName());
			request.getSession().setAttribute("id", user.getId());
			mapjson.put("code", 200);
		} else {
			mapjson.put("code", 500);
		}
		return mapjson;
	}
	//发送短信验证码
	@ResponseBody
	@RequestMapping(value = "/send")
	public Map send(@RequestParam(value = "tel", required = false) String tel, HttpServletRequest request) {
		Map mapjson = new HashMap();

		return mapjson;
	}
}
