package com.redbird.wehelp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.redbird.wehelp.pojo.UserRole;

@Repository
public interface UserRoleDao extends BaseDao<UserRole>{
	/**
	 * 查找用户角色列表
	 * @param userId
	 * @return
	 */
	public List<UserRole> findByUserId(int userId);
	
	/**
	 * 查找用户角色列表
	 * @param userName
	 * @return
	 */
	// TODO 这个方法可以不要了，打需要删除map。xml文件
	public List<UserRole> findByUserName(String userName);
}