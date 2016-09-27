package com.redbird.wehelp.pojo;

/**
 * 信息类型
 * @author c
 *
 */
public class MessageType extends BasePojo{

	// 类型名称
	private String name;
	// 描述
	private String description;
	
	@Override
	public String toString() {
		return name;
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
