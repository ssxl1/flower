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

import com.ypf.cn.domain.News;
import com.ypf.cn.service.NewsService;
import com.ypf.cn.util.PageUtil;
import com.ypf.cn.util.StringUtil;

@Controller
public class NewsController {

	   //依赖注入
		@Autowired
		NewsService newsService;
		/**
	     * 根据用户id获取用户
	     * @return
	     */
		 @RequestMapping(value = "/news_update")
	    public String newssupdate(@RequestParam(value="id",required=false) Integer id,HttpServletRequest request) {
			 News news=newsService.selectByPrimaryKey(id);
	    	request.setAttribute("news", news);
	    	return "views/admin/update_news";
	    }
		 
		 
	    /**
	     * 用户 物理删除/newss/delete
	     * @return
	     */
	    @ResponseBody
	    @RequestMapping(value = "/news_delete")
	    public Map deletenewss(@RequestParam(value="id",required=false) Integer id)
	    {
	    	Map mapjson = new HashMap();
	    	if(id>0) {
				int result=newsService.deleteByPrimaryKey(id);
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
	     * 用户 列表 查询分页功能/newss/delete
	     * @return
	     */
	    @ResponseBody
	    @RequestMapping(value ="/getnewsslist")
	    public Map selectnewsslist(@RequestParam(value="id",required=false) Integer id
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
			count=newsService.findcountbycondition(map);
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
		 	mapjson.put("code", 0);
			mapjson.put("msg", "");
			mapjson.put("data", list);
	    	return mapjson;
	    }
	    /**
	     * 用户更新
	     * @return  news_update_status
	     */
	    @ResponseBody
	    @RequestMapping(value ="/updatenews")
	    public Map doupdate(@RequestBody News newss) {
	   
	    	Map mapjson = new HashMap();
	    	if(newss!=null) {
	    		int result=newsService.updateByPrimaryKeySelective(newss);
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
		@RequestMapping(value="/addnews")
		public Map addusers( @RequestBody News users
				,HttpServletRequest request) {
				Map mapjson = new HashMap();
				users.setCreatedate(new Date());
				int result=newsService.insertSelective(users);
				if(result>0){
					mapjson.put("state", 1);
				}else{
					mapjson.put("state", 0);
				}
		  return mapjson;
		}
		
}
