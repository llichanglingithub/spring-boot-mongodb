/**
 * 
 */
package com.seedyee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seedyee.domain.User;
import com.seedyee.service.UserService;

/**
 * @author lcl
 * @createDate 2016年11月13日下午1:59:37
 *
 */
@RestController
public class UserController {
	@Autowired
	private UserService service;
	
	private User user;
	
	
	
	@RequestMapping(value = "user/create", method = RequestMethod.POST)
	public Object createUser(@ModelAttribute(name = "user")User user) {
		if (user != null) {
			user = service.createUser(user);
			System.out.println("user---id" + user.getId());
			return user;
		}
		return "is error";
	}
	
	@RequestMapping(value = "user/userinfo/name", method = RequestMethod.POST)
	public Object getUserInfoByName(@RequestParam(name = "name", required = true)String name) {
		if (name != null) {
			user = service.getUserInfoByName(name);
			System.out.println("user---id" + user.getId());
			return user;
		}
		return null;
	}
	/**
	 * 测试mongo原始查询
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/testmongo", method = RequestMethod.POST)
	public Object testMongoClient(@RequestParam(name = "name", required = true) String name) {
		return service.testMongo(name);
	}
}
