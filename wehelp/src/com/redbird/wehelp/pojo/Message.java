package com.redbird.wehelp.pojo;

import java.util.Date;

/**
 * ��Ϣ
 * @author c
 *
 */
public class Message extends BasePojo{

	// ����
	private String content;
	
	// ��ϵ��ʽ
	private String contects;
	
	// �������ڣ������ݸ��ʱ�䣩
	private Date createDate;
	
	// ��������
	private Date publishedDate;
	
	// ��Ϣ����
	private MessageType messageType;
	
	// ������
	private User user;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContects() {
		return contects;
	}

	public void setContects(String contects) {
		this.contects = contects;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public MessageType getMessageType() {
		return messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
