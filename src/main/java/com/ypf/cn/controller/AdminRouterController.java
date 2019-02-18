package com.ypf.cn.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ypf.cn.domain.Menus;
import com.ypf.cn.service.MenuService;
import com.ypf.cn.util.StringUtil;

@Controller
public class AdminRouterController {
	@Autowired
	MenuService menuService;
	//后台login
	@RequestMapping("/admin_login.html")
	public String admin_indexs(@RequestParam(value="description",required=false) String description,HttpServletRequest request) {
		
	return "views/admin/login";
	}
	//查询对应班级学生
	@RequestMapping("/classstudent_list.html")
	public String classstudent_list(@RequestParam(value="cid",required=false) Integer cid,HttpServletRequest request) {
		request.setAttribute("cid", cid);
		if(cid!=null){
			request.getSession().setAttribute("cid", cid);
		}
	return "views/admin/classstudent_list";
	}
	
	//后台首页
	@RequestMapping("/admin_index.html")
	public String admin_index(@RequestParam(value="description",required=false) String description,HttpServletRequest request) {
		Map map = new HashMap();
		String falg="";
		int rid=0;
    	//获取session
    	HttpSession   session   =   request.getSession();  
    	// 获取session中所有的键值
    		Enumeration<?> enumeration = session.getAttributeNames();
    	// 遍历enumeration中的
    		while (enumeration.hasMoreElements()) {
	    	// 获取session键值
			String name = enumeration.nextElement().toString();
				// 根据键值取session中的值
				if(name.equals("roleid")){
					Object value = session.getAttribute(name);
					rid=(int)  request.getSession().getAttribute("roleid");
					// 打印结果
					if(rid>0){
						map.put("rid",rid);
					}
					falg="sucess";
	    			System.out.println("<B>" + name + "</B>=" + value + "<br>/n");
				}
			}
		
    	if(!falg.equals("sucess")){
    		return "views/admin/login";
    	}else{
    		map.put("description",description);
        	if(!StringUtil.isEmpty(description)) {
        		System.out.println(description);
        		map.put("description",description);
        	}
        	List<Menus> list= menuService.selectByJoin(map);
    		request.setAttribute("list", list);
    		return "views/admin/admin_index";
    	}	
		
	
	}
	//角色列表
	@RequestMapping("/rolelist.html")
	public String admin_indexs(){
		return "views/admin/rolelist";
	}
	//信息
	@RequestMapping("/arts_list.html")
	public String arts_list(){
		return "views/admin/arts_list";
	}
		//信息child_list
		@RequestMapping("/child_list.html")
		public String child_list(@RequestParam(value="menuid",required=false) Integer menuid,HttpServletRequest request){
			request.setAttribute("menuid", menuid);
			if(menuid!=null){
				request.getSession().setAttribute("menuid", menuid);
			}
			return "views/admin/child_list";
		}
		//报表统计
		@RequestMapping("/excel_list.html")
		public String map(){
			return "views/admin/excel_list";
		}
	//新增 角色
	@RequestMapping("/add_role.html")
	public String add_role(){
		return "views/admin/add_role";
	}
	  //管理员管理页面
		@RequestMapping("/adminlist.html")
		public String adminlist(){
			return "views/admin/adminlist";
		}
		//新增 user admin
		@RequestMapping("/add_users.html")
		public String add_user(){
			return "views/admin/add_users";
		}
		//新增  add_menus
		@RequestMapping("/add_menus.html")
		public String add_menus(){
			return "views/admin/add_menus";
		}
		//新增 add_class  .html
		@RequestMapping("/add_class.html")
		public String add_class(){
			return "views/admin/add_class";
		}
		//新增 add_arts 
		@RequestMapping("/add_arts.html")
		public String add_arts(){
			return "views/admin/add_arts";
		}
				
		//新增  add_ins.html
		@RequestMapping("/add_ins.html")
		public String add_ins(){
			return "views/admin/add_ins";
		}
		//新增  add_ins.html
		@RequestMapping("/add_position.html")
		public String add_position(){
			return "views/admin/add_position";
		}
		//新增  add_news.html
		@RequestMapping("/add_news.html")
		public String add_news(){
			return "views/admin/add_news";
		}
		//新增  add_comment.html
		@RequestMapping("/add_comment.html")
		public String add_comment(){
			return "views/admin/add_comment";
		}
		//新增  add_video.html
		@RequestMapping("/add_video.html")
		public String add_video(){
			return "views/admin/add_video";
		}
		 //管理员管理页面
		@RequestMapping("/normaluser.html")
		public String normaluser(){
			return "views/admin/normaluser";
		}
		
		 //节点管理页面
		@RequestMapping("/menulist.html")
		public String node(){
			return "views/admin/menu_list";
		}
		
		 //班级管理页面
		@RequestMapping("/class_list.html")
		public String class_list(){
			return "views/admin/class_list";
		}
		 //乐器管理页面
		@RequestMapping("/ins_list.html")
		public String ins_list(){
			return "views/admin/ins_list";
		}
		//乐器管理页面
		@RequestMapping("/position_list.html")
		public String position_list(){
			return "views/admin/position_list";
		}
		//news理页面 /welcome.html
		@RequestMapping("/news_list.html")
		public String news_list(){
			return "views/admin/news_list";
		}
		//news理页面 /welcome.html
			@RequestMapping("/welcome.html")
			public String welcome(){
				return "views/admin/welcome";
			}
		@RequestMapping("/video_check.html")
		public String video_check(@RequestParam(value="path",required=false) String path,HttpServletRequest request){
			if(StringUtil.isNotEmpty(path)){
				request.setAttribute("path", path);
			}
			return "views/admin/video_check";
		}
		
		//comment理页面 video_check.html
		@RequestMapping("/comment_list.html")
		public String comment_list(){
			return "views/admin/comment_list";
		}
		
		//视频管理页面 video_list.html
		@RequestMapping("/video_list.html")
		public String video_list(){
			return "views/admin/video_list";
		}
		//审核简历管理页面
		@RequestMapping("/check.html")
		public String check(){
			return "views/admin/check";
		}
		//审核简历管理页面
		@RequestMapping("/teacher.html")
		public String teacher(){
			return "views/admin/teacher";
		}
		/*@RequestMapping("/{path}.html")
		public String normaluser(@PathVariable(value="path") String path){
			
			String path=""
			return "views/admin/normaluser";
		}*/
		
	
	
	
	
}
