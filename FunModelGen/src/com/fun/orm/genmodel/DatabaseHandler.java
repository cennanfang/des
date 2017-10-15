package com.fun.orm.genmodel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fun.orm.genmodel.bean.ConstraintInfo;
import com.fun.orm.genmodel.bean.ConstraintInfo.ConstraintType;
import com.fun.orm.genmodel.bean.DatabaseConfig;

public class DatabaseHandler {
	
	private List<String> colNames; // 列名数组
	private List<String> colTypes; // 列名类型数组
	private List<String> colComments; // 注释
	private boolean isNeedJavaUtilPackage; // 是否需要导入包java.util.*
	private boolean isNeedJavaSqlsPackage; // 是否需要导入包java.sql.*
	
	
	/**
	 * 获取查询表结构的sql
	 * @param tableName
	 * @param dbName
	 * @return
	 */
	private String getTableSchemaSql(String tableName, String dbName) {
		StringBuffer sql = new StringBuffer();
		sql.append("select COLUMN_NAME,COLUMN_TYPE,COLUMN_KEY,COLUMN_COMMENT ");
		sql.append("from INFORMATION_SCHEMA.Columns ");
		sql.append("where TABLE_NAME = ");
		sql.append("'");
		sql.append(tableName);
		sql.append("'");
		if(dbName != null && !"".equals(dbName)) {
			sql.append(" and TABLE_SCHEMA=");
			sql.append("'");
			sql.append(dbName);
			sql.append("'");
		}
		sql.append(";");
		return sql.toString();
	}
	
	/**
	 * 获取表的主键外键结构
	 * @param tableName
	 * @param dbName
	 * @return
	 */
	private String getTableConstraintSchemaSql(String tableName, String dbName) {
		StringBuffer sql = new StringBuffer();
		sql.append("select table_schema, table_name, column_name, referenced_table_schema, referenced_table_name, referenced_column_name,constraint_name ");
		sql.append(" from information_schema.key_column_usage");
		sql.append(" where table_name = ");
		sql.append("'");
		sql.append(tableName);
		sql.append("'");
		if(dbName != null && !"".equals(dbName)) {
			sql.append(" and TABLE_SCHEMA=");
			sql.append("'");
			sql.append(dbName);
			sql.append("'");
		}
		sql.append(";");
		return sql.toString();
	}
	
	public Map<String, ConstraintInfo> readTableConstraint(Connection con, String tableName) throws SQLException {
		Map<String, ConstraintInfo> constraint = new HashMap<>();
		PreparedStatement pStemt = null;
		String sql = getTableConstraintSchemaSql(tableName, DatabaseConfig.DB_NAME);
		pStemt = con.prepareStatement(sql);
		ResultSet rs = pStemt.executeQuery(sql);
		while (rs.next()) {
			String colName = rs.getString("column_name");
			String refTable = rs.getString("referenced_table_name");
			String refCol = rs.getString("referenced_column_name");
			String constType = rs.getString("constraint_name");
			ConstraintInfo constraintInfo = new ConstraintInfo();
			constraintInfo.setColumnName(colName);
			constraintInfo.setRefColumn(refCol);
			constraintInfo.setRefTable(refTable);
			if("PRIMARY".equalsIgnoreCase(constType)) {
				constraintInfo.setConstraintType(ConstraintType.PRIMARY);
				constraint.put(colName, constraintInfo);
			} else if(constType.indexOf(tableName + "_ibfk_") != -1) {
				constraintInfo.setConstraintType(ConstraintType.FOREIGNKEY);
				constraint.put(colName, constraintInfo);
			}
		}
		pStemt.close();
		return constraint;
	}
	
	/**
	 * 获取表结构
	 * @param con
	 * @param tableName
	 * @throws SQLException
	 */
	public void readTableSchema(Connection con, String tableName) throws SQLException {
		/**
		 * 获取表结构
		 */
		PreparedStatement pStemt = null;
		String sql = getTableSchemaSql(tableName, DatabaseConfig.DB_NAME);
		pStemt = con.prepareStatement(sql);
		ResultSet rs = pStemt.executeQuery(sql);
		colComments = new ArrayList<String>();
		colNames = new ArrayList<String>();
		colTypes = new ArrayList<String>();
		isNeedJavaUtilPackage = false;
		isNeedJavaSqlsPackage = false;
		while (rs.next()) {
			String colName = rs.getString("COLUMN_NAME");
			String colType = rs.getString("COLUMN_TYPE");
			String colComment = rs.getString("COLUMN_COMMENT");
			colNames.add(colName);
			colTypes.add(colType);
			colComments.add(colComment);
			if (colType.indexOf("datetime")  != -1 || colType.indexOf("timestamp")  != -1) {
				isNeedJavaUtilPackage = true;
			}
			if (colType.indexOf("image") != -1 || colType.indexOf("text") != -1 ) {
				isNeedJavaSqlsPackage = true;
			}
		}
		pStemt.close();
	}

	public List<String> getColNames() {
		return colNames;
	}

	public List<String> getColTypes() {
		return colTypes;
	}

	public List<String> getColComments() {
		return colComments;
	}

	public boolean isNeedJavaUtilPackage() {
		return isNeedJavaUtilPackage;
	}

	public boolean isNeedJavaSqlsPackage() {
		return isNeedJavaSqlsPackage;
	}
}
