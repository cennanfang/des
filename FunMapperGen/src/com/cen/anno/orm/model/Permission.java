package com.cen.anno.orm.model;

import com.fun.orm.annotation.FunTable;
import com.fun.orm.annotation.FunPrimary;
import com.fun.orm.annotation.FunForiegn;
import com.fun.orm.annotation.FunColumn;

/**
* Permission 实体类
* Sat Jul 22 14:52:23 CST 2017 cennanfang
*/ 
@FunTable("t_permission")
public class Permission{

	/**
	* 唯一标识
	*/ 
	@FunPrimary("id")
	private Integer id;

	/**
	* 所属角色
	*/ 
	@FunForiegn(referencedTable="t_role", referencedColumn="id")
	@FunColumn("role_id")
	private Role role;

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

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return id;
	}

	public void setRole(Role role){
		this.role = role;
	}

	public Role getRole(){
		return role;
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

