package com.ypf.cn.controller;

import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ypf.cn.domain.*;
import com.ypf.cn.service.ChildMenuService;
import com.ypf.cn.util.PageUtil;
import com.ypf.cn.util.StringUtil;

@Controller
public class ChildMenuController {

	@Autowired
	ChildMenuService childMenuService;
	
	/**
     * 根据用户id获取用户
     * @return
     */
	 @RequestMapping(value = "/childMenu_update")
    public String childMenusupdate(@RequestParam(value="id",required=false) Integer id,HttpServletRequest request) {
		 Childmenus childMenu=childMenuService.selectByPrimaryKey(id);
    	request.setAttribute("childMenu", childMenu);
    	return "views/admin/update_childMenu";
    }
	 
	 
    /**
     * 用户 物理删除/childMenus/delete
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/childMenu_delete")
    public Map deletechildMenus(@RequestParam(value="id",required=false) Integer id)
    {
    	Map mapjson = new HashMap();
    	if(id>0) {
			int result=childMenuService.deleteByPrimaryKey(id);
			if(result>0) {
				mapjson.put("state", 1);
			}else {
				mapjson.put("state", 0);
			}
			
		}else {
			mapjson.put("state", 0);
		}
    	
    	return mapjson;
    }
    
	
    /**
     * 用户 列表 查询分页功能/childMenus/delete
     * @return
     */
    @ResponseBody
    @RequestMapping(value ="/getchildMenuslist")
    public Map selectchildMenuslist(@RequestParam(value="id",required=false) Integer id,
    		@RequestParam(value="menuid",required=false) Integer menuid
,@RequestParam(value="title",required=false) String title,
@RequestParam(value="page",required=false) Integer page, 
@RequestParam(value="limit",required=false) Integer limit,HttpServletRequest request)
    {
    	Map mapjson = new HashMap();
    	Map map = new HashMap();
    	if(id!=null) {
    		map.put("id",id);
    	}
    	int menusid=0;
	    	//获取session
	    	HttpSession   session   =   request.getSession();  
	    	// 获取session中所有的键值
	    		Enumeration<?> enumeration = session.getAttributeNames();
	    	// 遍历enumeration中的
	    		while (enumeration.hasMoreElements()) {
	    	// 获取session键值
    		String name = enumeration.nextElement().toString();
    			// 根据键值取session中的值
				if(name.equals("menuid")){
					Object value = session.getAttribute(name);
					menusid=(int) request.getSession().getAttribute("menuid");
					// 打印结果
	    			System.out.println("<B>" + name + "</B>=" + value + "<br>/n");
				}
    			}

    	
    	
    	if(menusid>0){
    		System.out.println(menusid);
    		map.put("menuid",menusid);
    	}
    	if(menuid!=null){
    		map.put("menuid",menuid);
    	}
    	if(!StringUtil.isEmpty(title)) {
    		System.out.println(title);
    		map.put("title",title);
    	}
    	int count=0;
		int startPos=0;
		if(limit<0) {
			limit=2;
		} 
		map.put("limit", limit);
		PageUtil  pageUtil=new PageUtil();
		count=childMenuService.findcountbycondition(map);
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
		List<Childmenus> list= childMenuService.selectByMap(map);
	 	mapjson.put("code", 0);
		mapjson.put("msg", "");
		mapjson.put("data", list);
    	return mapjson;
    }
    /**
     * 用户更新
     * @return  childMenu_update_status
     */
    @ResponseBody
    @RequestMapping(value ="/updatechildMenu")
    public Map doupdate(@RequestBody Childmenus childMenus) {
   
    	Map mapjson = new HashMap();
    	if(childMenus!=null) {
    		int result=childMenuService.updateByPrimaryKeySelective(childMenus);
    		if(result>0){
    			mapjson.put("state", 1);
			}else{
				mapjson.put("state", 0);
			}
    		
    	}else {
    		mapjson.put("state",0);
    	}
    	return mapjson;
    	
    	
    }
    
    @ResponseBody
	@RequestMapping(value="/addchildMenu")
	public Map addusers( @RequestBody Childmenus users
			,HttpServletRequest request) {
			Map mapjson = new HashMap();
			int result=childMenuService.insertSelective(users);
			if(result>0){
				mapjson.put("state", 1);
			}else{
				mapjson.put("state", 0);
			}
	  return mapjson;
	}
	
}
