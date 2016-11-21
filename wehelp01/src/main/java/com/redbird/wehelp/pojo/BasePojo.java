package com.redbird.wehelp.pojo;

import java.io.Serializable;

/**
 * 
 * @author cennanfang所有类的父类
 *
 */
public abstract class BasePojo implements Serializable {

	private static final long serialVersionUID = 6992084818413823250L;
	// pojo标识
	protected int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
