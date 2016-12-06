package com.seedyee.domain;

import java.io.Serializable;

/**
 * @author lcl
 * @createDate 2016年11月30日下午11:42:11
 *
 */
public class ErrorInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 错误码.
	 */
    private int code;
    
    /**
     * 错误信息.
     */
    private String message;
    
    public ErrorInfo() {}
    
    public ErrorInfo(int code, String message) {
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
