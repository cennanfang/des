package com.fun.orm.genmodel;

import java.util.Date;
import java.util.List;
import java.util.Map;


import com.fun.orm.genmodel.bean.ConstraintInfo;
import com.fun.orm.genmodel.bean.ConstraintInfo.ConstraintType;
import com.fun.orm.utils.NameUtils;

public class ModelCreator {
	public static final String ANNO_PACKAGE = "com.fun.orm.annotation";
	public static final String ANNO_PRIMARY = "FunPrimary"; 
	public static final String ANNO_FOREIGNKEY = "FunForiegn";
	public static final String ANNO_COLUMN = "FunColumn";
	public static final String ANNO_TABLE_NAME = "FunTable";
	private boolean isNeedJavaUtilPackage; // 是否需要导入包java.util.*
	private boolean isNeedJavaSqlsPackage; // 是否需要导入包java.sql.*
	
	private String packageOutPath;// 指定实体生成所在包的路径
	private String authorName;// 作者名字
	private String className;
	private String tablePrefix;
	
	private List<String> colNames; // 列名数组
	private List<String> colTypes; // 列名类型数组
	private List<String> colComments; // 注释
	private Map<String, ConstraintInfo> conInfos;
	
	private StringBuffer sbImport;
	private StringBuffer sbPreporty;
	private StringBuffer sbMethod;
	
	private boolean isImportFK = false;
	private boolean isImportPK = false;
	private boolean isImportCol = false;
	private boolean isImportTB = false;
	
	
	public ModelCreator(boolean isNeedJavaUtilPackage, boolean isNeedJavaSqlsPackage, String packageOutPath,
			String authorName, String className, String tablePrefix, List<String> colNames, List<String> colTypes,
			List<String> colComments, Map<String, ConstraintInfo> conInfos) {
		this.isNeedJavaUtilPackage = isNeedJavaUtilPackage;
		this.isNeedJavaSqlsPackage = isNeedJavaSqlsPackage;
		this.packageOutPath = packageOutPath;
		this.authorName = authorName;
		this.className = className;
		this.tablePrefix = tablePrefix;
		this.colNames = colNames;
		this.colTypes = colTypes;
		this.colComments = colComments;
		this.conInfos = conInfos;
		
	}

	/**
	 * 功能：生成实体类主体代码
	 * 
	 * @param colnames
	 * @param colTypes
	 * @param colSizes
	 * @return
	 */
	public String parse(String tableName) {
		sbImport = new StringBuffer();
		sbPreporty = new StringBuffer();
		sbMethod = new StringBuffer();
		sbImport.append("package " + this.packageOutPath + ";\r\n");
		sbImport.append("\r\n");
		// 判断是否导入工具包
		if (isNeedJavaUtilPackage) {
			sbImport.append("import java.util.Date;\r\n");
		}
		if (isNeedJavaSqlsPackage) {
			sbImport.append("import java.sql.*;\r\n");
		}
		sbPreporty.append("\r\n");
		// 注释部分
		sbPreporty.append("/**\r\n");
		sbPreporty.append("* " + className + " 实体类\r\n");
		sbPreporty.append("* " + new Date() + " " + this.authorName + "\r\n");
		sbPreporty.append("*/ \r\n");
		// 实体部分
		sbPreporty.append("@");
		sbPreporty.append(ANNO_TABLE_NAME);
		sbPreporty.append("(\"");
		sbPreporty.append(tableName);
		sbPreporty.append("\")\r\n");
		isImportTB = true;
		sbPreporty.append("public class " + className + "{\r\n");
		processClassBody(sbPreporty);// 属性
		sbMethod.append("}\r\n");
		importAnnoClass();
		return sbImport.append(sbPreporty.append(sbMethod.toString()).toString()).toString();
	}

