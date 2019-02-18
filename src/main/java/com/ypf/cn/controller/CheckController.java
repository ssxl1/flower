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

import com.ypf.cn.domain.Resume;
import com.ypf.cn.service.ResumeService;
import com.ypf.cn.util.PageUtil;
import com.ypf.cn.util.StringUtil;

@Controller
public class CheckController {
	@Autowired
	ResumeService resumeService;
	
	/**
     * 根据用户id获取用户
     * @return
     */
	 @RequestMapping(value = "/resume_update")
    public String resumesupdate(@RequestParam(value="id",required=false) Integer id,HttpServletRequest request) {
		 Resume resume=resumeService.selectByPrimaryKey(id);
    	request.setAttribute("resume", resume);
    	return "views/admin/update_resume";
    }
	 
	 
    /**
     * 用户 物理删除/resumes/delete
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/resume_delete")
    public Map deleteresumes(@RequestParam(value="id",required=false) Integer id)
    {
    	Map mapjson = new HashMap();
    	if(id>0) {
			int result=resumeService.deleteByPrimaryKey(id);
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
     * 用户 列表 查询分页功能/resumes/delete
     * @return
     */
    @ResponseBody
    @RequestMapping(value ="/getresumeslist")
    public Map selectresumeslist(@RequestParam(value="id",required=false) Integer id
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
		count=resumeService.findcountbycondition(map);
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
		List<Resume> list= resumeService.selectByMap(map);
	 	mapjson.put("code", 0);
		mapjson.put("msg", "");
		mapjson.put("data", list);
    	return mapjson;
    }
    /**
     * 用户更新
     * @return  resume_update_status
     */
    @ResponseBody
    @RequestMapping(value ="/updateresume")
    public Map doupdate(@RequestParam(value="id",required=false) Integer id,@RequestParam(value="rstatus",required=false) String rstatus) {
    	Resume resumes=new Resume();
    	resumes.setId(id);
    	resumes.setRstatus(rstatus);
    	Map mapjson = new HashMap();
    	if(resumes!=null) {
    		int result=resumeService.updateByPrimaryKeySelective(resumes);
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
	@RequestMapping(value="/addresume")
	public Map addusers( @RequestParam(value="ryear",required=false) Integer ryear,@RequestParam(value="rdescirption",required=false) String rdescirption, 
			@RequestParam(value="rexperience",required=false) String rexperience,
			@RequestParam(value="rage",required=false) Integer rage,
			@RequestParam(value="pid",required=false) Integer pid,
			@RequestParam(value="remail",required=false) String remail, 
			@RequestParam(value="rtel",required=false) String rtel, 
			@RequestParam(value="raddress",required=false) String raddress, 
			 MultipartFile file)
            throws Exception { 
    	/*id, ryear, rdescirption, rexperience, remail, rtel, rage, rname, pid, videopath, 
        raddress, pname, rstatus*/
    	Resume resumes=new Resume();
    	resumes.setPid(pid);
    	resumes.setRyear(ryear);
    	resumes.setRdescirption(rdescirption);
    	resumes.setRexperience(rexperience);
    	resumes.setRaddress(raddress);
    	resumes.setRemail(remail);
    	resumes.setRaddress(raddress);
    	resumes.setRage(rage);
    	
			Map mapjson = new HashMap();
			if(file.isEmpty()){
				mapjson.put("state", 1);
	        }
	        String filename = "jl"+file.getOriginalFilename();
	        //上传文件路径
	        String path=  "E:\\Users\\Administrator\\Workspaces\\MyEclipse 2017 CI\\fower\\src\\main\\resources\\static\\video";
            File filepath = new File(path,filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) { 
                filepath.getParentFile().mkdirs();
            }
	        try {
	        	  //将上传文件保存到一个目标文件当中
	            file.transferTo(new File(path + File.separator + filename));//保存文件
	            resumes.setVideopath(filename);
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
			int result=resumeService.insertSelective(resumes);
			if(result>0){
				mapjson.put("state", 1);
			}else{
				mapjson.put("state", 0);
			}
	  return mapjson;
	}
}
