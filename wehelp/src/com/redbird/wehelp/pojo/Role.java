package com.redbird.wehelp.pojo;

/**
 * ��ɫ ����Ȩ�޿���
 * @author c
 *
 */
public class Role extends BasePojo{

	// ��ɫ����
	private String name;
	
	// ��ɫ˵��
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