	/**
	 * 功能：生成所有属性
	 * 
	 * @param sb
	 */
	private void processClassBody(StringBuffer sb) {
		for (int i = 0; i < colNames.size(); i++) {
			sb.append("\r\n");
			sb.append("\t/**\r\n");
			sb.append("\t* " + colComments.get(i) + "\r\n");
			sb.append("\t*/ \r\n");
			String colName = colNames.get(i);
			ConstraintInfo ci = conInfos.get(colName);
			if(ci != null) {
				if(ci.getConstraintType().equals(ConstraintType.PRIMARY)) {
					sb.append("\t@" + ANNO_PRIMARY);
					sb.append("(\"");
					sb.append(colName);
					sb.append("\")\r\n");
					sb.append("\tprivate " + sqlType2JavaType(colTypes.get(i)) + " " + NameUtils.underline2Camel(colName, true)
					+ ";\r\n");
					isImportPK = true;
					processMethod(colName, sqlType2JavaType(colTypes.get(i)));
				} else if(ci.getConstraintType().equals(ConstraintType.FOREIGNKEY)) {
					sb.append("\t@" + ANNO_FOREIGNKEY);
					sb.append("(");
					sb.append("referencedTable=\"" + ci.getRefTable());
					sb.append("\", ");
					sb.append("referencedColumn=\"" + ci.getRefColumn());
					sb.append("\")\r\n");
					isImportFK = true;
					addAnnoColumn(sb, colName);;
					String classType = NameUtils.initcapUpCase(NameUtils.underline2Camel(ci.getRefTable().substring(tablePrefix.length()), true));
					String property = NameUtils.initcapLowerCase(classType);
					sb.append("\tprivate " + classType + " " + property + ";\r\n");
					//sbImport.append("import " + packageOutPath + "." + classType);
					//sbImport.append(";\r\n");
					wirteMethod(property, classType, classType);
				}
				
			} else {
				sb.append("\tprivate " + sqlType2JavaType(colTypes.get(i)) + " " + NameUtils.underline2Camel(colName, true)
					+ ";\r\n");
				processMethod(colName, sqlType2JavaType(colTypes.get(i)));
				
			}
		}
	}
	
	private void addAnnoColumn(StringBuffer sb, String colName) {
		sb.append("\t@" + ANNO_COLUMN);
		sb.append("(\"");
		sb.append(colName);
		sb.append("\")\r\n");
		isImportCol = true;
	}
	
	private void importAnnoClass() {
		if(isImportTB) {
			sbImport.append("import " + ANNO_PACKAGE + "." + ANNO_TABLE_NAME);
			sbImport.append(";\r\n");
		}
		if(isImportPK) {
			sbImport.append("import " + ANNO_PACKAGE + "." + ANNO_PRIMARY);
			sbImport.append(";\r\n");
		}
		if(isImportFK) {
			sbImport.append("import " + ANNO_PACKAGE + "." + ANNO_FOREIGNKEY);
			sbImport.append(";\r\n");
		}
		if(isImportCol) {
			sbImport.append("import " + ANNO_PACKAGE + "." + ANNO_COLUMN);
			sbImport.append(";\r\n");
		}
	}
	
	/**
	 * 功能：生成所有方法
	 * 
	 * @param sb
	 */
	private void processMethod(String colName, String colType) {
		String property = NameUtils.underline2Camel(colName, true);
		String propertyMethod = NameUtils.underline2Camel(colName, false);
		wirteMethod(property, propertyMethod, colType);
	}
	
	/**
	 * 直接写入
	 * @param property
	 * @param propertyMethod
	 * @param colType
	 */
	private void wirteMethod(String property, String propertyMethod,  String colType) {
		sbMethod.append("\r\n");
		sbMethod.append("\tpublic void set" + propertyMethod + "(" + colType + " " + property
				+ "){\r\n");
		sbMethod.append("\t\tthis." + property + " = " + property + ";\r\n");
		sbMethod.append("\t}\r\n");
		sbMethod.append("\r\n");
		sbMethod.append("\tpublic " + colType + " get" + propertyMethod + "(){\r\n");
		sbMethod.append("\t\treturn " + property + ";\r\n");
		sbMethod.append("\t}\r\n");
	}

	/**
	 * 功能：获得列的数据类型
	 * 
	 * @param sqlType
	 * @return
	 */
	private String sqlType2JavaType(String sqlType) {
		if (sqlType.indexOf("bit") != -1) {
			return "Boolean";
		} else if (sqlType.indexOf("tinyint") != -1) {
			return "Byte";
		} else if (sqlType.indexOf("smallint") != -1) {
			return "Short";
		} else if (sqlType.indexOf("int") != -1) {
			return "Integer";
		} else if (sqlType.indexOf("bigint") != -1) {
			return "Long";
		} else if (sqlType.indexOf("float") != -1) {
			return "Float";
		} else if (sqlType.indexOf("decimal") != -1 || sqlType.indexOf("numeric") != -1
				|| sqlType.indexOf("real") != -1 || sqlType.indexOf("money") != -1
				|| sqlType.indexOf("smallmoney") != -1) {
			return "Double";
		} else if (sqlType.indexOf("varchar") != -1 || sqlType.indexOf("char") != -1
				|| sqlType.indexOf("nvarchar")  != -1 || sqlType.indexOf("nchar") != -1
				|| sqlType.indexOf("text")  != -1) {
			return "String";
		} else if (sqlType.indexOf("datetime") != -1) {
			return "Date";
		} else if (sqlType.indexOf("image") != -1) {
			return "Blod";
		} else if (sqlType.indexOf("timestamp") != -1) {
			return "Date";
		}

		return null;
	}

}
