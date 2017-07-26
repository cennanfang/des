package com.fun.orm.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class IOUtils {
	
	/**
	 * 包名转为绝对路径
	 * @param packageName
	 * @return
	 */
	public static String packageToPath(String packageName) {
		return packageName.replace(".", "/");
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
