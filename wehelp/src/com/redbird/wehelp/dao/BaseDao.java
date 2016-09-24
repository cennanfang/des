package com.redbird.wehelp.dao;

/**
 * ����DAO�̳нӿ�
 * @author c
 *
 */
public interface BaseDao<T> {

	/**
	 * ���pojo�������ݿ�
	 * @param pojo
	 */
	public void add(T pojo);
	
	/**
	 * ��������ɾ��pojo����
	 * @param pojo
	 */
	public void delete(int id);
	
	/**
	 * �޸�pojo����
	 * @param pojo
	 */
	public void update(T pojo);
	
	/**
	 * ͨ��ID����pojo����
	 * @param id
	 * @return
	 */
	public T find(int id);
	
}
