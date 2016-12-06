package com.seedyee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seedyee.dao.MongoTemplateUserDao;
import com.seedyee.domain.Email;
import com.seedyee.domain.User;
import com.seedyee.exception.NotFundException;

/**
 * @author lcl
 * @createDate 2016年11月28日下午2:15:29
 *
 */
@Service
public class MongoTemplateUserService {
	
	@Autowired
	private MongoTemplateUserDao userDao;
	
	public Object createUser(User user) {
		int createUser = userDao.createUser(user);
		if (createUser == 1) {
			return "创建成功";
		}
		return "创建失败";
	}
	
	public Object addEmail(String id, Email email) {
		int addEmail = userDao.addEmail(id, email);
		if (addEmail == 1) {
			return "添加成功";
		}
		return "添加失败";
	}
	
	
	public User getUserInfo(String id) {
		User userInfo = userDao.getUserInfo(id);
		if (userInfo == null) {
			throw new NotFundException(10001, "not found user");
		}
		return userInfo;
	}
	
	public Object getUserEmails(String id) {
		List<Email> userEmails = userDao.getUserEmails(id);
		if (userEmails.size() > 0) {
			return userEmails;
		}
		return null;
	}
	
	public Object setDefaultEmail(String id, String email) {
		int setDefaultEmail = userDao.setDefaultEmail(id, email);
		if (setDefaultEmail == 1) {
			return "设置默认邮箱成功";
		}
		return "设置默认邮箱失败";
	}
	
	public Object deleteEmail(String id, String email) {
		int deleteEmail = userDao.deleteEmail(id, email);
		if (deleteEmail == 1) {
			return "删除邮箱成功";
		}
		return "删除邮箱失败";
	}
	
	public Object checkEmail(String email) {
		return userDao.checkEmail(email);
	}
	
	public Object checkAccountEmail(String accountId, String email) {
		return userDao.checkUserEmail(accountId, email);
	}
	
}
