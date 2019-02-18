package com.ypf.cn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ypf.cn.domain.Arts;
import com.ypf.cn.domain.Classroom;
import com.ypf.cn.domain.Comment;
import com.ypf.cn.domain.News;
import com.ypf.cn.domain.Position;
import com.ypf.cn.domain.Users;
import com.ypf.cn.domain.Videocourse;
import com.ypf.cn.service.ArtsService;
import com.ypf.cn.service.ClassRoomService;
import com.ypf.cn.service.CommentService;
import com.ypf.cn.service.NewsService;
import com.ypf.cn.service.PositionService;
import com.ypf.cn.service.UserService;
import com.ypf.cn.service.UsersServlce;
import com.ypf.cn.service.VideoService;
import com.ypf.cn.util.PageUtil;
import com.ypf.cn.util.StringUtil;


@Controller
public class RouterController {
	//依赖注入
	@Autowired
	UserService userService;
	
	@Autowired
	VideoService videoService;
	@Autowired
	NewsService newsService;
	@Autowired
	PositionService positionService;
	@Autowired
	ClassRoomService classRoomService;
	@Autowired
	CommentService commentService;
	@Autowired
	ArtsService artsService;
	
	@Autowired
	UsersServlce usersService;
	@RequestMapping("/index.html")
	public String login6(HttpServletRequest request) {
		
		/*
		 * Arts arts= artsService.selectByPrimaryKey(1); request.setAttribute("arts",
		 * arts);
		 */
	return "views/head/index";
	}
	
	@RequestMapping("/video.html")
	public String video(@RequestParam(value="type",required=false) String type
			,@RequestParam(value="name",required=false) String name,
			@RequestParam(value="page",required=false) Integer page, 
			@RequestParam(value="limit",required=false) Integer limit,HttpServletRequest request) {
		Map mapjson = new HashMap();
    	Map map = new HashMap();
    	if(!StringUtil.isEmpty(name)) {
    		System.out.println(name);
    		map.put("name",name);
    		request.setAttribute("name", name);
    	}
    	
    	if(!StringUtil.isEmpty(type)) {
    		System.out.println(type);
    		map.put("type",type);
    	}
    	
    	int count=0;
		int startPos=0;
		limit=3;
		if(limit<0) {
			limit=2;
		} 
		map.put("limit", limit);
		PageUtil  pageUtil=new PageUtil();
		count=videoService.findcountbycondition(map);
		
		request.setAttribute("count", count);
		if(count>0){
			pageUtil.setPageSize(limit);
			pageUtil.setTotalPage((int) count);
			mapjson.put("count", count);
		}
		if(page>0) {
			 startPos=(page-1)*limit;
			map.put("startPos", startPos);
		}else {
			page=1;
			map.put("startPos", startPos);
		}
		List<Videocourse> list= videoService.selectByMap(map);
		
		request.setAttribute("list", list);
		
	return "views/head/video";
	}
	
