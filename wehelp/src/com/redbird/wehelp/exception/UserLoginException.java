package com.redbird.wehelp.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * �Ҳ����û��쳣
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
	 * @param msg ������Ϣ
	 */
	public UserLoginException(String msg) {
		super(msg);
	}

}
