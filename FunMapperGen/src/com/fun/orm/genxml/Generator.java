package com.fun.orm.genxml;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.fun.orm.mapper.CreateMappers;
import com.fun.orm.retrieve.ModelInfoHolder;
import com.fun.orm.utils.Constants;
import com.fun.orm.utils.IOUtils;

public class Generator {
	private Logger logger  =  Logger.getLogger(Generator.class);
	private String modelPackage = "com.cen.signal.model";
	private String mapperNameSpace = "com.cen.signal.mapper";

	public void generate(String classPath) throws ClassNotFoundException, IOException {
		String modelsPath = classPath + IOUtils.packageToPath(modelPackage);
		logger.info("modelsPath="+ modelsPath);
		ModelsReader mr = new ModelsReader(modelPackage, modelsPath);
		List<ModelInfoHolder> mihs = mr.excute();
		String writeXmlPath = Constants.PROJECT_RESOUCES_PATH + "mybatis_mapper";
		XMLsGenerate mxg = new XMLsGenerate(mapperNameSpace);
		mxg.generate(mihs, writeXmlPath);
		CreateMappers cm = new CreateMappers();
		cm.create(mihs, classPath, mapperNameSpace);
	}
	
	public static void main(String[] args) {
		try {
			new Generator().generate(Constants.PROJECT_JAVA_PATH);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
}
