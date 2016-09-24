package com.redbird.wehelp.dao;

import java.util.List;

import com.redbird.wehelp.pojo.UserRole;

public interface UserRoleDao extends BaseDao<UserRole>{
	
	/**
	 * 通过用户ID查找用户角色列表
	 * @param userId
	 * @return
	 */
	public List<UserRole> findByUserId(int userId);
}