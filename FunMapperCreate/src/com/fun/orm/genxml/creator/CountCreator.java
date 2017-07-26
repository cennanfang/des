package com.fun.orm.genxml.creator;

import com.fun.orm.retrieve.ModelInfoHolder;
import com.fun.orm.utils.Constants;
import com.fun.orm.utils.XmlUtils;

public class CountCreator implements MethodCreator {

	@Override
	public void create(StringBuffer sb, ModelInfoHolder mih) {
		sb.append(createCount(mih));
		sb.append(createCountParam(mih));
	}
	
	private String createCount(ModelInfoHolder mih) {
		StringBuffer sb = new StringBuffer();
		sb.append("\t<select id=\"");
		sb.append(Constants.SQLID_COUNT);
		sb.append("\" resultType=\"int\">\r\n");
		sb.append("\t\tselect count(*) from ");
		sb.append(mih.getTableName());
		sb.append("\r\n\t</select>\r\n\r\n");
		return sb.toString();
	}
	
	private String createCountParam(ModelInfoHolder mih) {
		StringBuffer sb = new StringBuffer();
		sb.append("\t<select id=\"");
		sb.append(Constants.SQLID_COUNT_PARAM);
		sb.append("\" parameterType=\"java.util.Map\" resultType=\"int\">\r\n");
		sb.append("\t\tselect count(*) from ");
		sb.append(mih.getTableName());
		sb.append("\r\n\t\t<where>\r\n");
		sb.append(XmlUtils.getConditions(mih.getPropertyList()));
		sb.append("\t\t</where>\r\n");
		sb.append("\t</select>\r\n\r\n");
		return sb.toString();
	}

}
