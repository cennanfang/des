package com.redbird.wehelp.pojo;

import java.util.Date;
import java.util.List;

/**
 * �����û�
 * @author c
 *
 */
public class ActiveUser extends BasePojo {
	
	private static final long serialVersionUID = -6937820421163866201L;
	// �û���
	private String userName;
	// �ǳ�
	private String nickName;
	// �Ա� ���� 1 Ů�� 2 ���� 0
	private int sex;
	// ����
	private int age;
	// �绰
	private String phone;
	// ����
	private String email;
	// ��ַ
	private String address;
	// ע������
	private Date registerDate;
	// �û���ӵ�еĽ�ɫ
	private List<Permission> permissions;
	
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
}
