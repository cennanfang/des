package com.fun.orm.genxml.creator;

import com.fun.orm.retrieve.ModelInfoHolder;
import com.fun.orm.utils.Constants;
import com.fun.orm.utils.NameUtils;

public class UpdateCreator implements MethodCreator {

	@Override
	public void create(StringBuffer sb, ModelInfoHolder mih) {
		sb.append(createUpdate(mih));
		sb.append(createUpdateBatch(mih));
	}
	
	/**
	 * 创建update方法
	 * @param mih
	 * @return
	 */
	private String createUpdate(ModelInfoHolder mih) {
		StringBuffer sb = new StringBuffer();
		sb.append("\t<update id=\"");
		sb.append(Constants.SQLID_UPDATE + "\" parameterType=\"");
		sb.append(mih.getClassName());
		sb.append("\">\r\n");
		sb.append("\t\tupdate ");
		sb.append(mih.getTableName());
		sb.append("\r\n\t\t<include refid=\"updateSetCondition\"/>\r\n");
		sb.append("\t</update>\r\n\r\n");
		return sb.toString();
	}
	
	/**
	 * 创建updateBatch方法
	 * @param mih
	 * @return
	 */
	private String createUpdateBatch(ModelInfoHolder mih) {
		StringBuffer sb = new StringBuffer();
		sb.append("\t<update id=\"");
		sb.append(Constants.SQLID_UPDATE_BATCH + "\" parameterType=\"java.util.List\">\r\n");
		sb.append("\t\t<foreach collection=\"list\" item=\"");
		sb.append(NameUtils.getLowerCaseClassName(mih.getClassName()));
		sb.append("\" separator=\";\">\r\n");
		sb.append("\t\tupdate ");
		sb.append(mih.getTableName());
		sb.append("\r\n\t\t<include refid=\"updateSetCondition\"/>\r\n");
		sb.append("\t\t</foreach>\r\n");
		sb.append("\t</update>\r\n\r\n");
		return sb.toString();
	}
	
}
