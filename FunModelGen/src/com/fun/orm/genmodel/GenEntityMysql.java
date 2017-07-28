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

import com.fun.orm.genmodel.bean.ConstraintInfo;
import com.fun.orm.genmodel.bean.DatabaseConfig;
import com.fun.orm.utils.IOUtils;
import com.fun.orm.utils.NameUtils;

public class GenEntityMysql {

	private String classPackage;// 指定实体生成所在包的路径
	private String authorName;// 作者名字
	private DatabaseConfig dbConfig;
	
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
	}

	public void generate(String writeOutPath, String tmpDir) throws ClassNotFoundException, SQLException, IOException {
		// 创建连接
		Connection con = null;
		Class.forName(dbConfig.getDriverClass());
		con = DriverManager.getConnection(dbConfig.getDbUrl(), dbConfig.getDbUser(), dbConfig.getDbPass());
		List<String> tableNames = readTables(con);
		for (String tableName : tableNames) {
			DatabaseHandler dbHandder = new DatabaseHandler();
			dbHandder.readTableSchema(con, tableName);
			Map<String, ConstraintInfo> cis = dbHandder.readTableConstraint(con, tableName);
			/**
			 * 解析并生产类实体
			 */
			String className = NameUtils
					.initcapUpCase(NameUtils.underline2Camel(tableName.substring(dbConfig.getTablePrefix().length()), false));
			String content = new ModelCreator(false, dbHandder.isNeedJavaUtilPackage(), dbHandder.isNeedJavaSqlsPackage(),
					classPackage, authorName, className, dbConfig.getTablePrefix(), dbHandder.getColNames(), dbHandder.getColTypes(),
					dbHandder.getColComments(), cis).parse(tableName);
			/**
			 * 将实体写入文件
			 */
			String packagePath = IOUtils.packageToPath(classPackage);
			String writeDir = writeOutPath + packagePath;
			File dir = new File(writeDir);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			IOUtils.writeModelToFile(content, new File(writeDir, className + ".java"));
			/**
			 * 工作路径
			 */
			File workDir = new File(tmpDir + packagePath);
			if (!workDir.exists()) {
				workDir.mkdirs();
			}
			content = new ModelCreator(true, dbHandder.isNeedJavaUtilPackage(), dbHandder.isNeedJavaSqlsPackage(),
					classPackage, authorName, className, dbConfig.getTablePrefix(), dbHandder.getColNames(), dbHandder.getColTypes(),
					dbHandder.getColComments(), cis).parse(tableName);
			IOUtils.writeModelToFile(content, new File(workDir, className + ".java"));
		}
		if (con != null) {
			con.close();
		}
	}

	/**
	 * 功能：读取数据库中的表
	 * 
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


}