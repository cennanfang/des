package com.fun.orm.genxml;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import com.fun.orm.retrieve.ModelInfoHolder;
import com.fun.orm.retrieve.RetrieveModel;
import com.fun.orm.utils.ClassUtils;
import com.fun.orm.utils.IOUtils;

public class ModelsReader {

	private String modelPackage;
	
	private String modelsPath;
	
	private String modelsAbsolutePath;
	
	/**
	 * 需要传入实体类的包名和绝对路径
	 * @param modelPackage 包名
	 * @param modelsPath   所在的路径
	 */
	public ModelsReader(String modelPackage, String modelsPath) {
		this.modelPackage = modelPackage;
		this.modelsPath = modelsPath;
		this.modelsAbsolutePath = modelsPath + IOUtils.packageToPath(modelPackage);
	}

	/**
	 * 获取说有实体类的结构
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException 
	 */
	public List<ModelInfoHolder> excute() throws ClassNotFoundException, IOException {
		// 读取路径下的所有实体类
		String[] modelClassNames = readModelNames(modelPackage, modelsAbsolutePath);
		// 编译所有类
		complieModels(modelPackage, modelsAbsolutePath);
		// 解析所有类
		List<ModelInfoHolder> mihs = analysisModels(modelClassNames);
		// 删除编译生成的类
		// deleteClassFile(modelsPath, modelClassNames);
		// 返回实体类信息
		return mihs;
	}
	
	/**
	 * 分析所有实体类
	 * @param modelClassNames
	 * @throws ClassNotFoundException
	 * @throws MalformedURLException 
	 */
	public List<ModelInfoHolder> analysisModels(String[] modelClassNames) throws ClassNotFoundException, MalformedURLException {
		RetrieveModel retrieveModel = new RetrieveModel();
		List<ModelInfoHolder> mihs = new ArrayList<>();
		URLClassLoader loader = ClassUtils.getClassLoader(modelsPath);
		for(String name : modelClassNames) {
			ModelInfoHolder mih = retrieveModel.retrieve(loader.loadClass(name));
			mihs.add(mih);
		}
		return mihs;
	}
	
	/**
	 * 编译类文件
	 * @param modelPackage
	 * @param modelsPath
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException 
	 */
	public void complieModels(String modelPackage, String modelsPath) throws IOException {
		System.out.println("modelPackage:" + modelPackage);
		System.out.println("modelsPath:" + modelsPath);
		File modelsDir = new File(modelsPath);
		String[] modelClassNames = modelsDir.list(new MyFilenameFilter());
		File[] files = new File[modelClassNames.length];
		for (int i = 0; i < modelClassNames.length; i++) {
			files[i] = new File(modelsPath, modelClassNames[i]);
			System.out.println("javaSrcFiles:" + files[i].getAbsolutePath());
		}
		ClassUtils.compileTheJavaSrcFile(files);
	}
	
	/**
	 * 删除编译生成的文件
	 * @param absolutePath
	 * @param classNames
	 */
	public void deleteClassFile(String modelsPath, String[] classNames) {
		File[] files = new File[classNames.length];
		for (int i = 0; i < files.length; i++) {
			files[i] = new File(modelsPath + classNames[i].replace(".", File.separator) + ".class");
		}
		ClassUtils.deleteFiles(files);
	}
	
	/**
	 * 读取类名
	 * 
	 * @param modelPackage
	 * @param modelsPath
	 * @return modelClassNames
	 * @throws ClassNotFoundException
	 */
	public String[] readModelNames(String modelPackage, String modelsPath) throws ClassNotFoundException {
		File modelsDir = new File(modelsPath);
		String[] modelClassNames = modelsDir.list(new MyFilenameFilter());
		if (modelClassNames == null) {
			throw new ClassNotFoundException("path=" + modelsPath + " have no model class. please confirm path.");
		}
		for (int i = 0; i < modelClassNames.length; i++) {
			modelClassNames[i] = modelPackage + "." + modelClassNames[i].replace(".java", "");
		}
		return modelClassNames;
	}

	/**
	 * 过滤只要Java文件
	 * 
	 * @author redbird
	 *
	 */
	private class MyFilenameFilter implements FilenameFilter {
		@Override
		public boolean accept(File dir, String name) {
			if (name.endsWith(".java")) {
				return true;
			} else {
				return false;
			}
		}
	}
}
