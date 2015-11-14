package org.redbird.des.data;

/**
 * 所有Dao的基础接口
 * @author cennanfang
 * @date 2015年11月14日
 * @filename BaseDao.java
 */
public interface BaseDao<T> {
	// 保存
	public void save(T t);
	// 获取
	public T find(String uuid);
	// 删除
	public void remove(String uuid);
	// 查找 
	public void remove(T t);
}
