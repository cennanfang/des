package com.redbird.wehelp.pojo;

import java.io.Serializable;

/**
 * 所有pojo类的父类
 * @author c
 *
 */
public class BasePojo implements Serializable {
	
	private static final long serialVersionUID = 7192966620175373660L;
	// pojo类的主键
	protected int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
