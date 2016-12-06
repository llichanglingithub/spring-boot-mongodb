package com.seedyee.domain;

/**
 * @author lcl
 * @createDate 2016年11月28日上午11:07:38
 *
 */
public class Email extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private boolean isDefault;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isDefault() {
		return isDefault;
	}
	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}
}
