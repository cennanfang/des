package com.fun.orm.genxml;

import java.io.IOException;
import java.util.List;

import com.fun.orm.mapper.CreateMappers;
import com.fun.orm.retrieve.ModelInfoHolder;

public class Generator {
	// 实体类所在绝对路径
	private String modelClassPath;
	// 生成xml文件绝对路径
	private String mybatisXmlPath;
	// 实体类 包名
	private String modelPackage;
	// mybatis xml命名空间包名
	private String mapperNameSpace;

	public Generator(String modelClassPath, String mybatisXmlPath, String modelPackage, String mapperNameSpace) {
		this.modelClassPath = modelClassPath;
		this.mybatisXmlPath = mybatisXmlPath;
		this.modelPackage = modelPackage;
		this.mapperNameSpace = mapperNameSpace;
	}

	public void generate() throws ClassNotFoundException, IOException {
		ModelsReader mr = new ModelsReader(modelPackage, modelClassPath);
		List<ModelInfoHolder> mihs = mr.excute();
		XMLsGenerate mxg = new XMLsGenerate(mapperNameSpace);
		mxg.generate(mihs, mybatisXmlPath);
		CreateMappers cm = new CreateMappers();
		cm.create(mihs, modelClassPath, mapperNameSpace);
	}
	
	public static void main(String[] args) {
		try {
			new Generator("D:/genmodel/", "D:/genmodel/mybatis_xml", "com.cen.signal.model", "com.cen.signal.mapper").generate();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
}
