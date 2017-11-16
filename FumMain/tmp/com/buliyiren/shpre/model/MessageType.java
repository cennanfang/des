package com.buliyiren.shpre.model;

import com.fun.orm.annotation.FunTable;
import com.fun.orm.annotation.FunPrimary;

/**
* MessageType 实体类
* Thu Nov 16 09:45:06 CST 2017 cennanfang
*/ 
@FunTable("t_message_type")
public class MessageType {

	/**
	* 唯一标识且自增
	*/ 
	@FunPrimary("id")
	private Integer id;

	/**
	* 类型名称
	*/ 
	private String name;

	/**
	* 描述
	*/ 
	private String description;

	/**
	* 
	*/ 
	private Boolean available;

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return id;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setAvailable(Boolean available){
		this.available = available;
	}

	public Boolean getAvailable(){
		return available;
	}
}

