package com.cen.wehelp.model;

import java.util.Date;
import com.fun.orm.annotation.FunTable;
import com.fun.orm.annotation.FunPrimary;

/**
* Role 实体类
* Sun Oct 15 23:15:44 CST 2017 cennanfang
*/ 
@FunTable("t_role")
public class Role{

	/**
	* 唯一标识
	*/ 
	@FunPrimary("id")
	private Long id;

	/**
	* 角色名称
	*/ 
	private String name;

	/**
	* 是否可用0否1是
	*/ 
	private String available;

	/**
	* 创建时间
	*/ 
	private Date createDate;

	/**
	* 更新时间
	*/ 
	private Date updateDate;

	/**
	* 描述、介绍
	*/ 
	private String description;

	public void setId(Long id){
		this.id = id;
	}

	public Long getId(){
		return id;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setAvailable(String available){
		this.available = available;
	}

	public String getAvailable(){
		return available;
	}

	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}

	public Date getCreateDate(){
		return createDate;
	}

	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
	}

	public Date getUpdateDate(){
		return updateDate;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}
}

