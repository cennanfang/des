package com.redbird.wehelp.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DataUtils {
	/**
	 * 数据处理工具
	 * @param bytes[]
	 * @return String
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
	
	/**
	 * 将String类型的时间转换为Timestamp
	 * 精确到3位毫秒:yyyy-MM-dd HH:mm:ss.SSS
	 * @param time
	 * @return Timestamp 实例
	 * @throws ParseException
	 */
	synchronized public static Timestamp stringToTimesamp(String time) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		return new Timestamp(sdf.parse(time).getTime());
	}
}
