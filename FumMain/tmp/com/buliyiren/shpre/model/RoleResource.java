package com.buliyiren.shpre.model;

import com.fun.orm.annotation.FunTable;

/**
* RoleResource 实体类
* Thu Nov 16 09:45:06 CST 2017 cennanfang
*/ 
@FunTable("t_role_resource")
public class RoleResource {

	/**
	* 
	*/ 
	private Integer roleId;

	/**
	* 
	*/ 
	private Integer resourceId;

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

