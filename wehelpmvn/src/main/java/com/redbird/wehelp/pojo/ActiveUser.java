package com.redbird.wehelp.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 活动状态的用户对象
 * @author cennanfang
 *
 */
public class ActiveUser extends BasePojo {
	
	private static final long serialVersionUID = -6937820421163866201L;
	// 用户名
	private String userName;
	// 密码
	private String nickName;
	// 性别
	private int sex;
	// 年龄
	private int age;
	// 号码
	private String phone;
	// 邮箱
	private String email;
	// 地址
	private String address;
	// 注册日期
	private Date registerDate;
	// 权限列表
	private List<Permission> permissions;
	// 角色列表
	private List<Role> roles;
	
	/**
	 * 获取角色名称列表
	 * @return
	 */
	public Set<String> getStringRoles() {
		if(roles == null) {
			return null;
		}
		Set<String> strRoles = new HashSet<String>();
		for (Role role : roles) {
			strRoles.add(role.getName());
		}
		return strRoles;
	}
	
	/**
	 * 获取url列表
	 * @return
	 */
	public Set<String> getStringPermissions() {
		if(permissions == null) {
			return null;
		}
		Set<String> strPermissions = new HashSet<String>();
		for (Permission permission : permissions) {
			strPermissions.add(permission.getUrl());
		}
		return strPermissions;
	}
	
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
