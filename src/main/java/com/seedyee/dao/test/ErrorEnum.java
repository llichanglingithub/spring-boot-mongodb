package com.seedyee.dao.test;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author lcl
 * @createDate 2016年11月15日上午11:47:05
 *
 */
public enum ErrorEnum {
	ACCOUNT_EXITED(1000001, "用户已经存在"), ACCOUNT_PASSWOED_ERROR(1000002, "密码错误");
	
	private int code;
	private String message;
	private ErrorEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
}
