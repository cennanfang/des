package com.redbird.wehelp.pojo;

/**
 * 用户 角色 关联
 * @author c
 *
 */
public class UserRole extends BasePojo{

	private static final long serialVersionUID = -2273855664408123236L;

	// 拥有角色的用户
	private User user;
	
	// 所属用户的角色
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
