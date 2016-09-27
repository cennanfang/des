package com.redbird.wehelp.dao;

import java.util.List;

import com.redbird.wehelp.pojo.Permission;

public interface PermissionDao extends BaseDao<Permission>{

	/**
	 * 通过角色ID查找对应权限
	 * @param roleId
	 * @return
	 */
	public List<Permission> findPermissionByRoleId(int roleId);
}