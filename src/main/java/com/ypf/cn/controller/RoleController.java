package com.ypf.cn.controller;

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
import com.ypf.cn.domain.Middle_rolemenu;
import com.ypf.cn.domain.Role;
import com.ypf.cn.service.RoleMenuService;
import com.ypf.cn.service.RoleService;
import com.ypf.cn.util.PageUtil;
import com.ypf.cn.util.StringUtil;

@Controller
public class RoleController {
	
		//依赖注入
		@Autowired
		RoleService roleService;
		@Autowired
		RoleMenuService rmService;
		/**
	     * 根据用户id获取用户
	     * @return
	     */
	    @RequestMapping(value = "/role_update")
	    public String roleupdate(@RequestParam(value="id",required=false) Integer id,HttpServletRequest request) {
	    	Role role=roleService.selectByPrimaryKey(id);
	    	request.setAttribute("role", role);
	    	return "views/admin/update_role";
	    }
	    /**
	     * 用户 物理删除/role/delete
	     * @return
	     */
	    @ResponseBody
	    @RequestMapping(value ="/role_delete")
	    public Map deleterole(@RequestParam(value="id",required=false) Integer id)
	    {
	    	Map mapjson = new HashMap();
	    	if(id>0) {
				int result=roleService.deleteByPrimaryKey(id);
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
	     * 用户 列表 查询分页功能/role/delete
	     * @return
	     */
	    @ResponseBody
	    @RequestMapping(value ="/getrolelist")
	    public Map selectrolelist(@RequestParam(value="id",required=false) Integer id
	,@RequestParam(value="name",required=false) String name,
	@RequestParam(value="page",required=false) Integer page, 
	@RequestParam(value="limit",required=false) Integer limit)
	    {
	    	Map mapjson = new HashMap();
	    	Map map = new HashMap();
	    	if(id!=null) {
	    		map.put("id",id);
	    	}
	    	if(!StringUtil.isEmpty(name)) {
	    		System.out.println(name);
	    		map.put("name",name);
	    	}
	    	int count=0;
			int startPos=0;
			if(limit<0) {
				limit=2;
			} 
			map.put("limit", limit);
			PageUtil  pageUtil=new PageUtil();
			count=roleService.findcountbycondition(map);
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
			List<Role> list= roleService.selectByMap(map);
		 	mapjson.put("code", 0);
			mapjson.put("msg", "");
			mapjson.put("data", list);
	    	return mapjson;
	    }
	    /**
	     * 用户更新
	     * @return
	     */
	    @ResponseBody
	    @RequestMapping(value ="/updaterole")
	    public Map doupdate(@RequestBody Role role) {
	    	rmService.deleteByRoleid(role.getId());
	    	Map mapjson = new HashMap();
	    	
	    	System.out.println(role.getName());
			System.out.println(role.getStatus());
			String [] ids= role.getStatus().split(",");
			int roleid=role.getId();
			for (int i = 0; i < ids.length; i++) {
				String id = ids[i];
				Middle_rolemenu rolemenu=new Middle_rolemenu();
				rolemenu.setMenuid(Integer.parseInt(id));
				rolemenu.setRoleid(roleid);
				rolemenu.setStatus("y");
				rolemenu.setDescription(role.getName());
				rmService.insertSelective(rolemenu);
			}
	    	
	    	if(role!=null) {
	    		role.setStatus("y");
	    		int result=roleService.updateByPrimaryKeySelective(role);
	    		if(result>0){
	    			mapjson.put("state", 1);
				}else{
					mapjson.put("state", 0);
				}
	    		
	    	}else {
	    		mapjson.put("state", 0);
	    	}
	    	return mapjson;
	    	
	    }
	    
	    @ResponseBody
		@RequestMapping(value="/addrole")
		public Map addrole( @RequestBody Role role
				,HttpServletRequest request) {
				Map mapjson = new HashMap();
				System.out.println(role.getName());
				System.out.println(role.getStatus());
				String [] ids= role.getStatus().split(",");
				
				/*Role role=new Role();*/
				role.setStatus("y");
				int result=roleService.insertSelective(role);
				int roleid=role.getId();
				for (int i = 0; i < ids.length; i++) {
					String id = ids[i];
					Middle_rolemenu rolemenu=new Middle_rolemenu();
					rolemenu.setMenuid(Integer.parseInt(id));
					rolemenu.setRoleid(roleid);
					rolemenu.setStatus("y");
					rolemenu.setDescription(role.getName());
					rmService.insertSelective(rolemenu);
				}
				if(roleid>0){
					mapjson.put("state", "sucess");
				}else{
					mapjson.put("state", "error");
				}
		  return mapjson;
		}
		
}
