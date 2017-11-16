package com.buliyiren.shpre.model;

import java.util.Date;
import com.fun.orm.annotation.FunTable;
import com.fun.orm.annotation.FunPrimary;

/**
* User 实体类
* Thu Nov 16 09:45:06 CST 2017 cennanfang
*/ 
@FunTable("t_user")
public class User {

	/**
	* 
	*/ 
	@FunPrimary("id")
	private Integer id;

	/**
	* 
	*/ 
	private Integer organizationId;

	/**
	* 用户账号
	*/ 
	private String username;

	/**
	* 用户昵称
	*/ 
	private String nickName;

	/**
	* 
	*/ 
	private String password;

	/**
	* 
	*/ 
	private String salt;

	/**
	* 
	*/ 
	private Boolean locked;

	/**
	* 
	*/ 
	private String sex;

	/**
	* 出生年月
	*/ 
	private Date birthDate;

	/**
	* 电话号码
	*/ 
	private String phone;

	/**
	* 邮箱
	*/ 
	private String email;

	/**
	* 地址
	*/ 
	private String address;

	/**
	* 注册日期
	*/ 
	private Date registerDate;

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return id;
	}

	public void setOrganizationId(Integer organizationId){
		this.organizationId = organizationId;
	}

	public Integer getOrganizationId(){
		return organizationId;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	public void setNickName(String nickName){
		this.nickName = nickName;
	}

	public String getNickName(){
		return nickName;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setSalt(String salt){
		this.salt = salt;
	}

	public String getSalt(){
		return salt;
	}

	public void setLocked(Boolean locked){
		this.locked = locked;
	}

	public Boolean getLocked(){
		return locked;
	}

	public void setSex(String sex){
		this.sex = sex;
	}

	public String getSex(){
		return sex;
	}

	public void setBirthDate(Date birthDate){
		this.birthDate = birthDate;
	}

	public Date getBirthDate(){
		return birthDate;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setRegisterDate(Date registerDate){
		this.registerDate = registerDate;
	}

	public Date getRegisterDate(){
		return registerDate;
	}
}

