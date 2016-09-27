package com.redbird.wehelp.dao;

import com.redbird.wehelp.pojo.User;
import com.redbird.wehelp.util.PageModel;

/**
 * User的存储层
 * @author c
 *
 */
public interface UserDao extends BaseDao<User>{

	/**
	 *  通过用户名查找对象
	 * @param userName
	 * @return
	 */
	public User findByUserName(String userName);
	
	/**
	 *  分页查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageModel<User> findPageModel(int pageNo, int pageSize);
}