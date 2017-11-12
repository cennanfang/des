package com.cen.wehelp.model;

import java.util.Date;
import com.fun.orm.annotation.FunTable;
import com.fun.orm.annotation.FunPrimary;

/**
* UserRole 实体类
* Sun Oct 15 23:15:44 CST 2017 cennanfang
*/ 
@FunTable("t_user_role")
public class UserRole{

	/**
	* 唯一标识
	*/ 
	@FunPrimary("id")
	private Long id;

	/**
	* 拥有角色的用户
	*/ 
	private Long userId;

	/**
	* 所属用户的角色
	*/ 
	private Long roleId;

	/**
	* 是否可用0否1是
	*/ 
	private String available;

	/**
	* 授权时间
	*/ 
	private Date createDate;

	/**
	* 更新时间
	*/ 
	private Date updateDate;

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

	public void setRoleId(Long roleId){
		this.roleId = roleId;
	}

	public Long getRoleId(){
		return roleId;
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
}

