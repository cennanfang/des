package com.redbird.wehelp.pojo;

import java.util.Date;

/**
 * 信息对象
 * @author cennanfang
 *
 */
public class Message extends BasePojo{

	private static final long serialVersionUID = -435864400662153843L;

	// 内容
	private String content;
	
	// 联系方式
	private String contacts;
	
	// 创建日期
	private Date createDate;
	
	// 发布日期
	private Date publishedDate;
	
	// 信息类型
	private MessageType messageType;
	
	// 所属用户
	private User user;
	
	@Override
	public String toString() {
		String msg = user.getNickName() + " "
				   + messageType.getName() 
				   + ":" + content + " ��ϵ��ʽ "
				   + contacts;
		return msg;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
}
