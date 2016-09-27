package com.redbird.wehelp.service;

import java.util.List;

import com.redbird.wehelp.pojo.Permission;
import com.redbird.wehelp.pojo.User;

/**
 * 用户服务类
 * @author c
 *
 */
public interface UserService {

	/**
	 * 通过用户ID查找用户权限
	 * @param userId
	 * @return
	 */
	public List<Permission> findPermissionsByUserId(int userId);
	
	/**
	 * 通过用户名查找用户
	 * @param userName
	 * @return
	 */
	public User findByUserName(String userName);
}
