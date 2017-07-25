package com.fun.orm.retrieve.bean;

public class ReferencedProperty extends ModelProperty {

	/**
	 * 外键表名
	 */
	private String referencedTable;
	
	/**
	 * 引用表内的字段
	 */
	private String referencedColumn;
	
	public String getReferencedTable() {
		return referencedTable;
	}

	public void setReferencedTable(String referencedTable) {
		this.referencedTable = referencedTable;
	}

	public String getReferencedColumn() {
		return referencedColumn;
	}

	public void setReferencedColumn(String referencedColumn) {
		this.referencedColumn = referencedColumn;
	}
	

}
