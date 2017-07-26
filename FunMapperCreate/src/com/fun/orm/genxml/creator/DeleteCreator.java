package com.fun.orm.genxml.creator;

import com.fun.orm.retrieve.ModelInfoHolder;
import com.fun.orm.retrieve.bean.PrimayProperty;
import com.fun.orm.utils.Constants;
import com.fun.orm.utils.XmlUtils;

public class DeleteCreator implements MethodCreator {

	@Override
	public void create(StringBuffer sb, ModelInfoHolder mih) {
		sb.append(createDelete(mih));
		sb.append(createDeleteParam(mih));
		sb.append(createDeleteBatch(mih));
	}
	
	/**
	 * 创建删除方法
	 * @param mih
	 * @return
	 */
	private String createDelete(ModelInfoHolder mih) {
		StringBuffer sb = new StringBuffer();
		PrimayProperty pp = XmlUtils.getPrimaryProperty(mih.getPropertyList());
		sb.append("\t<delete id=\"");
		sb.append(Constants.SQLID_DELETE + "\" parameterType=\"");
		sb.append(pp.getJavaType());
		sb.append("\">\r\n");
		sb.append("\t\tdelete from ");
		sb.append(mih.getTableName());
		sb.append(" where ");
		sb.append(pp.getTableColumn());
		sb.append("=#{");
		sb.append(pp.getModelProperty());
		sb.append("}\r\n");
		sb.append("\t</delete>\r\n\r\n");
		return sb.toString();
	}
	
	/**
	 * 
	 * @param mih
	 * @return
	 */
	private String createDeleteParam(ModelInfoHolder mih) {
		StringBuffer sb = new StringBuffer();
		sb.append("\t<delete id=\"");
		sb.append(Constants.SQLID_DELETE_PARAM + "\" parameterType=\"java.util.Map\">\r\n");
		sb.append("\t\tdelete from ");
		sb.append(mih.getTableName());
		sb.append("\r\n\t\t<include refid=\"paramWhereCondition\"/>\r\n");
		sb.append("\t</delete>\r\n\r\n");
		return sb.toString();
	}

	/**
	 * 
	 * @param mih
	 * @return
	 */
	private String createDeleteBatch(ModelInfoHolder mih) {
		PrimayProperty pp = XmlUtils.getPrimaryProperty(mih.getPropertyList());
		StringBuffer sb = new StringBuffer();
		sb.append("\t<delete id=\"");
		sb.append(Constants.SQLID_DELETE_BATCH + "\" parameterType=\"java.util.List\">\r\n");
		sb.append("\t\tdelete from ");
		sb.append(mih.getTableName());
		sb.append(" where ");
		sb.append(pp.getTableColumn());
		sb.append(" in \r\n");
		sb.append("\t\t<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">\r\n");
		sb.append("\t\t\t<foreach collection=\"list\" item=\"pk\" separator=\",\"> \r\n");
		sb.append(" \t\t\t\t#{pk}\r\n");
		sb.append("\t\t\t</foreach>\r\n");
		sb.append("\t\t</trim>\r\n");
		sb.append("\t</delete>\r\n\r\n");
		return sb.toString();
	}
}
