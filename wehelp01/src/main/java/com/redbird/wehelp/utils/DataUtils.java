package com.redbird.wehelp.utils;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	/**
	 * 将对象转换为json串
	 * @param o
	 * @return
	 * @throws ParseException
	 * @throws JsonProcessingException
	 */
	synchronized public static String pojoToJson(Object pojo) throws ParseException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(pojo);
		return json;
	}
	
	/**
	 * 将对象转换为json串
	 * @param <T>
	 * @param o
	 * @return T
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	synchronized public static <T> T jsonToPojo(String json, Class<T> c) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper objectMapper = new ObjectMapper();
		T pojo = objectMapper.readValue(json, c);
		return pojo;
	}
}
