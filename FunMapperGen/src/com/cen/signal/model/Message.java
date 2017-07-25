package com.cen.signal.model;

import java.util.Date;
import com.fun.orm.annotation.FunTable;
import com.fun.orm.annotation.FunPrimary;
import com.fun.orm.annotation.FunForiegn;
import com.fun.orm.annotation.FunColumn;

/**
* Message 实体类
* Sun Jul 23 21:02:37 CST 2017 cennanfang
*/ 
@FunTable("t_message")
public class Message{

	/**
	* 唯一标识且自增
	*/ 
	@FunPrimary("id")
	private Integer id;

	/**
	* 消息创建者
	*/ 
	@FunForiegn(referencedTable="t_user", referencedColumn="id")
	@FunColumn("user_id")
	private User user;

	/**
	* 消息类型
	*/ 
	@FunForiegn(referencedTable="t_message_type", referencedColumn="id")
	@FunColumn("type_id")
	private MessageType messageType;

	/**
	* 消息内容
	*/ 
	private String content;

	/**
	* 联系信息
	*/ 
	private String contacts;

	/**
	* 创建时间
	*/ 
	private Date createDate;

	/**
	* 发布时间
	*/ 
	private Date publishedDate;

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return id;
	}

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}

	public void setMessageType(MessageType messageType){
		this.messageType = messageType;
	}

	public MessageType getMessageType(){
		return messageType;
	}

	public void setContent(String content){
		this.content = content;
	}

	public String getContent(){
		return content;
	}

	public void setContacts(String contacts){
		this.contacts = contacts;
	}

	public String getContacts(){
		return contacts;
	}

	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}

	public Date getCreateDate(){
		return createDate;
	}

	public void setPublishedDate(Date publishedDate){
		this.publishedDate = publishedDate;
	}

	public Date getPublishedDate(){
		return publishedDate;
	}
}

