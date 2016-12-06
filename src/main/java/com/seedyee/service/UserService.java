/**
 * 
 */
package com.seedyee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.DBObject;
import com.seedyee.dao.MongoClientTest;
import com.seedyee.dao.UserRepository;
import com.seedyee.domain.User;

/**
 * @author lcl
 * @createDate 2016年11月13日下午1:52:52
 *
 */
@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private MongoClientTest mongoClientTest;
	
	/**
	 * 创建一个用户
	 * @param user
	 * @return
	 */
	public User createUser(User user){
		return repository.save(user);
	}
	/**
	 * 根据用户名获取用户信息
	 * @param name
	 * @return
	 */
	public User getUserInfoByName(String name) {
		User user = null;
		user = repository.findByName(name);
		return user;
	}
//	/**
//	 * 根据邮箱获取用户信息
//	 * @param email
//	 * @return
//	 */
//	public User getUserInfoByEmail(String email) {
//		User user = null;
//		user = repository.findByEmail(email);
//		return user;
//	}
//	public User updateUserInfo(User user) {
//		
//	}
	
	public Object testMongo(String name) {
		return mongoClientTest.getUserByName(name);
	}
}
