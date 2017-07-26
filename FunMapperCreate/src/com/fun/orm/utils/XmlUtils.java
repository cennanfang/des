package com.fun.orm.utils;

import java.util.List;

import com.fun.orm.retrieve.bean.CommonProperty;
import com.fun.orm.retrieve.bean.ModelProperty;
import com.fun.orm.retrieve.bean.PrimayProperty;
import com.fun.orm.retrieve.bean.ReferencedProperty;

public class XmlUtils {
	
	/**
	 * 添加主键
	 * @param sb
	 * @param mps
	 */
	public static String addRsultMapId(List<ModelProperty> mps) {
		StringBuffer sb = new StringBuffer();
		for (ModelProperty mp : mps) {
			if(mp instanceof PrimayProperty) {
				sb.append("\t\t<id property=\"");
				sb.append(mp.getModelProperty());
				sb.append("\" column=\"");
				sb.append(mp.getTableColumn());
				sb.append("\" />\r\n");
				break;
			}
		}
		return sb.toString();
	}
	
	/**
	 * 添加普通字段
	 * @param mps
	 * @return
	 */
	public static String addRsultMapResult(List<ModelProperty> mps) {
		StringBuffer sb = new StringBuffer();
		for (ModelProperty mp : mps) {
			if(mp instanceof CommonProperty) {
				sb.append("\t\t<result property=\"");
				sb.append(mp.getModelProperty());
				sb.append("\" column=\"");
				sb.append(mp.getTableColumn());
				sb.append("\" />\r\n");
			}
		}
		return sb.toString();
	}
	
	
	/**
	 * 添加外键
	 * @param sb
	 * @param mps
	 */
	public static String addRsultMapAssociation(List<ModelProperty> mps) {
		StringBuffer sb = new StringBuffer();
		for (ModelProperty mp : mps) {
			if(mp instanceof ReferencedProperty) {
				sb.append("\t\t<association property=\"");
				sb.append(mp.getModelProperty());
				sb.append("\" column=\"");
				sb.append(mp.getTableColumn());
				sb.append("\"");
				sb.append(" javaType=\"");
				sb.append(mp.getPackageJavaType());
				sb.append("\"");
				sb.append(" select=\"select");
				sb.append(mp.getJavaType());
				sb.append("\"");
				sb.append("/>\r\n");
			}
		}
		return sb.toString();
	}
	
	public static String createRefenerSelect(List<ModelProperty> mps, String nameSpacePackage) {
		StringBuffer sb = new StringBuffer();
		for (ModelProperty mp : mps) {
			if(mp instanceof ReferencedProperty) {
				ReferencedProperty rp = (ReferencedProperty) mp;
				String javaType = rp.getJavaType();
				sb.append("\t<select id=\"select");
				sb.append(javaType);
				sb.append("\"");
				sb.append(" resultMap=\"");
				sb.append(nameSpacePackage + "." + javaType + Constants.MAPPER_NAME_SPACE_SUFFIX);
				sb.append("." + NameUtils.getLowerCaseClassName(javaType));
				sb.append("Result\">\r\n");
				sb.append("\t\tselect * from " + rp.getReferencedTable() + " where " + rp.getReferencedColumn() + "=#{id}\r\n");
				sb.append("\t</select>\r\n\r\n");
			}
		}
		return sb.toString();
	}
	
	/**
	 * 获取主键信息
	 * @param mps
	 * @return
	 */
	public static PrimayProperty getPrimaryProperty(List<ModelProperty> mps) {
		for (ModelProperty mp : mps) {
			if(mp instanceof PrimayProperty) {
				return (PrimayProperty)mp;
			}
		}
		return null;
	}
	
	/**
	 * 参数型动态代码复用
	 * @param mps
	 * @return
	 */
	public static String addParamWhereConditions(List<ModelProperty> mps) {
		StringBuffer sb = new StringBuffer();
		sb.append("\t<sql id=\"paramWhereCondition\">\r\n");
		sb.append("\t\t<trim prefixOverrides=\"and\">\r\n");
		sb.append("\t\t<where>\t\n");
		sb.append(XmlUtils.getConditions(mps));
		sb.append(XmlUtils.addBetweenWith());
		sb.append("\t\t</where>\r\n");
		sb.append("\t\t</trim>\r\n");
		sb.append("\t</sql>\r\n\r\n");
		return sb.toString();
	}
	
	/**
	 * 条件查询
	 * @param mps
	 * @return
	 */
	public static String getConditions(List<ModelProperty> mps) {
		StringBuffer sb = new StringBuffer();
		sb.append("\t\t\t<choose>\r\n");
		sb.append("\t\t\t<when test=\"");
		sb.append(Constants.SQLID_STRING_USE_LIKE);
		sb.append(" != null and ");
		sb.append(Constants.SQLID_STRING_USE_LIKE);
		sb.append(" == 1");
		sb.append("\">\r\n");
		sb.append(getLikeConditions(mps));
		sb.append("\t\t\t</when>\r\n");
		sb.append("\t\t\t<otherwise>\r\n");
		sb.append(getEqualConditions(mps));
		sb.append("\t\t\t</otherwise>\r\n");
		sb.append("\t\t\t</choose>\r\n");
		return sb.toString();
	}
	
