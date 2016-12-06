package com.seedyee.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author lcl
 * @createDate 2016年12月1日上午12:19:33
 *
 */
public class ResultModel<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String key;
	private T obj;
	
	/**
	 * 
	 */
	public ResultModel() {}
	
	public ResultModel(String key, T obj) {
		this.key = key;
		this.obj = obj;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
	
	/**
	 * @param obj the obj to set
	 */
	public void setObj(T obj) {
		this.obj = obj;
	}
}
