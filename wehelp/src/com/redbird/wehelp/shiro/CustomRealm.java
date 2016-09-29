package com.redbird.wehelp.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.redbird.wehelp.exception.UserLoginException;
import com.redbird.wehelp.pojo.ActiveUser;
import com.redbird.wehelp.pojo.Permission;
import com.redbird.wehelp.pojo.User;
import com.redbird.wehelp.service.impl.UserServiceImpl;
import com.redbird.wehelp.util.UserUtils;

/**
 * �Զ���realm
 * 
 * @author c
 *
 */
public class CustomRealm extends AuthorizingRealm {

	private UserServiceImpl userService;

	@Override
	public void setName(String name) {
		super.setName("customRealm");
	}

	// ������֤
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// token���û������
		// ��һ����token��ȡ�������Ϣ
		String userName = (String) token.getPrincipal();
		User user = null;
		// �ڶ����������û������userCode�����ݿ��ѯ
		user = userService.findByUserName(userName);
		// �����ѯ��������null
		if (user == null) {
			throw new UserLoginException("�û��������������");
		}
		// �����ݿ��ѯ���ܺ�����
		String password = user.getPassword();
		
		ActiveUser activeUser = UserUtils.userCopyToActiveUser(user);
		// �����û�idȡ���˵�
		List<Permission> permissions = userService.findPermissionsByUserId(user.getId());
		activeUser.setPermissions(permissions);
		// �����ѯ��������֤��ϢAuthenticationInfo
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(activeUser, password,  
                ByteSource.Util.bytes(user.getSalt()), this.getName());  
		return authenticationInfo;
	}

	// ������Ȩ
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// ��principals��ȡ�������Ϣ
		// ��getPrimaryPrincipal��������ֵתΪ��ʵ�������
		// (���ϱ�doGetAuthenticationInfo��֤ͨ����䵽SimpleAuthenticationInfo�е��������)
		ActiveUser activeUser = (ActiveUser) principals.getPrimaryPrincipal();

		// ���������Ϣ��ȡȨ����Ϣ
		// �����ݿ��ȡ��Ȩ������
		List<Permission> permissions = activeUser.getPermissions();
		List<String> meus = new ArrayList<String>();
		if (permissions != null) {
			// �����ݿ�鵽Ȩ�ޱ�ǩ���ŵ�����
			for (Permission permission : permissions) {
				meus.add(permission.getUrl());
				System.out.println(activeUser.getUserName() + ":" + permission.getUrl());
			}
		}

		// ����ѯ����Ȩ��Ϣ��䵽simpleAuthorizationInfo������
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.addStringPermissions(meus);

		// ������Ȩ��Ϣ
		return simpleAuthorizationInfo;

	}

	// �������
	public void clearCached() {
		PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
		super.clearCache(principals);
	}

	public UserServiceImpl getUserService() {
		return userService;
	}

	public void setUserService(UserServiceImpl userService) {
		this.userService = userService;
	}

}