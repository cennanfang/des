package com.redbird.wehelp.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * 找不到用户异常
 * @author c
 *
 */
public class UserLoginException extends AuthenticationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3895229790658241624L;
	
	/**
	 * 
	 * @param msg 错误信息
	 */
	public UserLoginException(String msg) {
		super(msg);
	}

}
