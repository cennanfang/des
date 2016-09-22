package com.redbird.wehelp.pojo;

import java.util.Date;

/**
 * 信息
 * @author c
 *
 */
public class Message extends BasePojo{

	// 内容
	private String content;
	
	// 联系方式
	private String contects;
	
	// 创建日期（创建草稿的时间）
	private Date createDate;
	
	// 发布日期
	private Date publishedDate;
	
	// 信息类型
	private MessageType messageType;
	
	// 创建人
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
