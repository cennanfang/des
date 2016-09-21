package com.redbird.wehelp.util;

import java.util.UUID;

/**
 * GUID 主键生成
 * 
 * @author c
 *
 */
public final class GUID {
	
	/**
	 * 生成唯一ＩＤ
	 * @return 通过生成的ID
	 */
	public static String generate(){
		// 创建 GUID 对象
		UUID uuid = UUID.randomUUID();
		// 得到对象产生的ID
		String id = uuid.toString();
		// 转换为大写
		id = id.toUpperCase();
		// 替换 -
		id = id.replaceAll("-", "");
		return id;
	}
}
