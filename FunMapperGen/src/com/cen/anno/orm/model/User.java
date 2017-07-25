package com.cen.anno.orm.model;

import java.util.Date;
import com.fun.orm.annotation.FunTable;
import com.fun.orm.annotation.FunPrimary;

/**
* User 实体类
* Sat Jul 22 14:52:23 CST 2017 cennanfang
*/ 
@FunTable("t_user")
public class User{

	/**
	* 唯一标识
	*/ 
	@FunPrimary("id")
	private Integer id;

	/**
	* 用户名（用户账号）唯一
	*/ 
	private String userName;

	/**
	* 账号密码
	*/ 
	private String password;

	/**
	* 盐
	*/ 
	private String salt;

	/**
	* 是否锁定0否，1是
	*/ 
	private String locked;

	/**
	* 用户昵称
	*/ 
	private String nickName;

	/**
	* 性别 男：0 女：1
	*/ 
	private String sex;

	/**
	* 年龄
	*/ 
	private Integer age;

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

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return userName;
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

	public void setLocked(String locked){
		this.locked = locked;
	}

	public String getLocked(){
		return locked;
	}

	public void setNickName(String nickName){
		this.nickName = nickName;
	}

	public String getNickName(){
		return nickName;
	}

	public void setSex(String sex){
		this.sex = sex;
	}

	public String getSex(){
		return sex;
	}

	public void setAge(Integer age){
		this.age = age;
	}

	public Integer getAge(){
		return age;
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

