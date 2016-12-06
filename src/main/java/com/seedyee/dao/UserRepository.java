/**
 * 
 */
package com.seedyee.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.seedyee.domain.User;

/**
 * @author lcl
 * @createDate 2016年11月13日下午1:51:13
 *
 */
public interface UserRepository extends MongoRepository<User, String> {

	User findByName(String name);
}
