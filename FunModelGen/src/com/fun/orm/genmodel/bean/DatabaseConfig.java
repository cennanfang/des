package com.fun.orm.genmodel.bean;

public class DatabaseConfig {

	// 数据库连接
	public static final String DB_NAME = "wehelpsrc";
	private static final String URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
	private static final String NAME = "root";
	private static final String PASS = "Root_123";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String TABLE_PREFIX = "t_";
	

	public DatabaseConfig() {
		this.dbPass = PASS;
		this.dbUrl = URL;
		this.dbUser = NAME;
		this.driverClass = DRIVER;
		this.tablePrefix = TABLE_PREFIX;
	}
	
	public DatabaseConfig(String dbUrl, String dbUser, String dbPass, String driverClass, String tablePrefix) {
		super();
		this.dbUrl = dbUrl;
		this.dbUser = dbUser;
		this.dbPass = dbPass;
		this.driverClass = driverClass;
		this.tablePrefix = tablePrefix;
	}
	
	private String dbUrl;
	
	private String dbUser;
	
	private String dbPass;
	
	private String driverClass;
	
	private String tablePrefix;
	
	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String getDbUser() {
		return dbUser;
	}

	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}

	public String getDbPass() {
		return dbPass;
	}

	public void setDbPass(String dbPass) {
		this.dbPass = dbPass;
	}

	public String getDriverClass() {
		return driverClass;
	}

	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

	public String getTablePrefix() {
		return tablePrefix;
	}
}
