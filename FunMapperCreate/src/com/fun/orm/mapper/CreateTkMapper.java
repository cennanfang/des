package com.fun.orm.mapper;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.fun.orm.retrieve.ModelInfoHolder;
import com.fun.orm.utils.Constants;
import com.fun.orm.utils.IOUtils;
import com.fun.orm.utils.XmlUtils;

public class CreateTkMapper {

	public void createMapper(ModelInfoHolder mih , String classPath, String mapperPackage) throws IOException {
		String className = mih.getClassName();
		String modelName = className.substring(className.lastIndexOf(".") + 1);
		
		StringBuffer sb = new StringBuffer();
		sb.append("package " + mapperPackage + ";\r\n\r\n");
		sb.append("import tk.mybatis.mapper.common.Mapper;\r\n");
		sb.append("import " + className + "; \r\n");
		// 注释部分
		sb.append("/**\r\n");
		sb.append("* " + modelName + Constants.MAPPER_NAME_SPACE_SUFFIX + " 类\r\n");
		sb.append("* " + new Date() + "\r\n");
		sb.append("*/ \r\n");
		sb.append("public interface " + modelName + Constants.MAPPER_NAME_SPACE_SUFFIX);
		sb.append(" extends Mapper<" + modelName);
		sb.append("> {\r\n");
		sb.append("}\r\n");
		/**
		 * 
		 */
		String writePath = classPath + IOUtils.packageToPath(mapperPackage);
		File mapperDir = new File(writePath);
		if(!mapperDir.exists()) {
			mapperDir.mkdirs();
		}
		File mapperFile = new File(mapperDir, modelName + Constants.MAPPER_NAME_SPACE_SUFFIX + ".java");
		IOUtils.writeModelToFile(sb.toString(), mapperFile);
	}
}
