package com.seedyee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seedyee.domain.Email;
import com.seedyee.domain.ErrorInfo;
import com.seedyee.domain.ResultModel;
import com.seedyee.domain.User;
import com.seedyee.exception.NotFundException;
import com.seedyee.service.MongoTemplateUserService;

/**
 * @author lcl
 * @createDate 2016年11月28日下午2:26:45
 *
 */
@RestController
@RequestMapping(value = "/users")
public class MongoTemplateUserConttroller {
	@Autowired
	private MongoTemplateUserService userService;
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Object createUser(@ModelAttribute(name = "user")User user) {
		Object createUser = userService.createUser(user);
		return createUser;
	}
	@RequestMapping(value = "/{userId}/email", method = RequestMethod.POST)
	public Object addEmail(@PathVariable(name = "userId", required = true)String userId, @ModelAttribute(name = "email")Email email) {
		Object addEmail = userService.addEmail(userId, email);
		return addEmail;
	}
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public Object getUserInfo(@PathVariable(name = "userId", required = true)String userId) {
		User userInfo = userService.getUserInfo(userId);
//		if (userInfo == null) {
//			throw new NotFundException(10001,"没有找到管用户");
//		}
//		ResultModel<ErrorInfo> resultModel = new ResultModel<>();
//		resultModel.setKey("result");
//		resultModel.setObj(userInfo);
		return userInfo;
	}
	@RequestMapping(value = "/{userId}/emails", method = RequestMethod.GET)
	public Object getUserEmails(@PathVariable(name = "userId", required = true)String userId) {
		Object userInfo = userService.getUserEmails(userId);
		return userInfo;
	}
	
	
	@RequestMapping(value = "/{userId}/set-default", method = RequestMethod.POST)
	public Object setDefaultEmail(@PathVariable()String userId, @RequestParam(name = "email", required = true)String email) {
		return userService.setDefaultEmail(userId, email);
	}
	@RequestMapping(value = "/{userId}/delete", method = RequestMethod.POST)
	public Object deleteEmail(@PathVariable String userId, @RequestParam(name = "email", required = true) String email) {
		Object deleteEmail = userService.deleteEmail(userId, email);
		return deleteEmail;
	}
	@RequestMapping(value = "/email", method = RequestMethod.POST)
	public Object checkEmail(@RequestParam(name = "email", required = true) String email) {
		return userService.checkEmail(email);
	}
	
	@RequestMapping(value = "/{accountId}/accountemail", method = RequestMethod.POST)
	public Object checkAccountEmail(@PathVariable(name = "accountId") String accountId, @RequestParam String email) {
		return userService.checkAccountEmail(accountId, email);
	}
}
