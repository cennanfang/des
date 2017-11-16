package com.buliyiren.shpre.model;

import com.fun.orm.annotation.FunTable;

/**
* UserRole 实体类
* Thu Nov 16 09:45:06 CST 2017 cennanfang
*/ 
@FunTable("t_user_role")
public class UserRole {

	/**
	* 
	*/ 
	private Integer userId;

	/**
	* 
	*/ 
	private Integer roleId;

	public void setUserId(Integer userId){
		this.userId = userId;
	}

	public Integer getUserId(){
		return userId;
	}

	public void setRoleId(Integer roleId){
		this.roleId = roleId;
	}

	public Integer getRoleId(){
		return roleId;
	}
}

