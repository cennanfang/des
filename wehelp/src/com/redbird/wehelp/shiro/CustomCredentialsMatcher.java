package com.redbird.wehelp.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * �Զ��� ������֤��
 * 
 * @author c
 *
 */
public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {
	@Override
	public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;

		Object tokenCredentials = String.valueOf(token.getPassword());
		Object accountCredentials = getCredentials(info);
		// �����������ϵͳ���ܺ������У�飬����һ�¾ͷ���true,��һ�¾ͷ���false
		return equals(tokenCredentials, accountCredentials);
	}

}