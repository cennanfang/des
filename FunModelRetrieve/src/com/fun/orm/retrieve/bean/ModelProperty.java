package com.fun.orm.retrieve.bean;

/**
 * 列 对象
 * @author a
 *
 */
public class ModelProperty{
	
	/**
	 * 字段类型
	 */
	private String javaType;
	
	/**
	 * 字段类型
	 */
	private String packageJavaType;

	/**
	 * 实体字段
	 */
	private String modelProperty;
	
	/**
	 * 表中字段
	 */
	private String tableColumn;
	
	public ModelProperty() {
	}

	public ModelProperty(String javaType, String modelProperty, String tableColumn) {
		this.javaType = javaType;
		this.modelProperty = modelProperty;
		this.tableColumn = tableColumn;
	}

	public String getModelProperty() {
		return modelProperty;
	}

	public void setModelProperty(String modelProperty) {
		this.modelProperty = modelProperty;
	}

	public String getTableColumn() {
		return tableColumn;
	}

	public void setTableColumn(String tableColumn) {
		this.tableColumn = tableColumn;
	}

	public String getJavaType() {
		return javaType;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ModelProperty) {
			ModelProperty c = (ModelProperty) obj;
			boolean result = false;
			if(modelProperty.equals(c.modelProperty)) {
				result = true;
			}
			return result;
		} else {
			return false;
		}
	}

	public String getPackageJavaType() {
		return packageJavaType;
	}

	public void setPackageJavaType(String packageJavaType) {
		this.packageJavaType = packageJavaType;
	}
}
