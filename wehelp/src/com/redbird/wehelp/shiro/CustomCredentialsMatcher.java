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
 * �Զ��� ������֤��
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
		// �����������ϵͳ���ܺ������У�飬����һ�¾ͷ���true,��һ�¾ͷ���false
		return isEquals;
	}

}