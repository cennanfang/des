package com.fun.orm.retrieve;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.fun.orm.annotation.FunColumn;
import com.fun.orm.annotation.FunForiegn;
import com.fun.orm.annotation.FunPrimary;
import com.fun.orm.annotation.FunTable;
import com.fun.orm.retrieve.bean.CommonProperty;
import com.fun.orm.retrieve.bean.ModelProperty;
import com.fun.orm.retrieve.bean.PrimayProperty;
import com.fun.orm.retrieve.bean.ReferencedProperty;
import com.fun.orm.utils.NameUtils;

public class RetrieveModel {
	private Logger logger  =  Logger.getLogger(RetrieveModel.class);
	private ModelInfoHolder mih;

	/**
	 * 检索类的注解
	 * 
	 * @param clazz
	 * @return
	 */
	public ModelInfoHolder retrieve(Class<?> clazz) {
		mih = new ModelInfoHolder();
		/**
		 * 类注解检索
		 */
		checkClass(clazz);
		checkField(clazz);
		removeStaticField(clazz);
		return mih;
	}

	/**
	 * 读取字段
	 * 
	 * @param clazz
	 * @return
	 */
	private boolean checkField(Class<?> clazz) {
		if (clazz == Object.class) {
			return true;
		} else {
			checkField(clazz.getSuperclass());
		}
		List<Field> list = Arrays.asList(clazz.getDeclaredFields());
		for (int i = 0; i < list.size(); i++) {
			Field field = list.get(i);
			String javaType = field.getType().getSimpleName();
			String packageJavaType = field.getType().getName();
			String fieldKey = field.getName();
			String fieldValue = NameUtils.camel2Underline(fieldKey, true);
			/**
			 * 获得注解
			 */
			ModelProperty property = null;
			for (Annotation anno : field.getDeclaredAnnotations()) {// 获得所有的注解
				if (anno.annotationType().equals(FunColumn.class)) {// 找到Column的注解
					fieldValue = ((FunColumn) anno).value();
					break;
				}
			}
			for (Annotation anno : field.getDeclaredAnnotations()) {// 获得所有的注解
				if (anno.annotationType().equals(FunPrimary.class)) { //找到PrimaryKey的注解
					String pv = ((FunPrimary) anno).value();
					if(pv != null && !"".equals(pv)) {
						fieldValue = pv;
					}
					property = new PrimayProperty();
					break;
				}
			}
			for (Annotation anno : field.getDeclaredAnnotations()) {// 获得所有的注解
				if (anno.annotationType().equals(FunForiegn.class)) {// 找到ForeignKey注解
					ReferencedProperty rp = new ReferencedProperty();
					rp.setReferencedTable(((FunForiegn) anno).referencedTable());
					rp.setReferencedColumn(((FunForiegn) anno).referencedColumn());
					property = rp;
					break;
				}
			}
			if (property == null) {
				property = new CommonProperty();
			} 
			property.setModelProperty(fieldKey);
			property.setTableColumn(fieldValue);
			property.setJavaType(javaType);
			property.setPackageJavaType(packageJavaType);
			logger.debug("property : " + fieldKey + " column ： " + fieldValue + " java type : " + javaType);
			mih.getPropertyList().add(property);
		}
		return true;
	}

	/**
	 * 读取表名
	 * 
	 * @param clazz
	 * @return
	 */
	private boolean checkClass(Class<?> clazz) {
		String className = clazz.getName();
		logger.info("retrieve class : " + className);
		mih.setClassName(className);
		String tableName = className.substring(className.lastIndexOf(".") + 1);
		Annotation[] annotations = clazz.getAnnotations();
		for (Annotation annotation : annotations) {
			if (annotation instanceof FunTable) {
				FunTable tableNameConfig = (FunTable) annotation;
				tableName = tableNameConfig.value();
				break;
			}
		}
		mih.setTableName(tableName);
		return true;
	}

	/**
	 * 去除静态字段
	 * 
	 * @param clazz
	 * @return
	 */
	private boolean removeStaticField(Class<?> clazz) {
		List<Field> list = Arrays.asList(clazz.getFields());
		for (int i = 0; i < list.size(); i++) {
			Field field = list.get(i);
			String fieldKey = field.getName();
			ModelProperty mp = new ModelProperty();
			mp.setModelProperty(fieldKey);
			mih.getPropertyList().remove(mp);
			logger.debug ("reomve static filed : " + field);
		}
		return true;
	}
}
