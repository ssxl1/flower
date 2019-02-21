package com.ypf.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ypf.cn.domain.Product;
import com.ypf.cn.service.ProductService;
import com.ypf.cn.util.RestResult;

@RestController
public class ProductController {
	// 依赖注入
	@Autowired
	ProductService productService;

	@RequestMapping(value = "/rest/Product", method = RequestMethod.POST, produces = "application/json")
	public RestResult saveProduct(@RequestBody Product Product) {

		int result = productService.insertSelective(Product);
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

	@RequestMapping(value = "/rest/Product/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public RestResult deleteProduct(@PathVariable int id) {

		int result = productService.deleteByPrimaryKey(id);
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

	@RequestMapping(value = "/rest/Product/{id}", method = RequestMethod.PUT, produces = "application/json")
	public RestResult updateProduct(@PathVariable int id, @RequestBody Product Product) {
		Product.setId(id);
		int result = productService.deleteByPrimaryKey(id);

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

	@RequestMapping(value = "/rest/Product/{id}", method = RequestMethod.GET, produces = "application/json")
	public RestResult<Object> getProduct(@PathVariable int id) {
		Product Product = productService.selectByPrimaryKey(id);
		String code = "";
		String msg = "";
		if (Product != null) {
			code = "200";
			msg = "查询成功";
		} else {
			code = "500";
			msg = "查询error";
		}
		RestResult<Object> restResult = new RestResult<>(code, msg, Product);
		return restResult;
	}
}
