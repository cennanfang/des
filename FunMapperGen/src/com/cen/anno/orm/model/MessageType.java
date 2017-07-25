package com.cen.anno.orm.model;

import com.fun.orm.annotation.FunTable;
import com.fun.orm.annotation.FunPrimary;

/**
* MessageType 实体类
* Sat Jul 22 14:52:23 CST 2017 cennanfang
*/ 
@FunTable("t_message_type")
public class MessageType{

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
	* 是否可用0否1是
	*/ 
	private String available;

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

	public void setAvailable(String available){
		this.available = available;
	}

	public String getAvailable(){
		return available;
	}
}

