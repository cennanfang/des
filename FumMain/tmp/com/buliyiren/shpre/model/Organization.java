package com.buliyiren.shpre.model;

import com.fun.orm.annotation.FunTable;
import com.fun.orm.annotation.FunPrimary;

/**
* Organization 实体类
* Thu Nov 16 09:45:06 CST 2017 cennanfang
*/ 
@FunTable("t_organization")
public class Organization {

	/**
	* 
	*/ 
	@FunPrimary("id")
	private Integer id;

	/**
	* 
	*/ 
	private String name;

	/**
	* 
	*/ 
	private Integer parentId;

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

	public void setParentId(Integer parentId){
		this.parentId = parentId;
	}

	public Integer getParentId(){
		return parentId;
	}

	public void setAvailable(Boolean available){
		this.available = available;
	}

	public Boolean getAvailable(){
		return available;
	}
}

