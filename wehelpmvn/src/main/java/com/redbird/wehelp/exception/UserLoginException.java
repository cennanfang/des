package com.redbird.wehelp.exception;

import org.apache.shiro.authc.AuthenticationException;

public class UserLoginException extends AuthenticationException {
	private static final long serialVersionUID = -3895229790658241624L;
	
	public UserLoginException(String msg) {
		super(msg);
	}

}
