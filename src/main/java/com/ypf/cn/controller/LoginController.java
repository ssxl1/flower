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

import com.alibaba.fastjson.JSON;
import com.chuanglan.sms.request.SmsSendRequest;
import com.chuanglan.sms.response.SmsSendResponse;
import com.chuanglan.sms.util.ChuangLanSmsUtil;
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
	public static String pswd = "N2zUHcCQKs438sd";
	// 登录
	@ResponseBody
	@RequestMapping(value = "/loginusers")
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
		// 短信发送的URL 请登录zz.253.com 获取完整的URL接口信息
		String smsSingleRequestServerUrl = "http://smssh1.253.com/msg/send/json";
		
		// 设置您要发送的内容：其中“【】”中括号为运营商签名符号，多签名内容前置添加提交
		String msg = "【253云通讯科技】你好,你的验证码是";
		// 手机号码
		// 状态报告
		String report = "true";
		
		msg+=(int)((Math.random()*9+1)*100000);
		msg+="";
		System.out.println(msg);
		SmsSendRequest smsSingleRequest = new SmsSendRequest(account, pswd, msg, tel, report);

		String requestJson = JSON.toJSONString(smsSingleRequest);

		System.out.println("before request string is: " + requestJson);

		String response = ChuangLanSmsUtil.sendSmsByPost(smsSingleRequestServerUrl, requestJson);

		System.out.println("response after request result is :" + response);

		SmsSendResponse smsSingleResponse = JSON.parseObject(response, SmsSendResponse.class);

		System.out.println("response  toString is :" + smsSingleResponse);
		return mapjson;
	}
}
