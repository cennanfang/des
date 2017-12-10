package com.buliyiren.wehelp.model;

import com.fun.orm.annotation.FunTable;
import com.fun.orm.annotation.FunPrimary;

/**
* RoleResource 实体类
* Sun Dec 10 21:42:31 CST 2017 cennanfang
*/ 
@FunTable("t_role_resource")
public class RoleResource {

	/**
	* 
	*/ 
	@FunPrimary("id")
	private Integer id;

	/**
	* 
	*/ 
	private Integer roleId;

	/**
	* 
	*/ 
	private Integer resourceId;

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return id;
	}

	public void setRoleId(Integer roleId){
		this.roleId = roleId;
	}

	public Integer getRoleId(){
		return roleId;
	}

	public void setResourceId(Integer resourceId){
		this.resourceId = resourceId;
	}

	public Integer getResourceId(){
		return resourceId;
	}
}

