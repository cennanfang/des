package com.fun.orm.genmodel;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.fun.orm.genmodel.bean.ConstraintInfo;
import com.fun.orm.genmodel.bean.DatabaseConfig;
import com.fun.orm.utils.Constants;
import com.fun.orm.utils.IOUtils;
import com.fun.orm.utils.NameUtils;

public class GenEntityMysql {
	private Logger logger  =  Logger.getLogger(GenEntityMysql.class);
	
	private String classPackage;// 指定实体生成所在包的路径
	private String authorName;// 作者名字
	private DatabaseConfig dbConfig;
	public static final String TABLE_PREFIX = "t_";

	/**
	 * 构造函数
	 * 
	 * @param tablePrefix
	 *            表前缀，生成实体时去掉
	 * @param classPackage
	 *            包
	 */
	public GenEntityMysql(String classPackage, String authorName, DatabaseConfig dbConfig) {
		this.classPackage = classPackage;
		this.authorName = authorName;
		this.dbConfig = dbConfig;
		logger.info("authorName:" +  authorName);
	}

	public void generate(String writeOutPath) {
		// 创建连接
		Connection con = null;
		try {
			try {
				Class.forName(dbConfig.getDriverClass());
				logger.info("DriverClass:" + dbConfig.getDriverClass());
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			con = DriverManager.getConnection(dbConfig.getDbUrl(), dbConfig.getDbUser(), dbConfig.getDbPass());
			List<String> tableNames = readTables(con);
			for (String tableName : tableNames) {
				DatabaseHandler dbHandder = new DatabaseHandler();
				dbHandder.readTableSchema(con, tableName);
				Map<String, ConstraintInfo> cis = dbHandder.readTableConstraint(con, tableName);
				/**
				 * 解析并生产类实体
				 */
				String className = NameUtils.initcapUpCase(NameUtils.underline2Camel(tableName.substring(TABLE_PREFIX.length()), false));
				String content = new ModelCreator(
						dbHandder.isNeedJavaUtilPackage(), 
						dbHandder.isNeedJavaSqlsPackage(), 
						classPackage, 
						authorName, 
						className, 
						dbHandder.getColNames(), 
						dbHandder.getColTypes(), 
						dbHandder.getColComments(),
						cis).parse(tableName);
				/**
				 * 将实体写入文件
				 */
				String writeDir =  writeOutPath + IOUtils.packageToPath(classPackage);
				File dir = new File(writeDir);
				if(!dir.exists()) {
					dir.mkdirs();
				}
				IOUtils.writeModelToFile(content, new File(writeDir, className + ".java"));
				String outToDir =  Constants.PROJECT_JAVA_PATH + IOUtils.packageToPath(classPackage);
				File outDir = new File(outToDir);
				if(!outDir.exists()) {
					outDir.mkdirs();
				}
				IOUtils.writeModelToFile(content, new File(outDir, className + ".java"));
			}
		} catch (SQLException | IOException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error(e.getMessage());
			}
		}
	}

	/**
	 * 功能：读取数据库中的表
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	private List<String> readTables(Connection con) throws SQLException {
		List<String> tableNames = new ArrayList<String>();
		PreparedStatement pStemt = null;
		String sql = "show tables";
		pStemt = con.prepareStatement(sql);
		ResultSet rs = pStemt.executeQuery(sql);
		while (rs.next()) {
			tableNames.add(rs.getString(1));
		}
		pStemt.close();
		return tableNames;
	}

	/**
	 * 出口 TODO
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String classPackage = "com.cen.signal.model";
		new GenEntityMysql(classPackage, "cennanfang", new DatabaseConfig()).generate(IOUtils.getSrcPath());

	}

}