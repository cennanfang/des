package com.redbird.wehelp.pojo;

/**
 * 信息类型
 * @author cennanfang
 *
 */
public class MessageType extends BasePojo{
	
	private static final long serialVersionUID = 8829033850039942630L;
	// 类型名称
	private String name;
	// 描述
	private String description;
	// 是否可用
	private char available;
	
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

	public char getAvailable() {
		return available;
	}

	public void setAvailable(char available) {
		this.available = available;
	}

}
