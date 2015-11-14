package org.redbird.des.data.user.pojo;

import org.redbird.des.data.BasePojo;

/**
 * 人员信息
 * @author cennanfang
 * @date 2015年11月14日
 * @filename Person.java
 */
public class Person extends BasePojo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 姓名
	private String name;
	// 代码
	private String code;
	// 地址
	private String address;
	// 电话
	private String phone;
	// 性别
	private String sex;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}
