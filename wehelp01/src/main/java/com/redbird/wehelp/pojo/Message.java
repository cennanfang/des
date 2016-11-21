package com.redbird.wehelp.pojo;

import java.sql.Timestamp;

/**
 * 信息对象
 * @author cennanfang
 *
 */
public class Message extends DBPojo{

	private static final long serialVersionUID = -435864400662153843L;

	// 内容
	private String content;
	
	// 联系方式
	private String contacts;
	
	// 创建日期
	private Timestamp createDate;
	
	// 发布日期
	private Timestamp publishedDate;
	
	// 信息类型
	private int messageTypeId;
	
	// 所属用户
	private int userId;
	
	@Override
	public String toString() {
		return  "id-" + id + "  " +content + " " + createDate;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public int getMessageTypeId() {
		return messageTypeId;
	}

	public void setMessageTypeId(int messageTypeId) {
		this.messageTypeId = messageTypeId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Timestamp publishedDate) {
		this.publishedDate = publishedDate;
	}
}
