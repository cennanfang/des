package com.redbird.wehelp.pojo;

/**
 * 角色 用以权限控制
 * @author c
 *
 */
public class Role extends BasePojo{

	// 角色名称
	private String name;
	
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
	
}
