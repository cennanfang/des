package com.fun.orm.genxml.creator;

import com.fun.orm.retrieve.ModelInfoHolder;
import com.fun.orm.retrieve.bean.PrimayProperty;
import com.fun.orm.utils.Constants;
import com.fun.orm.utils.NameUtils;
import com.fun.orm.utils.XmlUtils;

public class SelectCreator implements MethodCreator {

	@Override
	public void create(StringBuffer sb, ModelInfoHolder mih) {
		// 添加select方法
		sb.append(createSelect(mih));
		sb.append(createSelectParam(mih));
	}
	
	/**
	 * 主键查询
	 * @param mih
	 * @return
	 */
	private String createSelect(ModelInfoHolder mih) {
		PrimayProperty pp = XmlUtils.getPrimaryProperty(mih.getPropertyList());
		StringBuffer sb = new StringBuffer();
		sb.append("\t<select id=\"");
		sb.append(Constants.SQLID_SELECT + "\" parameterType=\"");
		sb.append(pp.getJavaType());
		sb.append("\" resultMap=\"");
		sb.append(NameUtils.getLowerCaseClassName(NameUtils.getShortClassName(mih.getClassName())));
		sb.append("Result\">\r\n");
		sb.append("\t\tselect * from ");
		sb.append(mih.getTableName());
		sb.append(" where ");
		sb.append(pp.getTableColumn());
		sb.append("=#{");
		sb.append(pp.getModelProperty());
		sb.append("}\r\n");
		sb.append("\t</select>\r\n\r\n ");
		return sb.toString();
	}
	
	/**
	 * 创建selectParam方法
	 * @param mih
	 * @return
	 */
	private String createSelectParam(ModelInfoHolder mih) {
		StringBuffer sb = new StringBuffer();
		sb.append("\t<select id=\"");
		sb.append(Constants.SQLID_SELECT_PARAM + "\" parameterType=\"java.util.Map\" resultType=\"");
		sb.append(mih.getClassName());
		sb.append("\">\r\n");
		sb.append("\t\tselect * from ");
		sb.append(mih.getTableName());
		sb.append("\r\n\t\t<trim prefixOverrides=\"and\">");
		sb.append("\r\n\t\t<where>\t\n");
		sb.append(XmlUtils.getConditions(mih.getPropertyList()));
		sb.append(XmlUtils.addBetweenWith());
		sb.append("\t\t</where>\r\n");
		sb.append("\t\t</trim>\r\n");
		sb.append(XmlUtils.addOrderBy());
		sb.append("\t</select> \r\n\r\n");
		return sb.toString();
	}
}
