package com.ypf.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ypf.cn.domain.Category;
import com.ypf.cn.service.CategoryService;
import com.ypf.cn.util.RestResult;

@RestController
public class CategoryController {
	// 依赖注入
	@Autowired
	CategoryService CategoryService;

	@RequestMapping(value = "/rest/Category", method = RequestMethod.POST, produces = "application/json")
	public RestResult saveCategory(@RequestBody Category Category) {

		int result = CategoryService.insertSelective(Category);
		String code = "";
		String msg = "";
		if (result > 0) {
			code = "200";
			msg = "新增成功";
		} else {
			code = "500";
			msg = "新增error";
		}
		RestResult<Object> results = new RestResult<>(code, msg);
		return results;
	}

	@RequestMapping(value = "/rest/Category/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public RestResult deleteCategory(@PathVariable int id) {

		int result = CategoryService.deleteByPrimaryKey(id);
		String code = "";
		String msg = "";
		if (result > 0) {
			code = "200";
			msg = "删除成功";
		} else {
			code = "500";
			msg = "删除error";
		}
		RestResult<Object> results = new RestResult<>(code, msg);
		return results;
	}

	@RequestMapping(value = "/rest/Category/{id}", method = RequestMethod.PUT, produces = "application/json")
	public RestResult updateCategory(@PathVariable int id, @RequestBody Category Category) {
		Category.setId(id);
		int result = CategoryService.deleteByPrimaryKey(id);

		String code = "";
		String msg = "";
		if (result > 0) {
			code = "200";
			msg = "更新成功";
		} else {
			code = "500";
			msg = "更新error";
		}
		RestResult<Object> restResult = new RestResult<>(code, msg);
		return restResult;

	}

	@RequestMapping(value = "/rest/Category/{id}", method = RequestMethod.GET, produces = "application/json")
	public RestResult<Object> getCategory(@PathVariable int id) {
		Category Category = CategoryService.selectByPrimaryKey(id);
		String code = "";
		String msg = "";
		if (Category != null) {
			code = "200";
			msg = "查询成功";
		} else {
			code = "500";
			msg = "查询error";
		}
		RestResult<Object> restResult = new RestResult<>(code, msg, Category);
		return restResult;
	}
}
