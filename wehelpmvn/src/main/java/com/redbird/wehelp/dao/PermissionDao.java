package com.redbird.wehelp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.redbird.wehelp.pojo.Permission;
@Repository
public interface PermissionDao extends BaseDao<Permission>{

	/**
	 * 查找角色所拥有的权限
	 * @param roleId
	 * @return
	 */
	public List<Permission> findPermissionByRoleId(int roleId);
	
}