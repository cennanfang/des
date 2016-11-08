package com.redbird.wehelp.pojo;

/**
 * 用户角色类
 * @author cennanfang
 *
 */
public class UserRole extends BasePojo{

	private static final long serialVersionUID = -2273855664408123236L;

	// 用户
	private User user;
	
	// 角色
	private Role role;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
