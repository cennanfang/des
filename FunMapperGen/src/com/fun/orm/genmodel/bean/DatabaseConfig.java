package com.fun.orm.genmodel.bean;

public class DatabaseConfig {

	// 数据库连接
	private static final String URL = "jdbc:mysql://localhost:3306/signalsrc";
	private static final String NAME = "root";
	private static final String PASS = "Root_123";
	private static final String DRIVER = "com.mysql.jdbc.Driver";

	public DatabaseConfig() {
		this.dbPass = PASS;
		this.dbUrl = URL;
		this.dbUser = NAME;
		this.driverClass = DRIVER;
	}
	
	private String dbUrl;
	
	private String dbUser;
	
	private String dbPass;
	
	private String driverClass;
	
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
}
