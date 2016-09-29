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
 * 自定义realm
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

	// 用于认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// token是用户输入的
		// 第一步从token中取出身份信息
		String userName = (String) token.getPrincipal();
		User user = null;
		// 第二步：根据用户输入的userCode从数据库查询
		user = userService.findByUserName(userName);
		// 如果查询不到返回null
		if (user == null) {
			throw new UserLoginException("用户名或者密码错误。");
		}
		// 从数据库查询加密后密码
		String password = user.getPassword();
		
		ActiveUser activeUser = UserUtils.userCopyToActiveUser(user);
		// 根据用户id取出菜单
		List<Permission> permissions = userService.findPermissionsByUserId(user.getId());
		activeUser.setPermissions(permissions);
		// 如果查询到返回认证信息AuthenticationInfo
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(activeUser, password,  
                ByteSource.Util.bytes(user.getSalt()), this.getName());  
		return authenticationInfo;
	}

	// 用于授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 从principals获取主身份信息
		// 将getPrimaryPrincipal方法返回值转为真实身份类型
		// (在上边doGetAuthenticationInfo认证通过填充到SimpleAuthenticationInfo中的身份类型)
		ActiveUser activeUser = (ActiveUser) principals.getPrimaryPrincipal();

		// 根据身份信息获取权限信息
		// 从数据库获取到权限数据
		List<Permission> permissions = activeUser.getPermissions();
		List<String> meus = new ArrayList<String>();
		if (permissions != null) {
			// 将数据库查到权限标签符放到集合
			for (Permission permission : permissions) {
				meus.add(permission.getUrl());
				System.out.println(activeUser.getUserName() + ":" + permission.getUrl());
			}
		}

		// 将查询到授权信息填充到simpleAuthorizationInfo对象中
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.addStringPermissions(meus);

		// 返回授权信息
		return simpleAuthorizationInfo;

	}

	// 清除缓存
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