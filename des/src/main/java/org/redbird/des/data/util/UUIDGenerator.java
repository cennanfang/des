package org.redbird.des.data.util;

import java.util.UUID;

/**
 * 用于生成UUID，唯一识别码
 * 
 * @author Administrator
 * @date 2015年11月14日
 * @filename UUIDGenerator.java
 */
public class UUIDGenerator {

	/**
	 * 使用java本身自带的工具生成
	 * 
	 * @return uuid
	 */
	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		// 去掉"-"符号
		String temp = str.substring(0, 8) + str.substring(9, 13)
				+ str.substring(14, 18) + str.substring(19, 23)
				+ str.substring(24);
		return /*str + "," +*/ temp;
	}

	/**
	 * 获得指定个数的uuid数组
	 * 
	 * @param number
	 * @return 指定个数的uuid数组
	 */
	public static String[] getUUID(int number) {
		if (number < 1) {
			return null;
		}
		String[] ss = new String[number];
		for (int i = 0; i < number; i++) {
			ss[i] = getUUID();
		}
		return ss;
	}

	public static void test(String[] args) {
		String[] ss = getUUID(10);
		for (int i = 0; i < ss.length; i++) {
			System.out.println("ss[" + i + "]=="+ ss[i].length() +"===" + ss[i]);
		}
	}

}
