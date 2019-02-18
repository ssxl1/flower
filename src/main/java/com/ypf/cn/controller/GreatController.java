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

import com.ypf.cn.domain.Great;
import com.ypf.cn.domain.Videocourse;
import com.ypf.cn.service.GreatService;
import com.ypf.cn.service.VideoService;
import com.ypf.cn.util.PageUtil;
import com.ypf.cn.util.StringUtil;

@Controller
public class GreatController {
	  //依赖注入
			@Autowired
			GreatService greatService;
			
			@Autowired
			VideoService videoService;
			/**
		     * 根据用户id获取用户
		     * @return
		     */
			 @RequestMapping(value = "/great_update")
		    public String greatsupdate(@RequestParam(value="id",required=false) Integer id,HttpServletRequest request) {
				 Great great=greatService.selectByPrimaryKey(id);
		    	request.setAttribute("great", great);
		    	return "views/admin/update_great";
		    }
			 
			 
		    /**
		     * 用户 物理删除/greats/delete
		     * @return
		     */
		    @ResponseBody
		    @RequestMapping(value = "/great_delete")
		    public Map deletegreats(@RequestParam(value="id",required=false) Integer id)
		    {
		    	Map mapjson = new HashMap();
		    	if(id>0) {
					int result=greatService.deleteByPrimaryKey(id);
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
		     * 用户 列表 查询分页功能/greats/delete
		     * @return
		     */
		    @ResponseBody
		    @RequestMapping(value ="/getgreatslist")
		    public Map selectgreatslist(@RequestParam(value="id",required=false) Integer id
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
				count=greatService.findcountbycondition(map);
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
				List<Great> list= greatService.selectByMap(map);
			 	mapjson.put("code", 0);
				mapjson.put("msg", "");
				mapjson.put("data", list);
		    	return mapjson;
		    }
		    /**
		     * 用户更新
		     * @return  great_update_status
		     */
		    @ResponseBody
		    @RequestMapping(value ="/updategreat")
		    public Map doupdate(@RequestBody Great greats) {
		   
		    	Map mapjson = new HashMap();
		    	if(greats!=null) {
		    		int result=greatService.updateByPrimaryKeySelective(greats);
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
			@RequestMapping(value="/addgreat")
			public Map addusers( @RequestBody Great users
					,HttpServletRequest request) {
		    	
		    		Map map = new HashMap();
					Map mapjson = new HashMap();
					if(users.getVid()>0) {
			    		map.put("vid",users.getVid());
			    	}
					if(users.getUid()>0) {
			    		map.put("uid",users.getUid());
			    	}
					int count=greatService.findcountbycondition(map);
					
					users.setCreatedate(new Date());
					//count<=0 说明此人对视频没点过赞
					if(count<=0){
						//进行点赞操作
						int result=greatService.insertSelective(users);
						if(result>0){
							//对应视频表 点赞数 加一
						Videocourse video=	videoService.selectByPrimaryKey(users.getVid());
						video.setNum(video.getNum()+1);
						videoService.updateByPrimaryKeySelective(video);
							mapjson.put("state", 1);
						}else{
							mapjson.put("state", 0);
						}
					}else{
						//取消点赞
						List<Great> list= greatService.selectByMap(map);
						if(list.size()>0){
							int result=greatService.deleteByPrimaryKey(list.get(0).getId());
							if(result>0) {
								//对应视频表 点赞数 - 1
								Videocourse video=	videoService.selectByPrimaryKey(users.getVid());
								video.setNum(video.getNum()-1);
								videoService.updateByPrimaryKeySelective(video);
								mapjson.put("state", 3);
							}else {
								mapjson.put("state", 4);
							}
						}
						
						
					}
					
					
			  return mapjson;
			}		
}