	/**
	 * 获得判断条件 模糊查询
	 */
	public static String getLikeConditions(List<ModelProperty> mps) {
		StringBuffer sb = new StringBuffer();
		for (ModelProperty mp : mps) {
			String property = mp.getModelProperty();
			String propertyType = mp.getJavaType();
			String colName = mp.getTableColumn();
			sb.append("\t\t\t\t<if test=\"");
			if(mp instanceof ReferencedProperty) {
				ReferencedProperty rp = (ReferencedProperty) mp;
				String refName = NameUtils.getLowerCaseClassName(rp.getJavaType());
				sb.append(refName);
				sb.append(" != null and ");
				property = refName + "." + NameUtils.underline2Camel(rp.getReferencedColumn(), true);
			}
			sb.append(property);
			sb.append(" != null\">");
			sb.append("and ");
			sb.append(colName);
			if("String".equals(propertyType)) {
				sb.append(" like ");
			} else {
				sb.append("=");
			}
			sb.append("#{");
			sb.append(property);
			sb.append("}</if>\r\n");
		}
		return sb.toString();
	}
	
	/**
	 * 获得判断条件
	 */
	public static String getEqualConditions(List<ModelProperty> mps) {
		StringBuffer sb = new StringBuffer();
		for (ModelProperty mp : mps) {
			String property = mp.getModelProperty();
			String colName = mp.getTableColumn();
			sb.append("\t\t\t\t<if test=\"");
			if(mp instanceof ReferencedProperty) {
				ReferencedProperty rp = (ReferencedProperty) mp;
				String refName = NameUtils.getLowerCaseClassName(rp.getJavaType());
				sb.append(refName);
				sb.append(" != null and ");
				property = refName + "." + NameUtils.underline2Camel(rp.getReferencedColumn(), true);
			}
			sb.append(property);
			sb.append(" != null\">");
			sb.append("and ");
			sb.append(colName);
			sb.append("=#{");
			sb.append(property);
			sb.append("}</if>\r\n");
		}
		return sb.toString();
	}
	
	/**
	 * 加入排序判断
	 * @return
	 */
	public static String addOrderBy() {
		StringBuffer sb = new StringBuffer();
		sb.append("\t\t<if test=\"orderColumn != null\">\r\n ");
		sb.append("\t\t\torder by ${orderColumn}\r\n ");
		sb.append("\t\t\t<if test=\"orderTurn != null\">\r\n ");
		sb.append("\t\t\t\t${orderTurn}\r\n ");
		sb.append("\t\t\t</if>\r\n ");
		sb.append("\t\t</if>\r\n ");
		return sb.toString();
	}
	
	/**
	 * 加入段判断
	 * @return
	 */
	public static String addBetweenWith() {
		StringBuffer sb = new StringBuffer();
		sb.append("\t\t\t<if test=\"betweenAndColumn != null\">\r\n ");
		sb.append("\t\t\t\t and ${betweenAndColumn} between ${betweenStart} and ${betweenEnd}\r\n ");
		sb.append("\t\t\t</if>\r\n ");
		return sb.toString();
	}
	
	/**
	 * 插入数据条件判断复用
	 * @param mps
	 * @return
	 */
	public static String addUpdateSetCondition(List<ModelProperty> mps) {
		StringBuffer sb = new StringBuffer();
		sb.append("\t<sql id=\"updateSetCondition\">\r\n");
		sb.append(getSetAndCondition(mps));
		sb.append("\t</sql>\r\n\r\n");
		return sb.toString();
	}
	
	/**
	 * 获取set和where
	 * @param mps
	 * @return
	 */
	public static String getSetAndCondition(List<ModelProperty> mps) {
		StringBuffer sb = new StringBuffer();
		String idCondition = null;
		sb.append("\t\t<trim suffixOverrides=\",\">\r\n");
		sb.append("\t\t<set>\r\n");
		for(ModelProperty mp : mps) {
			if(mp instanceof PrimayProperty) {
				PrimayProperty pp = (PrimayProperty)mp;
				idCondition = pp.getTableColumn() + "=#{" + pp.getModelProperty() + "}";
				continue;
			}
			String property = mp.getModelProperty();
			String colName = mp.getTableColumn();
			sb.append("\t\t\t<if test=\"");
			if(mp instanceof ReferencedProperty) {
				ReferencedProperty rp = (ReferencedProperty)mp;
				String refName = NameUtils.getLowerCaseClassName(rp.getJavaType());
				property = refName  + "." + NameUtils.underline2Camel(rp.getReferencedColumn(), true);
				sb.append(refName);
				sb.append(" != null and ");
			}
			sb.append(property);
			sb.append(" != null\">");
			sb.append(colName);
			sb.append("=#{");
			sb.append(property);
			sb.append("},</if>\r\n");
		}
		sb.append("\t\t</set>\r\n");
		sb.append("\t\t</trim>\r\n");
		sb.append("\t\twhere ");
		sb.append(idCondition);
		sb.append("\r\n");
		return sb.toString();
	}
}
