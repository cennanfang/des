package com.redbird.wehelp.dao;

import org.springframework.stereotype.Repository;

import com.redbird.wehelp.pojo.User;

/**
 * 用户对象DAO接口
 * @author cennanfang
 *
 */
@Repository
public interface UserDao extends BaseDao<User>{

	/**
	 * 通过用户名查找用户对象
	 * @param userName
	 * @return
	 */
	public User findByUserName(String userName);
	
}