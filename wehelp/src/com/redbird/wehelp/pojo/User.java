package com.redbird.wehelp.pojo;

import java.util.Date;
import java.util.List;

/**
 * 用户信息类
 * @author c
 *
 */
public class User extends BasePojo {

	// 用户名
	private String userName;
	// 密码
	private String password;
	// 昵称
	private String nickName;
	// 性别 男人 1 女人 2 其他 0
	private int sex;
	// 年龄
	private int age;
	// 电话
	private int phone;
	// 邮箱
	private String email;
	// 地址
	private String address;
	// 注册日期
	private Date registerDate;
	// 用户所拥有的角色
	private List<UserRole> userRoles;
	
	@Override
	public String toString() {
		return userName + " " + nickName;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
}
