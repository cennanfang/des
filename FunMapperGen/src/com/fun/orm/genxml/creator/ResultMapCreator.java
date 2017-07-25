package com.fun.orm.genxml.creator;

import java.util.List;

import com.fun.orm.retrieve.ModelInfoHolder;
import com.fun.orm.retrieve.bean.ModelProperty;
import com.fun.orm.utils.XmlUtils;
import com.fun.orm.utils.NameUtils;

public class ResultMapCreator implements MethodCreator {
	
	private String nameSpacePackage;
	
	public ResultMapCreator(String nameSpacePackage) {
		this.nameSpacePackage = nameSpacePackage;
	}

	@Override
	public void create(StringBuffer sb, ModelInfoHolder mih) {
		List<ModelProperty> mps = mih.getPropertyList();
		// 头
		String className = mih.getClassName();
		sb.append("\t<!-- 结果集 -->");
		sb.append("\r\n");
		sb.append("\t<resultMap id=\"");
		sb.append(NameUtils.getLowerCaseClassName(NameUtils.getShortClassName(className)));
		sb.append("Result\" type=\"");
		sb.append(className);
		sb.append("\">\r\n");
		// 内容
		sb.append(XmlUtils.addRsultMapId(mps));
		sb.append(XmlUtils.addRsultMapResult(mps));
		sb.append(XmlUtils.addRsultMapAssociation(mps));
		// 尾
		sb.append("\t</resultMap>\r\n\r\n");
		// 引用表的查询
		sb.append(XmlUtils.createRefenerSelect(mps, nameSpacePackage));
	}
}
