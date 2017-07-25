package com.fun.orm.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class IOUtils {
	
	public static final String PROJECT_JAVA_PATH = "D:/github/signal01/src/main/java/";
	public static final String PROJECT_RESOUCES_PATH = "D:/github/signal01/src/main/resources/";

	/**
	 * 包名转为绝对路径
	 * @param packageName
	 * @return
	 */
	public static String packageToPath(String packageName) {
		return packageName.replace(".", "/");
	}
	
	/**
	 * 获取src文件夹路径
	 * @return
	 */
	public static String getSrcPath() {
		File directory = new File("");
		String path = directory.getAbsolutePath() + "/src/";
		return path;
	}
	
	/**
	 * 写成实体文件
	 * @param content
	 * @throws IOException
	 */
	public static void writeModelToFile(String content, File outToFile) throws IOException {
		FileWriter fw = new FileWriter(outToFile);
		PrintWriter pw = new PrintWriter(fw);
		pw.println(content);
		pw.flush();
		pw.close();
	}
}
