package com.redbird.wehelp.pojo;

import java.io.Serializable;

/**
 * ����pojo��ĸ���
 * @author c
 *
 */
public class BasePojo implements Serializable {
	
	private static final long serialVersionUID = 7192966620175373660L;
	// pojo�������
	protected int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
