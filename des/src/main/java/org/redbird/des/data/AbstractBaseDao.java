package org.redbird.des.data;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 继承于BaseDao的抽象类，作为所有Dao类的父类
 * @author cennanfang
 * @date 2015年11月14日
 * @filename AbstractBaseDao.java
 * @param <BasePojo>
 */
public abstract class AbstractBaseDao<T> extends HibernateDaoSupport implements BaseDao<BasePojo> {

	@Override
	public void save(BasePojo basePojo) {
		getHibernateTemplate().save(basePojo);
	}
	
	@Override
	public void remove(String uuid) {
		BasePojo entity = find(uuid);
		getHibernateTemplate().delete(entity);
	}

	@Override
	public BasePojo find(String uuid) {
		return (BasePojo) getHibernateTemplate().load(BasePojo.class, uuid);
	}

	@Override
	public void remove(BasePojo basePojo) {
		getHibernateTemplate().delete(basePojo);
	}
}
