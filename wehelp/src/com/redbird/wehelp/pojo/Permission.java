package com.redbird.wehelp.pojo;

/**
 * Ȩ���б�
 * 
 * @author c
 *
 */
public class Permission extends BasePojo {
	
	private static final long serialVersionUID = 3032341793085702601L;

	/** token **/
	private String token;

	/** ��Դurl **/
	private String url;

	/** Ȩ��˵�� **/
	private String description;

	/** ������ɫ��� **/
	private int roleId;

	// �Ƿ����,1�����ã�0������
	private char available;

	@Override
	public String toString() {
		return token + ":" + url + "  " + description;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public char getAvailable() {
		return available;
	}

	public void setAvailable(char available) {
		this.available = available;
	}

}
