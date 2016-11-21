package com.redbird.wehelp.utils;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redbird.wehelp.pojo.Message;
import com.redbird.wehelp.pojo.MessagesModel;

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
	 * @return 
	 * @return 
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	synchronized public static <T> T jsonToPojo(String json, Class<T> c) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper objectMapper = new ObjectMapper();
		T pojo = objectMapper.readValue(json, c);
		return pojo;
		
	}
	
	public static void main(String[] args) {
		Message m = new Message();
		m.setId(1);
		m.setContacts("00090192");
		m.setContent("从贵阳的必经");
		m.setCreateDate(new Timestamp(new Date().getTime()));
		m.setPublishedDate(new Timestamp(new Date().getTime()));
		m.setMessageTypeId(1);
		m.setUserId(1);
		Message m2 = new Message();
		m2.setId(2);
		m2.setContacts("asdfasdfa");
		m2.setContent("纽约到伦敦");
		m2.setCreateDate(new Timestamp(new Date().getTime()));
		m2.setPublishedDate(new Timestamp(new Date().getTime()));
		m2.setMessageTypeId(2);
		m2.setUserId(2);
		List<Message> ms = new ArrayList<Message>();
		ms.add(m);
		ms.add(m2);
		MessagesModel mm = new MessagesModel();
		mm.setMarkPublishedDate(new Timestamp(new Date().getTime()));
		mm.setMessages(ms);
		mm.setMesgsTotal(2);
		
		try {
			String json = DataUtils.pojoToJson(mm);
			System.out.println(json);
			
			MessagesModel msgM = DataUtils.jsonToPojo(json, MessagesModel.class);
			System.out.println(msgM);
		} catch (ParseException | IOException e) {
			e.printStackTrace();
		}
	}
}
