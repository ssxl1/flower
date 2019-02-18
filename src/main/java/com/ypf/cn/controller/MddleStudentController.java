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

import com.ypf.cn.domain.Middlestudent;
import com.ypf.cn.service.StudentService;
import com.ypf.cn.util.PageUtil;
import com.ypf.cn.util.StringUtil;

@Controller
public class MddleStudentController {

	  //依赖注入
			@Autowired
			StudentService  middlestudentService ;
			
			 @RequestMapping(value = "/middlestudent_update")
		    public String middlestudentsupdate(@RequestParam(value="id",required=false) Integer id,HttpServletRequest request) {
				 Middlestudent middlestudent=middlestudentService.selectByPrimaryKey(id);
		    	request.setAttribute("middlestudent", middlestudent);
		    	return "views/admin/update_middlestudent";
		    }
			 
			 
		    /**
		     * 用户 物理删除/middlestudents/delete
		     * @return
		     */
		    @ResponseBody
		    @RequestMapping(value = "/middlestudent_delete")
		    public Map deletemiddlestudents(@RequestParam(value="id",required=false) Integer id)
		    {
		    	Map mapjson = new HashMap();
		    	if(id>0) {
					int result=middlestudentService.deleteByPrimaryKey(id);
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
		     * 用户 列表 查询分页功能/middlestudents/delete
		     * @return
		     */
		    @ResponseBody
		    @RequestMapping(value ="/getmiddlestudentslist")
		    public Map selectmiddlestudentslist(@RequestParam(value="id",required=false) Integer id
		,@RequestParam(value="title",required=false) String title,@RequestParam(value="cid",required=false) Integer cid,
		@RequestParam(value="page",required=false) Integer page, 
		@RequestParam(value="limit",required=false) Integer limit)
		    {
		    	Map mapjson = new HashMap();
		    	Map map = new HashMap();
		    	if(id!=null) {
		    		map.put("id",id);
		    	}
		    	if(cid!=null) {
		    		System.out.println("classid"+title);
		    		map.put("cid",cid);
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
				count=middlestudentService.findcountbycondition(map);
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
				List<Middlestudent> list= middlestudentService.selectByMap(map);
			 	mapjson.put("code", 0);
				mapjson.put("msg", "");
				mapjson.put("data", list);
		    	return mapjson;
		    }
		    /**
		     * 用户更新
		     * @return  middlestudent_update_status
		     */
		    @ResponseBody
		    @RequestMapping(value ="/updatemiddlestudent")
		    public Map doupdate(@RequestBody Middlestudent middlestudents) {
		   
		    	Map mapjson = new HashMap();
		    	if(middlestudents!=null) {
		    		int result=middlestudentService.updateByPrimaryKeySelective(middlestudents);
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
			@RequestMapping(value="/addmiddlestudent")
			public Map addusers( @RequestBody Middlestudent users
					,HttpServletRequest request) {
					Map mapjson = new HashMap();
					int result=middlestudentService.insertSelective(users);
					if(result>0){
						mapjson.put("state", 1);
					}else{
						mapjson.put("state", 0);
					}
			  return mapjson;
			}	
}
