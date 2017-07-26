package com.fun.orm.genmodel.bean;

/**
 * 
 * @author redbird
 *
 */
public class ConstraintInfo {
	
	public enum ConstraintType {
		PRIMARY, FOREIGNKEY;
	}

	private String columnName;
	
	private ConstraintType constraintType;
	
	private String refTable;
	
	private String refColumn;

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public ConstraintType getConstraintType() {
		return constraintType;
	}

	public void setConstraintType(ConstraintType constraintType) {
		this.constraintType = constraintType;
	}

	public String getRefTable() {
		return refTable;
	}

	public void setRefTable(String refTable) {
		this.refTable = refTable;
	}

	public String getRefColumn() {
		return refColumn;
	}

	public void setRefColumn(String refColumn) {
		this.refColumn = refColumn;
	}
}
