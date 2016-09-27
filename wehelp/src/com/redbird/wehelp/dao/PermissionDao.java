package com.redbird.wehelp.dao;

import java.util.List;

import com.redbird.wehelp.pojo.Permission;

public interface PermissionDao extends BaseDao<Permission>{

	/**
	 * ͨ����ɫID���Ҷ�ӦȨ��
	 * @param roleId
	 * @return
	 */
	public List<Permission> findPermissionByRoleId(int roleId);
}