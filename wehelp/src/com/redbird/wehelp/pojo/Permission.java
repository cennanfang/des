package com.redbird.wehelp.pojo;

/**
 * 权限列表
 * 
 * @author c
 *
 */
public class Permission extends BasePojo {
	/** token **/
	private String token;

	/** 资源url **/
	private String url;

	/** 权限说明 **/
	private String description;

	/** 所属角色编号 **/
	private int roleId;

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

}
