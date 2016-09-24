package com.redbird.wehelp.dao;

/**
 * 所有DAO继承接口
 * @author c
 *
 */
public interface BaseDao<T> {

	/**
	 * 添加pojo对象到数据库
	 * @param pojo
	 */
	public void add(T pojo);
	
	/**
	 * 从数据中删除pojo对象
	 * @param pojo
	 */
	public void delete(int id);
	
	/**
	 * 修改pojo对象
	 * @param pojo
	 */
	public void update(T pojo);
	
	/**
	 * 通过ID查找pojo对象
	 * @param id
	 * @return
	 */
	public T find(int id);
	
}
