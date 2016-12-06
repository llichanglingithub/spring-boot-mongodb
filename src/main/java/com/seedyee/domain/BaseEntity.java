/**
 * 
 */
package com.seedyee.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

/**
 * @author lcl
 * @createDate 2016年11月13日下午5:53:10
 *
 */
public class BaseEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
