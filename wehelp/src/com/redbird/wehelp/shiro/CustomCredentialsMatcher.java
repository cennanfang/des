package com.redbird.wehelp.shiro;

import java.io.UnsupportedEncodingException;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.util.ByteSource;

import com.redbird.wehelp.util.PasswordEncryption;

/**
 * 自定义 密码验证类
 * @author c
 *
 */
public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {
	@Override
	public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		SimpleAuthenticationInfo sai = (SimpleAuthenticationInfo) info;
		String tokenCredentials = String.valueOf(token.getPassword());
		String accountCredentials = (String)getCredentials(info);
		ByteSource salt = sai.getCredentialsSalt();
		boolean isEquals = false;
		try {
			isEquals = PasswordEncryption.checkPassword(tokenCredentials, accountCredentials, salt.getBytes());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// 将密码加密与系统加密后的密码校验，内容一致就返回true,不一致就返回false
		return isEquals;
	}

}