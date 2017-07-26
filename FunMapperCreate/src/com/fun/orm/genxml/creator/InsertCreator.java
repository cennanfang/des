package com.fun.orm.genxml.creator;

import java.util.List;

import com.fun.orm.retrieve.ModelInfoHolder;
import com.fun.orm.retrieve.bean.ModelProperty;
import com.fun.orm.retrieve.bean.PrimayProperty;
import com.fun.orm.retrieve.bean.ReferencedProperty;
import com.fun.orm.utils.Constants;
import com.fun.orm.utils.NameUtils;

public class InsertCreator implements MethodCreator {

	@Override
	public void create(StringBuffer sb, ModelInfoHolder mih) {
		sb.append(createInsert(mih));
		sb.append(createInsertBatch(mih));
	}

	/**
	 * 创造insert 方法
	 * @param mih
	 * @return
	 */
	private String createInsert(ModelInfoHolder mih) {
		StringBuffer sb = new StringBuffer();
		sb.append("\t<insert id=\"");
		sb.append(Constants.SQLID_INSERT + "\" parameterType=\"");
		sb.append(mih.getClassName());
		sb.append("\">\r\n");
		sb.append("\t\tinsert into ");
		sb.append(mih.getTableName());
		sb.append(getColumList(mih.getPropertyList()));
		sb.append(" values");
		sb.append(getValuseList(mih.getPropertyList(), ""));
		sb.append("\r\n");
		sb.append("\t</insert>\r\n\r\n");
		return sb.toString();
	}
	
	/**
	 * 创建insertBatch方法
	 * @param mih
	 * @return
	 */
	private String createInsertBatch(ModelInfoHolder mih) {
		StringBuffer sb = new StringBuffer();
		sb.append("\t<insert id=\"");
		sb.append(Constants.SQLID_INSERT_BATCH + "\" parameterType=\"java.util.List\">\r\n");
		sb.append("\t\tinsert into ");
		sb.append(mih.getTableName());
		sb.append(getColumList(mih.getPropertyList()));
		sb.append(" values\r\n");
		sb.append("\t\t<foreach item=\"item\" collection=\"list\" separator=\", \">\r\n");
		sb.append("\t\t\t");
		sb.append(getValuseList(mih.getPropertyList(), "item."));
		sb.append("\r\n\t\t</foreach>\r\n");
		sb.append("\t</insert>\r\n\r\n");
		return sb.toString();
	}
	
	/**
	 * 获取数据库字段列表
	 * @param mps
	 * @return
	 */
	private String getColumList(List<ModelProperty> mps) {
		StringBuffer sb = new StringBuffer();
		for (ModelProperty mp : mps) {
			if(mp instanceof PrimayProperty) {
				continue;
			}
			sb.append(mp.getTableColumn());
			sb.append(", ");
		}
		String sql = sb.toString();
		return "(" + sql.substring(0, sql.length() - 2) + ")";
	}
	
	/**
	 * 获取属性段列表
	 * @param mps
	 * @return
	 */
	private String getValuseList(List<ModelProperty> mps, String itemPrefix) {
		StringBuffer sb = new StringBuffer();
		for (ModelProperty mp : mps) {
			if(mp instanceof PrimayProperty) {
				continue;
			}
			String property = mp.getModelProperty();
			if(mp instanceof ReferencedProperty) {
				ReferencedProperty rp = (ReferencedProperty) mp;
				property = NameUtils.getLowerCaseClassName(rp.getJavaType()) + "." 
						 + NameUtils.underline2Camel(rp.getReferencedColumn(), true);
			}
			sb.append("#{");
			sb.append(itemPrefix + property);
			sb.append("}");
			sb.append(", ");
		}
		String sql = sb.toString();
		return "(" + sql.substring(0, sql.length() - 2) + ")";
	}
}
