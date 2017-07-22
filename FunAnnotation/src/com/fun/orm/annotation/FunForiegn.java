package com.fun.orm.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 外键注解
 * @author a
 *
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FunForiegn {

	/**
	 * 外键引用的表名
	 * @return
	 */
	String referencedTable();
	
	/**
	 * 被引用表的字段
	 * @return
	 */
	String referencedColumn();
	
}
