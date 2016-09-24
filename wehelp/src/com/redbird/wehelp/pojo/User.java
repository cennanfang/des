package com.redbird.wehelp.pojo;

import java.util.Date;
import java.util.List;

/**
 * �û���Ϣ��
 * @author c
 *
 */
public class User extends BasePojo {

	// �û���
	private String userName;
	// ����
	private String password;
	// �ǳ�
	private String nickName;
	// �Ա� ���� 1 Ů�� 2 ���� 0
	private int sex;
	// ����
	private int age;
	// �绰
	private int phone;
	// ����
	private String email;
	// ��ַ
	private String address;
	// ע������
	private Date registerDate;
	// �û���ӵ�еĽ�ɫ
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
