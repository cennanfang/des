package com.redbird.wehelp.pojo;

/**
 * ��Ϣ����
 * @author c
 *
 */
public class MessageType extends BasePojo{
	
	private static final long serialVersionUID = 8829033850039942630L;
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
