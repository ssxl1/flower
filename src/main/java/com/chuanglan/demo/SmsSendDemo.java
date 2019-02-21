package com.chuanglan.demo;

import java.io.UnsupportedEncodingException;

import com.alibaba.fastjson.JSON;
import com.chuanglan.sms.request.SmsSendRequest;
import com.chuanglan.sms.response.SmsSendResponse;
import com.chuanglan.sms.util.ChuangLanSmsUtil;

/**
 * 
 * @author tianyh
 * @Description:普通短信发送
 */
public class SmsSendDemo {

	public static final String charset = "utf-8";

	// 请登录zz.253.com 获取创蓝API账号(非登录账号,示例:N1234567)
	public static String account = "N6144211";

	// 请登录zz.253.com 获取创蓝API密码(非登录密码)
	public static String pswd = "N2zUHcCQKs438sd";

	public static void main(String[] args) throws UnsupportedEncodingException {

		// 短信发送的URL 请登录zz.253.com 获取完整的URL接口信息
		String smsSingleRequestServerUrl = "http://smssh1.253.com/msg/send/json";
		
		// 设置您要发送的内容：其中“【】”中括号为运营商签名符号，多签名内容前置添加提交
		String msg = "【253云通讯科技】你好,你的验证码是";
		// 手机号码
		String phone = "";
		// 状态报告
		String report = "true";
		
		msg+=(int)((Math.random()*9+1)*100000);
		msg+="";
		System.out.println(msg);
		SmsSendRequest smsSingleRequest = new SmsSendRequest(account, pswd, msg, phone, report);

		String requestJson = JSON.toJSONString(smsSingleRequest);

		System.out.println("before request string is: " + requestJson);

		String response = ChuangLanSmsUtil.sendSmsByPost(smsSingleRequestServerUrl, requestJson);

		System.out.println("response after request result is :" + response);

		SmsSendResponse smsSingleResponse = JSON.parseObject(response, SmsSendResponse.class);

		System.out.println("response  toString is :" + smsSingleResponse);
		

	}

}
