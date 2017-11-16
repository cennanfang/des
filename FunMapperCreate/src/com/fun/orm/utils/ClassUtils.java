package com.fun.orm.utils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class ClassUtils {

	/**
	 * 编译java类 使用rt.jar中的javax.tools包提供的编译器
	 * 
	 * @param name
	 *            类的全限定包名 不带后缀 例如com.test.Notice 而不要写成com.test.Notice.java
	 * @throws MalformedURLException
	 * @throws ClassNotFoundException
	 * @throws java.io.IOException
	 */
	public static URLClassLoader getClassLoader(String modelsClassAbsolutPath) throws MalformedURLException {
		URL[] urls = new URL[] { new URL("file:/" + modelsClassAbsolutPath) };
		URLClassLoader loader = new URLClassLoader(urls);
		return loader;
	}

	/**
	 * @param files
	 * @throws IOException 
	 */
	public static boolean compileTheJavaSrcFile(File[] files) throws IOException {
		boolean flag = false;
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		System.out.println("JavaCompiler=" + compiler);
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
		CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, fileMgr.getJavaFileObjects(files));
		flag = t.call();
		fileMgr.close();
		return flag;
	}

	/**
	 * 删除文件
	 * @param files
	 * @return
	 */
	public static boolean deleteFiles(File[] files) {
		boolean flag = false;
		if(files != null) {
			for (File file : files) {
				if(file.exists() && file.isFile()) {
					flag = file.delete();
				}
			}
		}
		return flag;
	}
}
