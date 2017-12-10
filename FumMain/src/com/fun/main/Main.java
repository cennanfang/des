package com.fun.main;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import com.fun.orm.genmodel.GenEntityMysql;
import com.fun.orm.genmodel.bean.DatabaseConfig;
import com.fun.orm.genxml.Generator;

public class Main {

	public static void main(String[] args) {
		String classPath = "E:\\c\\dev\\git_repo\\wehelp\\src\\main\\java\\";
		String modelPackage = "com.buliyiren.wehelp.model";
		String mybatisXmlPath = "E:\\c\\dev\\git_repo\\wehelp\\src\\main\\resources\\mybatis_mapper\\";
		String mapperPackage = "com.buliyiren.wehelp.mapper";
		String tmpDir = System.getProperty("user.dir") + File.separator + "tmp" + File.separator;
		System.out.println("tmpDir=" + tmpDir);
		File tmpDirFile = new File(tmpDir);
		if(tmpDirFile.exists()) {
			tmpDirFile.delete();
		}
		// 生成实体类
		try {
			new GenEntityMysql(modelPackage, "cennanfang", new DatabaseConfig()).generate(classPath, tmpDir);
		} catch (ClassNotFoundException | SQLException | IOException e1) {
			e1.printStackTrace();
		}

		try {
			new Generator(tmpDir, mybatisXmlPath, modelPackage, mapperPackage).generate();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
}
