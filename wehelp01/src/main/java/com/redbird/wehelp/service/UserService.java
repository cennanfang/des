package com.redbird.wehelp.service;

import java.util.Set;

import com.redbird.wehelp.pojo.User;

/**
 * 用户服务层管理类
 * @author cennanfang
 *
 */
public interface UserService {

	
	/**
	 * 通过用户名查找用户
	 * @param username
	 * @return userId
	 */
	public User findByUserName(String userName);
	
	/**
	 * 获取用户拥有的角色名称
	 * @return
	 */
	public Set<String> userRoleNames(int userId);
	
	/**
	 * 用户拥有的权限列表
	 * @return
	 */
	public Set<String> userPermissionUrls(int userId);
}
