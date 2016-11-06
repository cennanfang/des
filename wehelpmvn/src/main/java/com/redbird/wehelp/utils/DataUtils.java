package com.redbird.wehelp.utils;

public class DataUtils {
	/**
	 * 数据处理工具
	 * @param bytes
	 * @return
	 */
	synchronized public static String byteArrayToString(byte[] bytes) {
		String str = "";
		if(bytes != null) {
			for (byte b : bytes) {
				char c = (char)b;
				str += c;
			}
		}
		return str;
	}
}
