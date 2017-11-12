package com.cen.wehelp.model;

import com.fun.orm.annotation.FunTable;
import com.fun.orm.annotation.FunPrimary;

/**
* Permission 实体类
* Sun Oct 15 23:15:44 CST 2017 cennanfang
*/ 
@FunTable("t_permission")
public class Permission{

	/**
	* 唯一标识
	*/ 
	@FunPrimary("id")
	private Long id;

	/**
	* 所属角色
	*/ 
	private Long roleId;

	/**
	* 未使用
	*/ 
	private String token;

	/**
	* url链接
	*/ 
	private String url;

	/**
	* 是否可用0否1是
	*/ 
	private String available;

	/**
	* 描述介绍
	*/ 
	private String description;

	public void setId(Long id){
		this.id = id;
	}

	public Long getId(){
		return id;
	}

	public void setRoleId(Long roleId){
		this.roleId = roleId;
	}

	public Long getRoleId(){
		return roleId;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setAvailable(String available){
		this.available = available;
	}

	public String getAvailable(){
		return available;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}
}