	@RequestMapping("/position.html")
	public String position(@RequestParam(value="type",required=false) String type
			,@RequestParam(value="name",required=false) String name,
			@RequestParam(value="page",required=false) Integer page, 
			@RequestParam(value="limit",required=false) Integer limit,HttpServletRequest request) {
		Map mapjson = new HashMap();
    	Map map = new HashMap();
    	if(!StringUtil.isEmpty(name)) {
    		System.out.println(name);
    		map.put("name",name);
    		request.setAttribute("name", name);
    	}
    	
    	if(!StringUtil.isEmpty(type)) {
    		System.out.println(type);
    		map.put("type",type);
    	}
    	
    	int count=0;
		int startPos=0;
		limit=3;
		if(limit<0) {
			limit=2;
		} 
		map.put("limit", limit);
		PageUtil  pageUtil=new PageUtil();
		count=videoService.findcountbycondition(map);
		
		request.setAttribute("count", count);
		if(count>0){
			pageUtil.setPageSize(limit);
			pageUtil.setTotalPage((int) count);
			mapjson.put("count", count);
		}
		if(page>0) {
			 startPos=(page-1)*limit;
			map.put("startPos", startPos);
		}else {
			page=1;
			map.put("startPos", startPos);
		}
		List<Position> list= positionService.selectByMap(map);
		
		request.setAttribute("list", list);
		
	return "views/head/position";
	}
	
	
	@RequestMapping("/news.html")
	public String news(@RequestParam(value="type",required=false) String type
			,@RequestParam(value="name",required=false) String name,
			@RequestParam(value="page",required=false) Integer page, 
			@RequestParam(value="limit",required=false) Integer limit,HttpServletRequest request) {
		Map mapjson = new HashMap();
    	Map map = new HashMap();
    	if(!StringUtil.isEmpty(name)) {
    		System.out.println(name);
    		map.put("name",name);
    		request.setAttribute("name", name);
    	}
    	
    	if(!StringUtil.isEmpty(type)) {
    		System.out.println(type);
    		map.put("type",type);
    	}
    	
    	int count=0;
		int startPos=0;
		limit=3;
		if(limit<0) {
			limit=2;
		} 
		map.put("limit", limit);
		PageUtil  pageUtil=new PageUtil();
		count=newsService.findcountbycondition(map);
		
		request.setAttribute("count", count);
		if(count>0){
			pageUtil.setPageSize(limit);
			pageUtil.setTotalPage((int) count);
			mapjson.put("count", count);
		}
		if(page>0) {
			 startPos=(page-1)*limit;
			map.put("startPos", startPos);
		}else {
			page=1;
			map.put("startPos", startPos);
		}
		List<News> list= newsService.selectByMap(map);
		
		request.setAttribute("list", list);
		
	return "views/head/news";
	}
	
	@RequestMapping("/courses.html")
	public String instrument(@RequestParam(value="type",required=false) String type
			,@RequestParam(value="name",required=false) String name,
			@RequestParam(value="page",required=false) Integer page, 
			@RequestParam(value="limit",required=false) Integer limit,HttpServletRequest request) {
		Map mapjson = new HashMap();
    	Map map = new HashMap();
    	if(!StringUtil.isEmpty(name)) {
    		System.out.println(name);
    		map.put("name",name);
    	}
    	
    	if(!StringUtil.isEmpty(type)) {
    		System.out.println(type);
    		map.put("type",type);
    		request.setAttribute("name", type);
    	}
    		map.put("status","已开班");
    	
    	int count=0;
		int startPos=0;
		limit=3;
		if(limit<0) {
			limit=2;
		} 
		map.put("limit", limit);
		PageUtil  pageUtil=new PageUtil();
		count=classRoomService.findcountbycondition(map);
		
		request.setAttribute("count", count);
		if(count>0){
			pageUtil.setPageSize(limit);
			pageUtil.setTotalPage((int) count);
			mapjson.put("count", count);
		}
		if(page>0) {
			 startPos=(page-1)*limit;
			map.put("startPos", startPos);
		}else {
			page=1;
			map.put("startPos", startPos);
		}
		List<Classroom> list= classRoomService.selectByMap(map);
		
		request.setAttribute("list", list);
		
	return "views/head/instrument";
	}
	
	@RequestMapping("/{uid}/info")
	public String info_classroom(@PathVariable("uid") Integer uid
			,@RequestParam(value="name",required=false) String name,
			@RequestParam(value="page",required=false) Integer page, 
			@RequestParam(value="limit",required=false) Integer limit,HttpServletRequest request) {
		Map mapjson = new HashMap();
    	Map map = new HashMap();
    	if(uid!=null){
    		map.put("uid",uid);
    	}
		List<Classroom> list= classRoomService.selectByJoin(map);
		request.setAttribute("list", list);
		
	return "views/head/info_classroom";
	}
	//修改用户信息前台
	@RequestMapping("/{id}/updateinfo")
	public String updateuserinfo(@PathVariable("id") Integer id
			,HttpServletRequest request) {
		Users users=usersService.selectByPrimaryKey(id);
    	request.setAttribute("user", users);
		
	return "views/head/update_users";
	}
	@RequestMapping("/{id}/index")
	public String index(@PathVariable("id") Integer id
			,HttpServletRequest request) {
		Arts arts=	artsService.selectByPrimaryKey(1);
		request.setAttribute("arts", arts);
	return "views/head/index";
		
	}
	
