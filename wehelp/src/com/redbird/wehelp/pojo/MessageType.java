package com.redbird.wehelp.pojo;

/**
 * 信息类型
 * @author c
 *
 */
public class MessageType extends BasePojo{

	// 类型名称
	private String typeName;
	
	@Override
	public String toString() {
		return typeName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}
