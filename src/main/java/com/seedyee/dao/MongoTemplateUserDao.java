package com.seedyee.dao;


import java.util.List;

import javax.swing.plaf.synth.SynthStyle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.seedyee.domain.Email;
import com.seedyee.domain.User;

/**
 * @author lcl
 * @createDate 2016年11月28日上午11:05:58
 *
 */
@Repository
public class MongoTemplateUserDao {

	@Autowired
	private MongoTemplate mongoTemplate;

	/**
	 * 添加用户信息
	 * 
	 * @param user
	 * @return
	 */
	public int createUser(User user) {
		try {
			// mongoTemplate.insert(user, "user");
			mongoTemplate.save(user, "user");
		} catch (Exception e) {
			return -1;
		}
		return 1;
	}

	/**
	 * 给指定用户增加一个邮箱信息
	 * 
	 * @param id
	 * @param email
	 * @return
	 */
	public int addEmail(String id, Email email) {
		try {
			Query query = Query.query(Criteria.where("_id").is(id));
			Update update = new Update();
			update.addToSet("emails", email);
			mongoTemplate.upsert(query, update, User.class);
		} catch (Exception e) {
			return -1;
		}
		return 1;
	}

	/**
	 * 获取用户邮箱信息
	 * 
	 * @param id
	 * @return
	 */
	public List<Email> getUserEmails(String id) {
		Query query = Query.query(Criteria.where("_id").is(id));
		query.fields().include("emails");
//		DBObject dbObject = new BasicDBObject("emails", 1);
		//DBObject findOne = mongoTemplate.getCollection("user").findOne(query);
		User findOne = mongoTemplate.findOne(query, User.class);
//		List<Email> emails = (List<Email>) findOne.get("emails");
		System.out.println("------");
//		User user = mongoTemplate.findOne(query, User.class);
//		List<Email> emails = user.getEmails();
//		for (Email email : emails) {
//			System.err.println(email.getEmail());
//			System.err.println(email.isDefault());
//			System.out.println("-------------------");
//		}
		return null;
	}

	public User getUserInfo(String id) {
		Query query = Query.query(Criteria.where("_id").is(id));
		User user = mongoTemplate.findOne(query, User.class);
		return user;
	}

	/**
	 * 设置用户的默认邮箱
	 * 
	 * @param id
	 * @param emailId
	 * @return
	 */
	public int setDefaultEmail(String id, String email) {
		// 查看用户的默认邮箱
		try {
			Query queryDefault = Query.query(Criteria.where("_id").is(id).and("emails.isDefault").is(true));
			boolean exists = mongoTemplate.exists(queryDefault, User.class);
			if (exists) {
				Query query1 = Query.query(Criteria.where("_id").is(id).and("emails.isDefault").is(true));
				Update update1 = new Update();
				update1.set("emails.$.isDefault", false);
				mongoTemplate.updateFirst(query1, update1, User.class);
			}
			Query query = Query.query(Criteria.where("_id").is(id).and("emails.email").is(email));
			Update update = new Update();
			update.set("emails.$.isDefault", true);
			mongoTemplate.updateFirst(query, update, User.class);
		} catch (Exception e) {
			return -1;
		}
		return 1;
	}

	/**
	 * 删除用户邮箱
	 * 
	 * @param id
	 * @param emailId
	 * @return
	 */
	public int deleteEmail(String id, String email) {
		try {
			Query query = Query.query(Criteria.where("_id").is(id));
			BasicDBObject basicDBObject = new BasicDBObject();
			basicDBObject.put("email", email);
			Update update = new Update();
			update.pull("emails", basicDBObject);
			mongoTemplate.upsert(query, update, User.class);
			// WriteResult remove = mongoTemplate.remove(query, User.class);
			// mongoTemplate.remove(query, Email.class, "user");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return -1;
		}
		return 1;
	}

	public Object checkEmail(String email) {
		Query query = Query.query(Criteria.where("emails.email").is(email));
		boolean exists = mongoTemplate.exists(query, "user");
		if (exists) {
			return "邮箱已经被注册过";
		}
		return "邮箱没有被注册过";
	}
	
	/**
	 * 判断用户是否有指定的邮箱
	 * @param email
	 * @return
	 */
	public Object checkUserEmail(String accountId, String email) {
		Query query = Query.query(Criteria.where("_id").is(accountId).and("emails.email").is(email));
		boolean exists = mongoTemplate.exists(query, "user");
		if (exists) {
			return "该用户有该邮箱";
		}
		return "邮箱没有被注册过";
	}
	
}
