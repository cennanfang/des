package com.redbird.wehelp.dao;

import org.springframework.stereotype.Repository;

import com.redbird.wehelp.pojo.User;
import com.redbird.wehelp.utils.PageModel;

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
	
	
	/**
	 * 分页查找用户对象
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageModel<User> findPageModel(int pageNo, int pageSize);
}