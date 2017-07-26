package com.fun.orm.retrieve;

import java.util.ArrayList;
import java.util.List;

import com.fun.orm.retrieve.bean.ModelProperty;

/**
 * 实体类信息
 * @author redbird
 *
 */
public class ModelInfoHolder {
	
	/**
	 * 类名
	 */
	private String className;
	
	/**
	 * 表名
	 */
	private String tableName;
	
	/**
	 * 属性
	 */
	private List<ModelProperty> propertyList;

	public ModelInfoHolder() {
		propertyList = new ArrayList<ModelProperty>();
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<ModelProperty> getPropertyList() {
		return propertyList;
	}

	public void setPropertyList(List<ModelProperty> propertyList) {
		this.propertyList = propertyList;
	}
}
