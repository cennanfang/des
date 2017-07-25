package com.fun.orm.genxml;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.fun.orm.retrieve.ModelInfoHolder;
import com.fun.orm.retrieve.RetrieveModel;

public class ModelsReader {
	private Logger logger  =  Logger.getLogger(ModelsReader.class);

	private String modelPackage;
	
	private String modelsPath;
	
	/**
	 * 需要传入实体类的包名和绝对路径
	 * @param modelPackage 包名
	 * @param modelsPath   所在的路径
	 */
	public ModelsReader(String modelPackage, String modelsPath) {
		this.modelPackage = modelPackage;
		this.modelsPath = modelsPath;
	}

	/**
	 * 获取说有实体类的结构
	 * @return
	 * @throws ClassNotFoundException
	 */
	public List<ModelInfoHolder> excute() throws ClassNotFoundException {
		String[] modelClassNames = readModelNames(modelPackage, modelsPath);
		List<ModelInfoHolder> mihs = analysisModels(modelClassNames);
		return mihs;
	}
	
	/**
	 * 分析所有实体类
	 * @param modelClassNames
	 * @throws ClassNotFoundException
	 */
	public List<ModelInfoHolder> analysisModels(String[] modelClassNames) throws ClassNotFoundException {
		RetrieveModel retrieveModel = new RetrieveModel();
		List<ModelInfoHolder> mihs = new ArrayList<>();
		for(String name : modelClassNames) {
			ModelInfoHolder mih = retrieveModel.retrieve(Class.forName(name));
			mihs.add(mih);
		}
		return mihs;
	}
	
	/**
	 * 读取类名
	 * @param modelPackage
	 * @param modelsPath
	 * @return modelClassNames
	 */
	public String[] readModelNames(String modelPackage, String modelsPath){
		File modelsDir = new File(modelsPath);
		String[] modelClassNames = modelsDir.list(new MyFilenameFilter());
		if(modelClassNames == null) {
			throw new RuntimeException("path=" + modelsPath + " have no model class. please confirm path.");
		}
		for(int i = 0; i < modelClassNames.length; i++) {
			modelClassNames[i] = modelPackage + "." + modelClassNames[i].replace(".java", "");
			logger.info("read model : " + modelClassNames[i]);
		}
		return modelClassNames;
	}
	
	/**
	 * 过滤只要Java文件
	 * @author redbird
	 *
	 */
	private class MyFilenameFilter implements FilenameFilter{
		@Override
		public boolean accept(File dir, String name) {
			if(name.endsWith(".java")) {
				return true;
			} else {
				return false;
			}
		}
	}
	
}
