package com.seedyee.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.seedyee.domain.User;

/**
 * @author lcl
 * @createDate 2016年11月23日下午2:52:04
 *
 */
@Repository
public class MongoClientTest {
	@Autowired
	MongoTemplate mongoTemplate;
	
	public DBObject getUserByName(String name) {
		BasicDBObject basicDBObject = new BasicDBObject();
		basicDBObject.put("name", name);
		DBObject dbObject = mongoTemplate.getCollection("user").findOne(basicDBObject);
		return dbObject;
	}
}
