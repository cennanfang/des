package com.redbird.wehelp.pojo;

/**
 * 角色
 * @author cennanfang
 *
 */
public class Role extends BasePojo{

	private static final long serialVersionUID = -1113470115751097957L;
	// 角色名称
	private String name;
	// 是否可用
	private char available;
	// 描述
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
