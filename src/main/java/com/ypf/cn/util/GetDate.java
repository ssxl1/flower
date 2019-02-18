package com.ypf.cn.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * 
 * @author 
 *
 */
public class GetDate {

	/**
	 * 得到现在日期或后一天的日期
	 * 
	 * @param type
	 * @return
	 */
	public String get(int num) {
		String date = "";
		int year = 0;
		int month = 0;
		int day = 0;
		Calendar cd = Calendar.getInstance();
		if (num > 0) {
			cd = Calendar.getInstance();
			cd.add(Calendar.DAY_OF_MONTH, +num);
		}
		if (num == 100000000) {
			cd = Calendar.getInstance();
			cd.add(Calendar.DAY_OF_MONTH, -1);
		}
		year = cd.get(Calendar.YEAR);
		month = cd.get(Calendar.MONTH) + 1;
		day = cd.get(Calendar.DATE);
		date = year + "-" + month + "-" + day;
		return date;
	}


	
	
	/**
	 * :: 计算入住日期与退房日期的时间差
	 * 
	 * @param in
	 * @param out
	 * @return
	 */
	public Integer dateDiffer(Date in, Date out) {
		long time = out.getTime() - in.getTime();
		Integer days = (int) Math.floor(time / (24 * 60 * 60 * 1000));
		System.out.println("时间差:" + days);
		return days;
	}

	/**
	 * 根据日期取得星期几
	 * 
	 * @param date
	 *            指定的日期
	 * @return
	 */
	public String getWeek(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
		String week = sdf.format(date);
		String weekDay = "周";
		System.out.println(week);
		switch (week) {
		case "星期一":
			weekDay += "一";
			break;
		case "星期二":
			weekDay += "二";
			break;
		case "星期三":
			weekDay += "三";
			break;
		case "星期四":
			weekDay += "四";
			break;
		case "星期五":
			weekDay += "五";
			break;
		case "星期六":
			weekDay += "六";
			break;
		case "星期日":
			weekDay += "日";
			break;
		}
		return weekDay;
	}

	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");

	public static Date toDate(String string) {
		Date date = null;
		if (string != null && !"".equals(string)) {
			try {
				date = FORMAT.parse(string);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return date;
	}

	public static String toString(Date date) {
		String string = null;
		if (date != null) {
			string = FORMAT.format(date);
		}
		return string;
	}
	
	
	/**
	 * 根据指定的日期得到后几天的数据
	 * 
	 * @return
	 */
	public String getPointDate(String dateString, int num) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yy-MM-dd").parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + num);

		String dayAfter = new SimpleDateFormat("yyyy-MM-dd")
				.format(c.getTime());
		System.out.println("dayAfter:" + dayAfter);
		return dayAfter;

	}
	/**
	* 获得该月第一天
	* @param year
	* @param month
	* @return
	*/
	public static String getFirstDayOfMonth(int year,int month){
	        Calendar cal = Calendar.getInstance();
	        //设置年份
	        cal.set(Calendar.YEAR,year);
	        //设置月份
	        cal.set(Calendar.MONTH, month-1);
	        //获取某月最小天数
	        int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
	        //设置日历中月份的最小天数
	        cal.set(Calendar.DAY_OF_MONTH, firstDay);
	        //格式化日期
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        String firstDayOfMonth = sdf.format(cal.getTime());
	        return firstDayOfMonth;
	    }
	 
	/**
	* 获得该月最后一天
	* @param year
	* @param month
	* @return
	*/
	public static String getLastDayOfMonth(int year,int month){
	        Calendar cal = Calendar.getInstance();
	        //设置年份
	        cal.set(Calendar.YEAR,year);
	        //设置月份
	        cal.set(Calendar.MONTH, month-1);
	        //获取某月最大天数
	        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	        //设置日历中月份的最大天数
	        cal.set(Calendar.DAY_OF_MONTH, lastDay);
	        //格式化日期
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        String lastDayOfMonth = sdf.format(cal.getTime());
	        return lastDayOfMonth;
	    }
	
	
	
	
	
	
}
