package com.ypf.cn.controller;

import java.util.ArrayList;
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

import com.ypf.cn.domain.Classroom;
import com.ypf.cn.domain.CountExcel;
import com.ypf.cn.domain.Middlestudent;
import com.ypf.cn.domain.Middleteacher;
import com.ypf.cn.domain.Users;
import com.ypf.cn.service.ClassRoomService;
import com.ypf.cn.service.CountService;
import com.ypf.cn.service.StudentService;
import com.ypf.cn.service.TeacherService;
import com.ypf.cn.service.UsersServlce;
import com.ypf.cn.util.PageUtil;
import com.ypf.cn.util.StringUtil;

@Controller
public class ClassController {

	@Autowired
	ClassRoomService classRoomService;
	
	@Autowired
	StudentService studentService;
	@Autowired
	TeacherService teacherService;
	@Autowired
	UsersServlce userService;
	
	 @Autowired
	    CountService ccountService;
	/**
     * 根据用户id获取用户
     * @return
     */
	 @RequestMapping(value = "/classroom_update")
    public String ClassRoomsupdate(@RequestParam(value="id",required=false) Integer id,HttpServletRequest request) {
    	Map map = new HashMap();
    	Classroom classroom=classRoomService.selectByPrimaryKey(id);
    	request.setAttribute("classroom", classroom);
    	return "views/admin/update_class";
    }
	 
	 
    /**
     * 用户 物理删除/ClassRooms/delete
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/classroom_delete")
    public Map deleteClassRooms(@RequestParam(value="id",required=false) Integer id)
    {
    	Map mapjson = new HashMap();
    	if(id>0) {
			int result=classRoomService.deleteByPrimaryKey(id);
			
			if(result>0) {
				teacherService.deleteByCid(id);
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
    @RequestMapping(value ="/getClassRooms")
    public Map selectClassRoomslists(@RequestParam(value="id",required=false) Integer id
,@RequestParam(value="name",required=false) String name,
@RequestParam(value="description",required=false) String description,
@RequestParam(value="page",required=false) Integer page, 
@RequestParam(value="limit",required=false) Integer limit,HttpServletRequest request)
    {
    	Map mapjson = new HashMap();
    	Map map = new HashMap();
    	if(id!=null){
    		map.put("id",id);
    	}
    	if(!StringUtil.isEmpty(name)) {
    		System.out.println(name);
    		map.put("name",name);
    	}
    	List<Classroom> list= classRoomService.selectByJoin(map);
    	mapjson.put("data", list);
    	return mapjson;
    }	
    
    
    /**
     * 用户 列表 查询分页功能/ClassRooms/delete
     * @return
     */
    @ResponseBody
    @RequestMapping(value ="/getClassRoomslist")
    public Map selectClassRoomslist(@RequestParam(value="id",required=false) Integer id
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
		count=classRoomService.findcountbycondition(map);
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
		List<Classroom> list= classRoomService.selectByMap(map);
	 	mapjson.put("code", 0);
		mapjson.put("msg", "");
		mapjson.put("data", list);
    	return mapjson;
    }
    @ResponseBody
    @RequestMapping(value ="/echarts")
    public Map getmap(@RequestParam(value="id",required=false) Integer id) {
    	
    	Map mapjson = new HashMap();
    	Map map = new HashMap();
    	List<CountExcel> list=new ArrayList<CountExcel>();
    	List<Integer> allmoney = new ArrayList<Integer>();
    	List<String> show = new ArrayList<String>();
    	
    	List<String> show1 = new ArrayList<String>();
    	
    	List<String> show2 = new ArrayList<String>();
    	if(id!=null){
  
    	if(id==1){
    		list= ccountService.selectByMonth(map);
    		for (int i = 0; i < list.size(); i++) {
    			allmoney.add(list.get(i).getAllmoney());
    			show.add(list.get(i).getMonth()+"月");
			}
    		 mapjson.put("num", allmoney);
    		 mapjson.put("desc", show);
    	}else if(id==2){
    		list= ccountService.selectByTmonth(map);
    		for (int i = 0; i < list.size(); i++) {
    			allmoney.add(list.get(i).getAllmoney());
    			show1.add(list.get(i).getMonth()+"季度");
			}
    		 mapjson.put("num", allmoney);
    		 mapjson.put("desc", show1);
    	}else if(id==3){
    		list= ccountService.selectByYear(map);
    		for (int i = 0; i < list.size(); i++) {
    			allmoney.add(list.get(i).getAllmoney());
    			
			}
    		show2.add("2018");
    		 mapjson.put("num", allmoney);
    		 mapjson.put("desc", show2);
    	}
    	
      	}else{
      		list= ccountService.selectByMonth(map);
      		for (int i = 0; i < list.size(); i++) {
    			allmoney.add(list.get(i).getAllmoney());
    			show.add(list.get(i).getMonth()+"月");
			}
    		 mapjson.put("num", allmoney);
    		 mapjson.put("desc", show);
      	}
    	
    	
    	return mapjson;
    	
    }
    /**
     * 用户更新
     * @return  classroom_update_status
     */
    @ResponseBody
    @RequestMapping(value ="/updateclassroom")
    public Map doupdate(@RequestBody Classroom classroom) {
    	//删除避免数据
    	teacherService.deleteByCid(classroom.getId());
    
    	Map mapjson = new HashMap();
    	classroom.setCreatedate(new Date());
		System.out.println(classroom.getStatus());
		String id=classroom.getStatus();
		String [] ids= id.split(",");
		System.out.println(id);
		List<Users> ulist=new ArrayList<Users>();
		for (int i = 0; i < ids.length; i++) {
			Users user=userService.selectByPrimaryKey(Integer.parseInt(ids[i]));
			ulist.add(user);
		}
		
		classroom.setStatus("y");
		double money=classroom.getNum()*classroom.getPrice();
		classroom.setAllmoney(money);
		int result=classRoomService.updateByPrimaryKeySelective(classroom);
		int cid=classroom.getId();
		System.out.println(cid+"cid");
		for (int i = 0; i < ulist.size(); i++) {
			Middleteacher te=new Middleteacher();
			te.setCid(cid);
			te.setTcreatedate(new Date());
			te.setTemail(ulist.get(i).getEmail());
			te.setTuid(ulist.get(i).getId());
			te.setTname(ulist.get(i).getName());
			te.setTtel(ulist.get(i).getTel());
			teacherService.insertSelective(te);
		}
    		
    		if(result>0){
    			mapjson.put("state", "sucess");
    			
    			}else{
				mapjson.put("state", "error");
			}
    	return mapjson;
    	
    	
    }
    
