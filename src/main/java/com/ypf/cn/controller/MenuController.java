package com.ypf.cn.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ypf.cn.dao.Middle_rolemenuMapper;
import com.ypf.cn.domain.Menus;
import com.ypf.cn.domain.Middle_rolemenu;
import com.ypf.cn.domain.Users;
import com.ypf.cn.service.ChildMenuService;
import com.ypf.cn.service.MenuService;
import com.ypf.cn.service.RoleMenuService;
import com.ypf.cn.util.PageUtil;
import com.ypf.cn.util.StringUtil;

@Controller
public class MenuController {

	@Autowired
	MenuService menusService;
	@Autowired
	RoleMenuService roleMenuService ;
	@Autowired
	ChildMenuService childMenuService;
	/**
     * 根据用户id获取用户
     * @return
     */
	 @RequestMapping(value = "/menus_update")
    public String menussupdate(@RequestParam(value="id",required=false) Integer id,HttpServletRequest request) {
		 Menus menus=menusService.selectByPrimaryKey(id);
    	request.setAttribute("menus", menus);
    	return "views/admin/update_menus";
    }
	 
	 
    /**
     * 用户 物理删除/menuss/delete
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/menus_delete")
    public Map deletemenuss(@RequestParam(value="id",required=false) Integer id)
    {
    	Map mapjson = new HashMap();
    	if(id>0) {
			int result=menusService.deleteByPrimaryKey(id);
			//也删除 对应的子菜单
			childMenuService.deleteByMenuid(id);
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
    @ResponseBody
    @RequestMapping(value ="/loadmenus")
    public Map selectmenusslist(@RequestParam(value="roleid",required=false) Integer roleid){
    	Map mapjson = new HashMap();
    	Map map = new HashMap();
    	List<Menus> list= menusService.selectByMap(map);
	 	mapjson.put("code", 0);
		mapjson.put("msg", "");
		mapjson.put("data", list);
		mapjson.put("count", list.size());
    	return mapjson;
    }
    @ResponseBody
    @RequestMapping(value ="/loadupdatemenus")
    public Map selectmenusslists(@RequestParam(value="roleid",required=false) Integer roleid){
    	Map mapjson = new HashMap();
    	Map map = new HashMap();
    	map.put("roleid", roleid);
    	//找到 中间表 menuid =
    	List<Middle_rolemenu> list= roleMenuService.selectByMap(map);
    	
    	List<Menus> alllist= menusService.selectByMap(map);
	 	mapjson.put("code", 0);
		mapjson.put("msg", "");
		mapjson.put("data1", list);
		mapjson.put("count1", list.size());
		mapjson.put("data2", alllist);
		mapjson.put("count2", alllist.size());
		
    	return mapjson;
    }
	
    /**
     * 用户 列表 查询分页功能/menuss/delete
     * @return
     */
    @ResponseBody
    @RequestMapping(value ="/getmenusslist")
    public Map selectmenusslist(@RequestParam(value="id",required=false) Integer id
,@RequestParam(value="text",required=false) String text,
@RequestParam(value="page",required=false) Integer page, 
@RequestParam(value="limit",required=false) Integer limit)
    {
    	Map mapjson = new HashMap();
    	Map map = new HashMap();
    	if(id!=null) {
    		map.put("id",id);
    	}
    	if(!StringUtil.isEmpty(text)) {
    		System.out.println(text);
    		map.put("text",text);
    	}
    	int count=0;
		int startPos=0;
		if(limit<0) {
			limit=2;
		} 
		map.put("limit", limit);
		PageUtil  pageUtil=new PageUtil();
		count=menusService.findcountbycondition(map);
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
		List<Menus> list= menusService.selectByMap(map);
	 	mapjson.put("code", 0);
		mapjson.put("msg", "");
		mapjson.put("data", list);
    	return mapjson;
    }
    /**
     * 用户更新
     * @return  menus_update_status
     */
    @ResponseBody
    @RequestMapping(value ="/updatemenus")
    public Map doupdate(@RequestBody Menus menuss) {
   
    	Map mapjson = new HashMap();
    	if(menuss!=null) {
    		int result=menusService.updateByPrimaryKeySelective(menuss);
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
	@RequestMapping(value="/addmenus")
	public Map addusers( @RequestBody Menus users
			,HttpServletRequest request) {
			Map mapjson = new HashMap();
			int result=menusService.insertSelective(users);
			if(result>0){
				mapjson.put("state", 1);
			}else{
				mapjson.put("state", 0);
			}
	  return mapjson;
	}
    
    
    
}
