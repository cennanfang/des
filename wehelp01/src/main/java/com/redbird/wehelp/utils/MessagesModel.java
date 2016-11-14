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
	private int currentMsgPoint;
	
	// 信息链表
	private List<Message> messages;

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public int getCurrentMsgPoint() {
		return currentMsgPoint;
	}

	public void setCurrentMsgPoint(int currentMsgPoint) {
		this.currentMsgPoint = currentMsgPoint;
	}
	
}
