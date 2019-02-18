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

import com.ypf.cn.domain.Arts;
import com.ypf.cn.service.ArtsService;
import com.ypf.cn.util.PageUtil;
import com.ypf.cn.util.StringUtil;

@Controller
public class ArtsController {
	@Autowired
	ArtsService artsService;
	
	/**
     * 根据用户id获取用户
     * @return
     */
	 @RequestMapping(value = "/arts_update")
    public String artssupdate(@RequestParam(value="id",required=false) Integer id,HttpServletRequest request) {
		 Arts arts=artsService.selectByPrimaryKey(id);
    	request.setAttribute("arts", arts);
    	return "views/admin/update_arts";
    }
	 
	 
    /**
     * 用户 物理删除/artss/delete
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/arts_delete")
    public Map deleteartss(@RequestParam(value="id",required=false) Integer id)
    {
    	Map mapjson = new HashMap();
    	if(id>0&&id!=1) {
			int result=artsService.deleteByPrimaryKey(id);
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
     * 用户 列表 查询分页功能/artss/delete
     * @return
     */
    @ResponseBody
    @RequestMapping(value ="/getartsslist")
    public Map selectartsslist(@RequestParam(value="id",required=false) Integer id
,@RequestParam(value="title",required=false) String title,
@RequestParam(value="page",required=false) Integer page, 
@RequestParam(value="limit",required=false) Integer limit)
    {
    	Map mapjson = new HashMap();
    	Map map = new HashMap();
    	if(id!=null) {
    		map.put("id",id);
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
		count=artsService.findcountbycondition(map);
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
		List<Arts> list= artsService.selectByMap(map);
	 	mapjson.put("code", 0);
		mapjson.put("msg", "");
		mapjson.put("data", list);
    	return mapjson;
    }
    /**
     * 用户更新
     * @return  arts_update_status
     */
    @ResponseBody
    @RequestMapping(value ="/updatearts")
    public Map doupdate(@RequestBody Arts artss) {
   
    	Map mapjson = new HashMap();
    	if(artss!=null) {
    		int result=artsService.updateByPrimaryKeySelective(artss);
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
	@RequestMapping(value="/addarts")
	public Map addusers( @RequestBody Arts users
			,HttpServletRequest request) {
			Map mapjson = new HashMap();
			users.setCreatedate(new Date());
			users.setStatus("n");
			int result=artsService.insertSelective(users);
			if(result>0){
				mapjson.put("state", 1);
			}else{
				mapjson.put("state", 0);
			}
	  return mapjson;
	}
}
