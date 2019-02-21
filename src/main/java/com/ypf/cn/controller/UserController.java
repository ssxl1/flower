package com.ypf.cn.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ypf.cn.domain.Middleteacher;
import com.ypf.cn.domain.Users;
import com.ypf.cn.service.UserService;
import com.ypf.cn.service.UsersServlce;
import com.ypf.cn.util.PageUtil;
import com.ypf.cn.util.StringUtil;

@Controller
public class UserController {
	// 依赖注入
	@Autowired
	UserService userService;

	@Autowired
	UsersServlce usersService;

	@ResponseBody
	@RequestMapping(value = "/adduser")
	public Map register(@RequestBody Users user3, HttpServletRequest request) {
		Map mapjson = new HashMap();
		user3.setCreatedate(new Date());
		user3.setIsAdmin("n");
		user3.setRoleid(1);
		;
		user3.setStatus("normal");
		int result = usersService.insert(user3);
		if (result > 0) {
			mapjson.put("state", 1);
		} else {
			mapjson.put("state", 0);
		}
		return mapjson;
	}

	@ResponseBody
	@RequestMapping(value = "/loginuser1")
	public Map register2(@RequestBody Users user3, HttpServletRequest request) {
		Map mapjson = new HashMap();

		Users user = usersService.selectByLogin(user3);

		if (StringUtil.isNotEmpty(user.getName())) {
			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("name", user.getName());
			request.getSession().setAttribute("isadmin", user.getIsAdmin());
			request.getSession().setAttribute("id", user.getId());
			request.getSession().setAttribute("roleid", user.getRoleid());
			mapjson.put("state", 1);
		} else {
			mapjson.put("state", 0);
		}
		return mapjson;
	}

	// 后台登录
	@ResponseBody
	@RequestMapping(value = "/login_backuser")
	public Map login1(@RequestBody Users user3, HttpServletRequest request) {
		Map mapjson = new HashMap();

		Users user = usersService.selectByLogin(user3);

		if (StringUtil.isNotEmpty(user.getName())) {
			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("name", user.getName());
			request.getSession().setAttribute("isadmin", user.getIsAdmin());
			request.getSession().setAttribute("id", user.getId());
			request.getSession().setAttribute("roleid", user.getRoleid());
			mapjson.put("state", 1);
		} else {
			mapjson.put("state", 0);
		}
		return mapjson;
	}

