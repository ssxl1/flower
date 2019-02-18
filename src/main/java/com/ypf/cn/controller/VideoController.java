package com.ypf.cn.controller;

import java.io.File;
import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;

import com.ypf.cn.domain.Videocourse;
import com.ypf.cn.service.VideoService;
import com.ypf.cn.util.PageUtil;
import com.ypf.cn.util.StringUtil;

@Controller
public class VideoController {
	//依赖注入
	@Autowired
	VideoService videoService;
	
	/**
     * 根据用户id获取用户
     * @return
     */
	 @RequestMapping(value = "/video_update")
    public String videosupdate(@RequestParam(value="id",required=false) Integer id,HttpServletRequest request) {
		 Videocourse video=videoService.selectByPrimaryKey(id);
    	request.setAttribute("video", video);
    	return "views/admin/update_video";
    }
	 
	 
    /**
     * 用户 物理删除/videos/delete
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/video_delete")
    public Map deletevideos(@RequestParam(value="id",required=false) Integer id)
    {
    	Map mapjson = new HashMap();
    	if(id>0) {
			int result=videoService.deleteByPrimaryKey(id);
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
     * 用户 列表 查询分页功能/videos/delete
     * @return
     */
    @ResponseBody
    @RequestMapping(value ="/getvideoslist")
    public Map selectvideoslist(@RequestParam(value="id",required=false) Integer id
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
		count=videoService.findcountbycondition(map);
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
		List<Videocourse> list= videoService.selectByMap(map);
	 	mapjson.put("code", 0);
		mapjson.put("msg", "");
		mapjson.put("data", list);
    	return mapjson;
    }
    /**
     * 用户更新
     * @return  video_update_status
     */
    @ResponseBody
    @RequestMapping(value ="/updatevideo")
    public Map doupdate(@RequestBody Videocourse videos) {
    	Map mapjson = new HashMap();
    	if(videos.getId()>0) {
    		int result=videoService.updateByPrimaryKeySelective(videos);
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
   // <!-- id, name, status, price, num, createdate, videopath, descirption, type -->
    @ResponseBody
	@RequestMapping(value="/addvideo")
	public Map addusers(@RequestParam(value="name",required=false) String name, 
			@RequestParam(value="price",required=false) Integer price,
			@RequestParam(value="num",required=false) Integer num,
			@RequestParam(value="descirption",required=false) String descirption, 
			@RequestParam(value="type",required=false) String type, 
			 MultipartFile file)
            throws Exception { 
    	Videocourse videos=new Videocourse();
    	
    	videos.setCreatedate(new Date());
		videos.setStatus("y");
		videos.setName(name);
		videos.setPrice(price);
		videos.setNum(num);
		videos.setDescirption(descirption);
		videos.setType(type);
			Map mapjson = new HashMap();
			
			if(file.isEmpty()){
				mapjson.put("state", 1);
	        }
	        String filename = file.getOriginalFilename();
	        
	        //上传文件路径
            String path12 = "D:\\work\\file\\";
            String path=  "E:\\Users\\Administrator\\Workspaces\\MyEclipse 2017 CI\\fower\\src\\main\\resources\\static\\video";
            File filepath = new File(path,filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) { 
                filepath.getParentFile().mkdirs();
            }
          
	        try {
	        	  //将上传文件保存到一个目标文件当中
	            file.transferTo(new File(path + File.separator + filename));//保存文件
	            videos.setVideopath(filename);
	            mapjson.put("state", 1);
	        } catch (IllegalStateException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            mapjson.put("state", 0);
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            mapjson.put("state", 0);
	        }
			
			int result=videoService.insertSelective(videos);
			if(result>0){
				mapjson.put("state", 1);
			}else{
				mapjson.put("state", 0);
			}
	  return mapjson;
	}
}
