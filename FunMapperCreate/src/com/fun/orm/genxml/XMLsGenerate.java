package com.fun.orm.genxml;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fun.orm.genxml.creator.XMLCreator;
import com.fun.orm.retrieve.ModelInfoHolder;
import com.fun.orm.utils.IOUtils;
import com.fun.orm.utils.NameUtils;

public class XMLsGenerate {
	/**
	 * xml文件命名空间
	 */
	private String mapperNameSpace;

	public XMLsGenerate(String mapperNameSpace) {
		this.mapperNameSpace = mapperNameSpace;
	}
	
	/**
	 * 生成所有实体类的Mapper xml 文件，并写到writeXmlPath目录
	 * @param mihs
	 * @param writeXmlPath
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public void generate(List<ModelInfoHolder> mihs, String writeXmlPath) throws ClassNotFoundException, IOException {
		File writeDir = new File(writeXmlPath);
		if(!writeDir.exists()) {
			writeDir.mkdirs();
		}
		for(ModelInfoHolder mih : mihs) {
			String xml = new XMLCreator().create(mih, mapperNameSpace);
			String xmlFileName = NameUtils.getShortClassName(mih.getClassName()) + "FunMapper.xml";
			IOUtils.writeModelToFile(xml, new File(writeDir, xmlFileName));
		}
	}
	
}
