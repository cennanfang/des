package com.redbird.wehelp.pojo;

/**
 * ��ɫ ����Ȩ�޿���
 * @author c
 *
 */
public class Role extends BasePojo{

	private static final long serialVersionUID = -1113470115751097957L;
	// ��ɫ����
	private String name;
	// �Ƿ����,1�����ã�0������
	private char available;
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

	public char getAvailable() {
		return available;
	}

	public void setAvailable(char available) {
		this.available = available;
	}
	
}