	/**
	 * 用户退出跳转到系统登录页面
	 * 
	 * @return
	 */
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		// false代表：不创建session对象，只是从request中获取
		HttpSession session = request.getSession(false);
		if (session == null) {
		} else {
			session.removeAttribute("user");
			session.removeAttribute("name");
			session.removeAttribute("isadmin");
			session.removeAttribute("id");
			session.removeAttribute("roleid");
		}
		ModelAndView mv = new ModelAndView("views/head/login");
		return mv;
	}

	/**
	 * 根据用户id获取用户
	 * 
	 * @return
	 */
	@RequestMapping(value = "/users_update")
	public String usersupdate(@RequestParam(value = "id", required = false) Integer id, HttpServletRequest request) {
		Users users = usersService.selectByPrimaryKey(id);
		request.setAttribute("user", users);
		return "views/admin/update_users";
	}

	/**
	 * 用户 物理删除/users/delete
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/users_delete")
	public Map deleteusers(@RequestParam(value = "id", required = false) Integer id) {
		Map mapjson = new HashMap();
		if (id > 0) {
			int result = usersService.deleteByPrimaryKey(id);
			if (result > 0) {
				mapjson.put("state", 1);
			} else {
				mapjson.put("state", 0);
			}

		} else {
			mapjson.put("state", 0);
		}

		return mapjson;
	}

	/**
	 * 用户 列表 查询分页功能/users/delete
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getadminlist")
	public Map selectnormaluserslist(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "is_admin", required = false) String is_admin,
			@RequestParam(value = "roleid", required = false) Integer roleid,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "limit", required = false) Integer limit) {
		Map mapjson = new HashMap();
		Map map = new HashMap();
		if (id != null) {
			map.put("id", id);
		}
		if (roleid != null) {
			map.put("roleid", roleid);
		}
		// 管理员
		map.put("roleid", 15);
		if (!StringUtil.isEmpty(is_admin)) {
			System.out.println(is_admin);
			map.put("is_admin", is_admin);
		}
		if (!StringUtil.isEmpty(name)) {
			System.out.println(name);
			map.put("name", name);
		}
		int count = 0;
		int startPos = 0;
		if (limit < 0) {
			limit = 2;
		}
		map.put("limit", limit);
		PageUtil pageUtil = new PageUtil();
		count = usersService.findcountbycondition(map);
		if (count > 0) {
			pageUtil.setPageSize(limit);
			pageUtil.setTotalPage((int) count);
			mapjson.put("count", count);
		}
		if (page > 0) {
			startPos = (page - 1) * limit;
			map.put("startPos", startPos);
		} else {
			page = 1;
			map.put("startPos", startPos);
		}
		List<Users> list = usersService.selectByMap(map);
		mapjson.put("code", 0);
		mapjson.put("msg", "");
		mapjson.put("data", list);
		return mapjson;
	}

	@ResponseBody
	@RequestMapping(value = "/loadusers")
	public Map loadusers(@RequestParam(value = "cid", required = false) Integer cid) {
		Map mapjson = new HashMap();
		Map map = new HashMap();
		map.put("roleid", 14);
		List<Users> list = usersService.selectByMap(map);
		if (cid != null) {
			map.remove("roleid");
			map.put("cid", cid);
		}
		mapjson.put("code", 0);
		mapjson.put("msg", "");
		mapjson.put("count", list.size());
		mapjson.put("data", list);
		return mapjson;
	}

	@ResponseBody
	@RequestMapping(value = "/getuserslist")
	public Map selectuserslist(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "is_admin", required = false) String is_admin,
			@RequestParam(value = "roleid", required = false) Integer roleid,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "limit", required = false) Integer limit) {
		Map mapjson = new HashMap();
		Map map = new HashMap();
		if (id != null) {
			map.put("id", id);
		}
		if (roleid != null) {
			map.put("roleid", roleid);
		}
		map.put("roleid", 13);
		if (!StringUtil.isEmpty(is_admin)) {
			System.out.println(is_admin);
			map.put("is_admin", is_admin);
		}
		if (!StringUtil.isEmpty(name)) {
			System.out.println(name);
			map.put("name", name);
		}
		int count = 0;
		int startPos = 0;
		if (limit < 0) {
			limit = 2;
		}
		map.put("limit", limit);
		PageUtil pageUtil = new PageUtil();
		count = usersService.findcountbycondition(map);
		if (count > 0) {
			pageUtil.setPageSize(limit);
			pageUtil.setTotalPage((int) count);
			mapjson.put("count", count);
		}
		if (page > 0) {
			startPos = (page - 1) * limit;
			map.put("startPos", startPos);
		} else {
			page = 1;
			map.put("startPos", startPos);
		}
		List<Users> list = usersService.selectByMap(map);
		mapjson.put("code", 0);
		mapjson.put("msg", "");
		mapjson.put("data", list);
		return mapjson;
	}

	@ResponseBody
	@RequestMapping(value = "/geteacherlist")
	public Map selectteacher(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "is_admin", required = false) String is_admin,
			@RequestParam(value = "roleid", required = false) Integer roleid,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "limit", required = false) Integer limit) {
		Map mapjson = new HashMap();
		Map map = new HashMap();
		if (id != null) {
			map.put("id", id);
		}
		map.put("roleid", 14);
		if (roleid != null) {
			map.put("roleid", roleid);
		}
		if (!StringUtil.isEmpty(is_admin)) {
			System.out.println(is_admin);
			map.put("is_admin", is_admin);
		}
		if (!StringUtil.isEmpty(name)) {
			System.out.println(name);
			map.put("name", name);
		}
		int count = 0;
		int startPos = 0;
		if (limit < 0) {
			limit = 2;
		}
		map.put("limit", limit);
		PageUtil pageUtil = new PageUtil();
		count = usersService.findcountbycondition(map);
		if (count > 0) {
			pageUtil.setPageSize(limit);
			pageUtil.setTotalPage((int) count);
			mapjson.put("count", count);
		}
		if (page > 0) {
			startPos = (page - 1) * limit;
			map.put("startPos", startPos);
		} else {
			page = 1;
			map.put("startPos", startPos);
		}
		List<Users> list = usersService.selectByMap(map);
		mapjson.put("code", 0);
		mapjson.put("msg", "");
		mapjson.put("data", list);
		return mapjson;
	}

	/**
	 * 用户更新
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateusers")
	public Map doupdate(@RequestBody Users users) {

		Map mapjson = new HashMap();
		if (users != null) {
			int result = usersService.updateByPrimaryKeySelective(users);
			if (result > 0) {
				mapjson.put("state", 1);
			} else {
				mapjson.put("state", 0);
			}

		} else {
			mapjson.put("state", 0);
		}
		return mapjson;

	}

	@ResponseBody
	@RequestMapping(value = "/addusers")
	public Map addusers(@RequestBody Users users, HttpServletRequest request) {
		System.out.println(users.getName());
		Map mapjson = new HashMap();
		users.setCreatedate(new Date());
		users.setStatus("normal");
		int result = usersService.insertSelective(users);
		if (result > 0) {
			mapjson.put("state", 1);
		} else {
			mapjson.put("state", 0);
		}
		return mapjson;
	}

	@RequestMapping("/login")
	public String login() {
		return "/login";
	}

	@RequestMapping("/login2")
	public String login2() {
		return "views/login";
	}

	@RequestMapping("/user")
	public String login3() {
		return "views/user/user";
	}

	@RequestMapping("/dept")
	public String login4() {
		return "views/dept/dept";
	}

	@RequestMapping("/test")
	public String login5(HttpServletRequest request) {
		String name = "this is testname";
		request.setAttribute("name", name);
		return "views/user/user";
	}
}
