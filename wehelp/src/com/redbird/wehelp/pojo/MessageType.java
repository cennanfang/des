package com.redbird.wehelp.pojo;

/**
 * ��Ϣ����
 * @author c
 *
 */
public class MessageType extends BasePojo{

	// ��������
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
