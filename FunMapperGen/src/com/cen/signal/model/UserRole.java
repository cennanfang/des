package com.cen.signal.model;

import java.util.Date;
import com.fun.orm.annotation.FunTable;
import com.fun.orm.annotation.FunPrimary;
import com.fun.orm.annotation.FunForiegn;
import com.fun.orm.annotation.FunColumn;

/**
* UserRole 实体类
* Sun Jul 23 21:02:37 CST 2017 cennanfang
*/ 
@FunTable("t_user_role")
public class UserRole{

	/**
	* 唯一标识
	*/ 
	@FunPrimary("id")
	private Integer id;

	/**
	* 拥有角色的用户
	*/ 
	@FunForiegn(referencedTable="t_user", referencedColumn="id")
	@FunColumn("user_id")
	private User user;

	/**
	* 所属用户的角色
	*/ 
	@FunForiegn(referencedTable="t_role", referencedColumn="id")
	@FunColumn("role_id")
	private Role role;

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

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return id;
	}

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}

	public void setRole(Role role){
		this.role = role;
	}

	public Role getRole(){
		return role;
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