    @ResponseBody
    @RequestMapping(value ="/signup_class")
    public Map signup(@RequestParam(value="id",required=false) Integer id,@RequestParam(value="userid",required=false) Integer userid) {
    	
    	Map mapjson = new HashMap();
    	Map map = new HashMap();
    	Classroom classRoom=new Classroom();
    	System.out.println(id);
    	System.out.println(userid);
    	classRoom=classRoomService.selectByPrimaryKey(id);
    	
    	Users user=userService.selectByPrimaryKey(userid);
    	int num=classRoom.getNum();
    	map.put("uid", userid);//用户ID
    	map.put("cid", id);//课程id
    	//判断用户是否报班 count
    	int count=studentService.findcountbycondition(map);
    	if(classRoom.getNum()<=25&&count<=0) {
    		//num 加一
    		int backnum=num+1;
    		classRoom.setNum(backnum);
    		double money=backnum*classRoom.getPrice();
    		classRoom.setAllmoney(money);
    		classRoomService.updateByPrimaryKeySelective(classRoom);
    		Middlestudent student=new Middlestudent();
    		student.setCid(id);
    		student.setScreatedate(new Date());
    		student.setSdescription(user.getDescirption());
    		student.setUid(user.getId());
    		student.setSname(user.getName());
    		student.setSemail(user.getEmail());
    		student.setStel(user.getTel());
    		student.setSstatus("y");
    		int result=studentService.insertSelective(student);
    		if(result>0){
    			mapjson.put("state", 1);
    			mapjson.put("num", backnum);
			}else{
				mapjson.put("state", 0);
			}
    	}else {
    		mapjson.put("state", 2);
    	}
    	if(count>=1){
    		mapjson.put("state", 3);
    	}
    	return mapjson;
    	
    	
    }
    @ResponseBody
    @RequestMapping(value ="/beginclass")
    public Map beginclass(@RequestParam(value="id",required=false) Integer id) {
    	
    	Map mapjson = new HashMap();
    	Classroom classRoom=new Classroom();
    	classRoom.setStatus("已开班");
    	classRoom.setId(id);
    	if(classRoom!=null) {
    		int result=classRoomService.updateByPrimaryKeySelective(classRoom);
    		if(result>0){
    			mapjson.put("state", "sucess");
			}else{
				mapjson.put("state", "error");
			}
    		
    	}else {
    		mapjson.put("state", "error");
    	}
    	return mapjson;
    	
    	
    }
    @ResponseBody
	@RequestMapping(value="/addclassroom")
	public Map register( @RequestBody Classroom classroom,HttpServletRequest request) {
		Map mapjson = new HashMap();
			classroom.setCreatedate(new Date());
			System.out.println(classroom.getStatus());
			String id=classroom.getStatus();
			String [] ids= id.split(",");
			System.out.println(id);
			List<Users> ulist=new ArrayList<Users>();
			for (int i = 0; i < ids.length; i++) {
				Users user=userService.selectByPrimaryKey(Integer.parseInt(ids[i]));
				ulist.add(user);
			}
			double money=classroom.getNum()*classroom.getPrice();
			classroom.setAllmoney(money);
			classroom.setStatus("y");
			int result=classRoomService.insertSelective(classroom);
			int cid=classroom.getId();
			System.out.println(cid+"cid");
			for (int i = 0; i < ulist.size(); i++) {
				Middleteacher te=new Middleteacher();
				te.setCid(cid);
				te.setTcreatedate(new Date());
				te.setTemail(ulist.get(i).getEmail());
				te.setTuid(ulist.get(i).getId());
				te.setTname(ulist.get(i).getName());
				te.setTtel(ulist.get(i).getTel());
				teacherService.insertSelective(te);
			}
			
			if(cid>0){
				mapjson.put("state", "sucess");
			}else{
				mapjson.put("state", "error");
			}
	  return mapjson;
	}
    
}
