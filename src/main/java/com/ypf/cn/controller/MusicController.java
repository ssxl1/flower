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

import com.ypf.cn.domain.Instrument;
import com.ypf.cn.domain.Users;
import com.ypf.cn.service.InstrumentService;
import com.ypf.cn.util.PageUtil;
import com.ypf.cn.util.StringUtil;

@Controller
public class MusicController {
	@Autowired
	InstrumentService iService;
	
	/**
     * 根据用户id获取用户
     * @return
     */
	 @RequestMapping(value = "/instrument_update")
    public String Instrumentsupdate(@RequestParam(value="id",required=false) Integer id,HttpServletRequest request) {
    	Instrument Instrument=iService.selectByPrimaryKey(id);
    	request.setAttribute("instrument", Instrument);
    	return "views/admin/update_instrument";
    }
	 
	 
    /**
     * 用户 物理删除/Instruments/delete
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/instrument_delete")
    public Map deleteInstruments(@RequestParam(value="id",required=false) Integer id)
    {
    	Map mapjson = new HashMap();
    	if(id>0) {
			int result=iService.deleteByPrimaryKey(id);
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
    @RequestMapping(value ="/getmusic")
    public Map getmusic(@RequestParam(value="id",required=false) Integer id){
    	Map mapjson = new HashMap();
    	Map map = new HashMap();
    	List<Instrument> list= iService.selectByMap(map);
	 	mapjson.put("code", 0);
		mapjson.put("msg", "");
		mapjson.put("data", list);
    	return mapjson;
    }
    /**
     * 用户 列表 查询分页功能/Instruments/delete
     * @return
     */
    @ResponseBody
    @RequestMapping(value ="/getInstrumentslist")
    public Map selectInstrumentslist(@RequestParam(value="id",required=false) Integer id
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
		count=iService.findcountbycondition(map);
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
		List<Instrument> list= iService.selectByMap(map);
	 	mapjson.put("code", 0);
		mapjson.put("msg", "");
		mapjson.put("data", list);
    	return mapjson;
    }
    /**
     * 用户更新
     * @return  Instrument_update_status
     */
    @ResponseBody
    @RequestMapping(value ="/updateinstrument")
    public Map doupdate(@RequestBody Instrument Instruments) {
   
    	Map mapjson = new HashMap();
    	if(Instruments!=null) {
    		int result=iService.updateByPrimaryKeySelective(Instruments);
    		if(result>0){
    			mapjson.put("state", "sucess");
			}else{
				mapjson.put("state", "error");
			}
    		
    	}else {
    		mapjson.put("state","error");
    	}
    	return mapjson;
    	
    	
    }
    
    @ResponseBody
	@RequestMapping(value="/addinsnstrument")
	public Map addusers( @RequestBody Instrument users
			,HttpServletRequest request) {
    		System.out.println(users.getName());
			Map mapjson = new HashMap();
			users.setCreatedate(new Date());
			users.setStatus("normal");
			int result=iService.insertSelective(users);
			if(result>0){
				mapjson.put("state", 1);
			}else{
				mapjson.put("state", 0);
			}
	  return mapjson;
	}
    
}
