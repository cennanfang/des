package com.redbird.wehelp.utils;

import java.util.List;

import com.redbird.wehelp.pojo.Message;

/**
 * 
 * @author cennanfang
 *
 */
public class MessagesModel {
	// 当前指针
	private int currentMesgsPoint;
	// 返回结果数据条数
	private int mesgsTotal;
	
	// 信息链表
	private List<Message> messages;
	
	@Override
	public String toString() {
		String str = "currentMsgPoint=" + currentMesgsPoint + "\r\nmessages: \r\n";
		for (Message message : messages) {
			str += (message + "\r\n");
		}
		return str;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public int getCurrentMesgsPoint() {
		return currentMesgsPoint;
	}

	public void setCurrentMesgsPoint(int currentMesgsPoint) {
		this.currentMesgsPoint = currentMesgsPoint;
	}

	public int getMesgsTotal() {
		return mesgsTotal;
	}

	public void setMesgsTotal(int mesgsTotal) {
		this.mesgsTotal = mesgsTotal;
	}
}
