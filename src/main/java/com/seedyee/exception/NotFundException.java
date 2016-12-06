package com.seedyee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author lcl
 * @createDate 2016年12月1日上午10:02:10
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "not fund")
public class NotFundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int code;
	private String message;
	
	public NotFundException() {}
	public NotFundException(int code, String message) {
		this.code = code;
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
