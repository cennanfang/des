package com.redbird.wehelp.pojo;

import java.io.Serializable;

/**
 * 基础实体对象
 * @author cennanfang
 *
 */
public class BasePojo implements Serializable {
	
	private static final long serialVersionUID = 7192966620175373660L;
	// pojo标识
	protected int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