	@RequestMapping("/comment.html")
	public String comment(@RequestParam(value="type",required=false) String type
			,@RequestParam(value="name",required=false) String name,
			@RequestParam(value="page",required=false) Integer page, 
			@RequestParam(value="limit",required=false) Integer limit,HttpServletRequest request) {
		Map mapjson = new HashMap();
    	Map map = new HashMap();
    	if(!StringUtil.isEmpty(name)) {
    		System.out.println(name);
    		map.put("name",name);
    	}
    	
    	if(!StringUtil.isEmpty(type)) {
    		System.out.println(type);
    		map.put("type",type);
    		request.setAttribute("name", type);
    	}
    	map.put("status","已审核");
    	int count=0;
		int startPos=0;
		limit=3;
		if(limit<0) {
			limit=2;
		} 
		map.put("limit", limit);
		PageUtil  pageUtil=new PageUtil();
		count=commentService.findcountbycondition(map);
		
		request.setAttribute("count", count);
		if(count>0){
			pageUtil.setPageSize(limit);
			pageUtil.setTotalPage((int) count);
			mapjson.put("count", count);
		}
		if(page>0) {
			 startPos=(page-1)*limit;
			map.put("startPos", startPos);
		}else {
			page=1;
			map.put("startPos", startPos);
		}
		List<Comment> list= commentService.selectByMap(map);
		
		request.setAttribute("list", list);
		
	return "views/head/comment";
	}
	
	@RequestMapping("/watchvideo.html")
	public String watchvideo(@RequestParam(value="id",required=false) Integer id,HttpServletRequest request) {
		if(id>0){
			Videocourse course=videoService.selectByPrimaryKey(id);
			request.setAttribute("course", course);
		}
		
	return "views/head/watchvideo";
	}
	
	@RequestMapping("/newsdetail.html")
	public String newsdetail(@RequestParam(value="id",required=false) Integer id,HttpServletRequest request) {
		if(id>0){
			News news= newsService.selectByPrimaryKey(id);
			request.setAttribute("news", news);
		}
		
		
	return "views/head/newsdetail";
	}
	@RequestMapping("/position_detail.html")
	public String position_detail(@RequestParam(value="id",required=false) Integer id,HttpServletRequest request) {
		if(id>0){
			Position position= positionService.selectByPrimaryKey(id);
			request.setAttribute("position", position);
		}
		
		
	return "views/head/position_detail";
	}
	@RequestMapping("/courses_detail.html")
	public String courses_detail(@RequestParam(value="id",required=false) Integer id,HttpServletRequest request) {
		if(id>0){
			Map map = new HashMap();
			map.put("id", id);
			Classroom room=classRoomService.selectByJoinDetail(map).get(0);
			request.setAttribute("room", room);
		}
		
		
	return "views/head/courses_detail";
	}
	
	@RequestMapping("/news_detail.html")
	public String news_detail(@RequestParam(value="id",required=false) Integer id,HttpServletRequest request) {
		if(id>0){
			Map map = new HashMap();
			map.put("id", id);
			News news=newsService.selectByPrimaryKey(id);
			request.setAttribute("news", news);
		}
		
	return "views/head/news_detail";
	}
	@RequestMapping("/register.html")
	public String register() {
	return "views/head/register";
	}
	//跳转填写简历页面
	@RequestMapping("/get_position.html")
	public String get_position(@RequestParam(value="id",required=false) Integer id,HttpServletRequest request) {
		request.setAttribute("pid", id);
	return "views/head/get_position";
	}
	@RequestMapping("/instrument.html")
	public String courses() {
	return "views/head/courses";
	}
	@RequestMapping("/addcomments.html")
	public String addcomments() {
	return "views/head/addcomments";
	}
	@RequestMapping("/blog.html")
	public String blog() {
	return "views/head/blog";
	}
	@RequestMapping("/gallery.html")
	public String gallery() {
	return "views/head/gallery";
	}
	@RequestMapping("/contact.html")
	public String contact() {
	return "views/head/contact";
	}
	
	
	
	@RequestMapping("/login.html")
	public String login() {
	return "views/head/login";
	}
	
	
}
