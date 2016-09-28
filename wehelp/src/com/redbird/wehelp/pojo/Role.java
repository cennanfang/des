package com.redbird.wehelp.pojo;

/**
 * 角色 用以权限控制
 * @author c
 *
 */
public class Role extends BasePojo{

	private static final long serialVersionUID = -1113470115751097957L;
	// 角色名称
	private String name;
	// 是否可用,1：可用，0不可用
	private char available;
	// 角色说明
	private String description;
	
	@Override
	public String toString() {
		return name + " " + description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public char getAvailable() {
		return available;
	}

	public void setAvailable(char available) {
		this.available = available;
	}
	
}
