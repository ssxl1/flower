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

import com.ypf.cn.domain.Comment;
import com.ypf.cn.domain.Users;
import com.ypf.cn.service.CommentService;
import com.ypf.cn.service.UsersServlce;
import com.ypf.cn.util.PageUtil;
import com.ypf.cn.util.StringUtil;

@Controller
public class CommentController {

	@Autowired
	CommentService commentService;
	@Autowired
	UsersServlce usersServlce;
	/**
     * 根据用户id获取用户
     * @return
     */
	 @RequestMapping(value = "/comment_update")
    public String commentsupdate(@RequestParam(value="id",required=false) Integer id,HttpServletRequest request) {
		 Comment comment=commentService.selectByPrimaryKey(id);
    	request.setAttribute("comment", comment);
    	return "views/admin/update_comment";
    }
	 
	 
    /**
     * 用户 物理删除/comments/delete
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/comment_delete")
    public Map deletecomments(@RequestParam(value="id",required=false) Integer id)
    {
    	Map mapjson = new HashMap();
    	if(id>0) {
			int result=commentService.deleteByPrimaryKey(id);
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
     * 用户 列表 查询分页功能/comments/delete
     * @return
     */
    @ResponseBody
    @RequestMapping(value ="/getcommentslist")
    public Map selectcommentslist(@RequestParam(value="id",required=false) Integer id
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
		count=commentService.findcountbycondition(map);
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
		List<Comment> list= commentService.selectByMap(map);
	 	mapjson.put("code", 0);
		mapjson.put("msg", "");
		mapjson.put("data", list);
    	return mapjson;
    }
    /**
     * 用户更新
     * @return  comment_update_status  updatecomment_status
     */
    @ResponseBody
    @RequestMapping(value ="/updatecomment")
    public Map doupdate(@RequestBody Comment comments) {
   
    	Map mapjson = new HashMap();
    	if(comments!=null) {
    		int result=commentService.updateByPrimaryKeySelective(comments);
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
    @RequestMapping(value ="/updatecomment_status")
    public Map updatecomment_status(@RequestParam(value="ids",required=false) String ids) {
   
    	Map mapjson = new HashMap();
    	Map map = new HashMap();
    	 Comment comment=new Comment();
    	 String [] isstring=ids.split(",");
    	 
    	if(isstring.length>0) {
    		for (int i = 0; i < isstring.length; i++) {
    			comment.setId(Integer.parseInt(isstring[i]));
    			comment.setStatus("已审核");
    			commentService.updateByPrimaryKeySelective(comment);
			}
    		if(ids.length()>0){
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
	@RequestMapping(value="/addcomment")
	public Map addusers( @RequestBody Comment comment
			,HttpServletRequest request) {
			Map mapjson = new HashMap();
			Users users=usersServlce.selectByPrimaryKey(comment.getUid());
					comment.setCreatedate(new Date());
					comment.setUsername(users.getName());
					comment.setStatus("未审核");
			int result=commentService.insertSelective(comment);
			if(result>0){
				mapjson.put("state", 1);
			}else{
				mapjson.put("state", 0);
			}
	  return mapjson;
	}
    
}
