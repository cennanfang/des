package com.redbird.wehelp.pojo;

/**
 * ��Ϣ����
 * @author c
 *
 */
public class MessageType extends BasePojo{

	// ��������
	private String name;
	
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

}
