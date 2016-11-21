package com.redbird.wehelp.pojo;

/**
 * 用户角色类
 * 
 * @author cennanfang
 *
 */
public class UserRole extends DataBasePojo {

	private static final long serialVersionUID = -2273855664408123236L;

	// 用户
	private int userId;

	// 角色
	private int roleId;

	// 是否可用
	private char available;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public char getAvailable() {
		return available;
	}

	public void setAvailable(char available) {
		this.available = available;
	}

}
