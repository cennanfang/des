package com.redbird.wehelp.dao;

import com.redbird.wehelp.pojo.User;
import com.redbird.wehelp.util.PageModel;

/**
 * User�Ĵ洢��
 * @author c
 *
 */
public interface UserDao extends BaseDao<User>{

	/**
	 *  ͨ���û������Ҷ���
	 * @param userName
	 * @return
	 */
	public User findByUserName(String userName);
	
	/**
	 *  ��ҳ��ѯ
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageModel<User> findPageModel(int pageNo, int pageSize);
}