package com.redbird.wehelp.dao;

/**
 * 基础DAO接口
 * @author cennanfang
 * @param <T>
 */
public interface BaseDao<T> {

	/**
	 * 添加到数据库
	 * @param pojo
	 */
	public void add(T pojo);
	
	/**
	 * 删除数据库中的一条记录
	 * @param id
	 */
	public void delete(int id);
	
	/**
	 * 更新数据库中的一条记录
	 * @param pojo
	 */
	public void update(T pojo);
	
	/**
	 * 查找数据库中的一条记录
	 * @param id
	 * @return
	 */
	public T find(int id);
	
}
