package com.redbird.wehelp.pojo;

/**
 * ��Ϣ����
 * @author c
 *
 */
public class MessageType extends BasePojo{

	// ��������
	private String name;
	// ����
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
