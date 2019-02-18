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

import com.ypf.cn.domain.Position;
import com.ypf.cn.service.PositionService;
import com.ypf.cn.util.PageUtil;
import com.ypf.cn.util.StringUtil;

@Controller
public class PositionController {

	@Autowired
	PositionService positionService;
	
	/**
     * 根据用户id获取用户
     * @return
     */
	 @RequestMapping(value = "/position_update")
    public String positionsupdate(@RequestParam(value="id",required=false) Integer id,HttpServletRequest request) {
		 Position position=positionService.selectByPrimaryKey(id);
    	request.setAttribute("position", position);
    	return "views/admin/update_position";
    }
	 
	 
    /**
     * 用户 物理删除/positions/delete
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/position_delete")
    public Map deletepositions(@RequestParam(value="id",required=false) Integer id)
    {
    	Map mapjson = new HashMap();
    	if(id>0) {
			int result=positionService.deleteByPrimaryKey(id);
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
     * 用户 列表 查询分页功能/positions/delete
     * @return
     */
    @ResponseBody
    @RequestMapping(value ="/getpositionslist")
    public Map selectpositionslist(@RequestParam(value="id",required=false) Integer id
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
		count=positionService.findcountbycondition(map);
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
	 	mapjson.put("code", 0);
		mapjson.put("msg", "");
		mapjson.put("data", list);
    	return mapjson;
    }
    /**
     * 用户更新
     * @return  position_update_status
     */
    @ResponseBody
    @RequestMapping(value ="/updateposition")
    public Map doupdate(@RequestBody Position positions) {
   
    	Map mapjson = new HashMap();
    	if(positions!=null) {
    		int result=positionService.updateByPrimaryKeySelective(positions);
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
	@RequestMapping(value="/addposition")
	public Map addusers( @RequestBody Position users
			,HttpServletRequest request) {
    		System.out.println(users.getName());
			Map mapjson = new HashMap();
			users.setCeatedate(new Date());
			int result=positionService.insertSelective(users);
			if(result>0){
				mapjson.put("state", 1);
			}else{
				mapjson.put("state", 0);
			}
	  return mapjson;
	}
    
}
