package com.fun.orm.mapper;

import java.util.List;
import java.util.Map;

/**
 * 继承此接口即可使用该接口所有方法
 * @author redbird
 *
 * @param <Model> 实体类
 * @param <PK>    实体类主键类型
 */
public interface FunMapper<Model, PK> {

	/**
	 * 功能：主键查询
	 * @param pk
	 * @return
	 */
	public Model select(PK pk);
	
	/**
	 * 功能：参数查询
	 * @param model
	 * @return
	 */
	public List<Model> selectParam(Map<String, Object> params);
	
	/**
	 * 功能：添加一个对象
	 * @param model
	 */
	public void insert(Model model);
	
	/**
	 * 功能：批量插入
	 * @param models
	 */
	public void insertBatch(List<Model> models);
	
	/**
	 * 功能：更新一个对象
	 * @param model
	 */
	public void update(Model model);
	
	/**
	 * 功能：参数更新
	 * @param model
	 */
	public void updateParam(Map<String, Object> params);
	
	/**
	 * 功能：批量更新
	 * @param models
	 */
	public void updateBatch(List<Model> models);
	
	/**
	 * 功能：主键删除
	 * @param pk
	 */
	public void delete(PK pk);
	
	/**
	 * 功能：参数删除
	 * @param model
	 */
	public void deleteParam(Map<String, Object> params);
	
	/**
	 * 功能：功能批量删除
	 * @param pks
	 */
	public void deleteBatch(List<PK> pks);
	
	/**
	 * 功能：统计记录数
	 * @return
	 */
	public int count();
	
	/**
	 * 功能：参数统计记录数
	 * @param model
	 * @return
	 */
	public int countParam(Map<String, Object> params);
}
