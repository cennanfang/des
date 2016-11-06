package com.redbird.wehelp.service;

import java.util.List;

import com.redbird.wehelp.pojo.ActiveUser;
import com.redbird.wehelp.pojo.Permission;
import com.redbird.wehelp.pojo.User;

/**
 * 用户管理层
 * @author cennanfang
 *
 */
public interface UserService {
	
	 public List<Permission> findPermissionsByUserId(int userId);

	/**
	 * 使用此方法效率更高，因为它将不再查询数据库获取用户信息
	 * 加载用户权限1、角色 2、权限资源
	 * @param userId
	 * @return 
	 */
	public ActiveUser loadPermissions(ActiveUser au);
	
	/**
	 * 通过用户名查找用户
	 * @param userName
	 * @return
	 */
	public User findByUserName(String userName);
	
}
