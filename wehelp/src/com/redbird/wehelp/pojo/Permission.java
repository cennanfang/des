package com.redbird.wehelp.pojo;

/**
 * 权限列表
 * 
 * @author c
 *
 */
public class Permission extends BasePojo {
	
	private static final long serialVersionUID = 3032341793085702601L;

	/** token **/
	private String token;

	/** 资源url **/
	private String url;

	/** 权限说明 **/
	private String description;

	/** 所属角色编号 **/
	private int roleId;

	// 是否可用,1：可用，0不可用
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
