package com.redbird.wehelp.pojo;

/**
 * �û� ��ɫ ����
 * @author c
 *
 */
public class UserRole extends BasePojo{

	// ӵ�н�ɫ���û�
	private User user;
	
	// �����û��Ľ�ɫ
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
