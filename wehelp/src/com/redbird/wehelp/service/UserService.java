package com.redbird.wehelp.service;

import java.util.List;

import com.redbird.wehelp.pojo.Permission;
import com.redbird.wehelp.pojo.User;

/**
 * �û�������
 * @author c
 *
 */
public interface UserService {

	/**
	 * ͨ���û�ID�����û�Ȩ��
	 * @param userId
	 * @return
	 */
	public List<Permission> findPermissionsByUserId(int userId);
	
	/**
	 * ͨ���û��������û�
	 * @param userName
	 * @return
	 */
	public User findByUserName(String userName);
}
