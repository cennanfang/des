package com.redbird.wehelp.dao;

import java.util.List;

import com.redbird.wehelp.pojo.UserRole;

public interface UserRoleDao extends BaseDao<UserRole>{
	
	/**
	 * ͨ���û�ID�����û���ɫ�б�
	 * @param userId
	 * @return
	 */
	public List<UserRole> findByUserId(int userId);
}