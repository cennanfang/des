package com.redbird.wehelp.dao;

import com.redbird.wehelp.pojo.BasePojo;
import com.redbird.wehelp.util.PageModel;

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
	public void add(BasePojo pojo);
	
	/**
	 * ��������ɾ��pojo����
	 * @param pojo
	 */
	public void delete(String id);
	
	/**
	 * �޸�pojo����
	 * @param pojo
	 */
	public void update(BasePojo pojo);
	
	/**
	 * ͨ��ID����pojo����
	 * @param id
	 * @return
	 */
	public T find(String id);
	
	/**
	 *  ��ҳ��ѯ
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageModel find(int pageNo, int pageSize);
}
