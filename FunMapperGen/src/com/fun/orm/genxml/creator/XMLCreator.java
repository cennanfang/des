package com.fun.orm.genxml.creator;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.fun.orm.retrieve.ModelInfoHolder;
import com.fun.orm.utils.NameUtils;
import com.fun.orm.utils.XmlUtils;

public class XMLCreator {
	private Logger logger  =  Logger.getLogger(XMLCreator.class);
	private List<MethodCreator> createChain;
	
	public XMLCreator() {
		createChain = new ArrayList<MethodCreator>();
	}

	public String create(ModelInfoHolder mih, String nameSpacePackage) {
		logger.info("create mapper xml for " + mih.getClassName());
		createChain.add(new ResultMapCreator(nameSpacePackage));
		createChain.add(new SelectCreator());
		createChain.add(new InsertCreator());
		createChain.add(new UpdateCreator());
		createChain.add(new DeleteCreator());
		createChain.add(new CountCreator());
		StringBuffer sb = new StringBuffer();
		String nameSpace = nameSpacePackage + "." + NameUtils.getShortClassName(mih.getClassName()) + XmlUtils.MAPPER_NAME_SPACE_SUFFIX;
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
		sb.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\r\n");
		sb.append("<mapper namespace=\"");
		sb.append(nameSpace);
		sb.append("\">\r\n\r\n");
		for(MethodCreator mc : createChain) {
			mc.create(sb, mih);
		}
		sb.append("</mapper>");
		return sb.toString();
	}
	
}
