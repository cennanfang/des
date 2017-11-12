package com.cen.wehelp.model;

import java.util.Date;
import com.fun.orm.annotation.FunTable;
import com.fun.orm.annotation.FunPrimary;

/**
* Message 实体类
* Sun Oct 15 23:15:44 CST 2017 cennanfang
*/ 
@FunTable("t_message")
public class Message{

	/**
	* 唯一标识且自增
	*/ 
	@FunPrimary("id")
	private Long id;

	/**
	* 消息创建者
	*/ 
	private Long userId;

	/**
	* 消息类型
	*/ 
	private Long typeId;

	/**
	* 消息内容
	*/ 
	private String content;

	/**
	* 联系信息
	*/ 
	private String contacts;

	/**
	* 约定地点
	*/ 
	private String locale;

	/**
	* 经度
	*/ 
	private Float longitude;

	/**
	* 纬度
	*/ 
	private Float latitude;

	/**
	* 创建时间
	*/ 
	private Date createDate;

	/**
	* 发布时间
	*/ 
	private Date publishedDate;

	public void setId(Long id){
		this.id = id;
	}

	public Long getId(){
		return id;
	}

	public void setUserId(Long userId){
		this.userId = userId;
	}

	public Long getUserId(){
		return userId;
	}

	public void setTypeId(Long typeId){
		this.typeId = typeId;
	}

	public Long getTypeId(){
		return typeId;
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

	public void setLocale(String locale){
		this.locale = locale;
	}

	public String getLocale(){
		return locale;
	}

	public void setLongitude(Float longitude){
		this.longitude = longitude;
	}

	public Float getLongitude(){
		return longitude;
	}

	public void setLatitude(Float latitude){
		this.latitude = latitude;
	}

	public Float getLatitude(){
		return latitude;
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

