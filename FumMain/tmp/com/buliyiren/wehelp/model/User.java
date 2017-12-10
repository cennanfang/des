package com.buliyiren.wehelp.model;

import java.util.Date;
import com.fun.orm.annotation.FunTable;
import com.fun.orm.annotation.FunPrimary;

/**
* User 实体类
* Sun Dec 10 21:29:50 CST 2017 cennanfang
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
	private String userName;

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
	* 性别
	*/ 
	private String gender;

	/**
	* 出生年月
	*/ 
	private Date birthdate;

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

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return userName;
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

	public void setGender(String gender){
		this.gender = gender;
	}

	public String getGender(){
		return gender;
	}

	public void setBirthdate(Date birthdate){
		this.birthdate = birthdate;
	}

	public Date getBirthdate(){
		return birthdate;
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

