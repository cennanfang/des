package org.redbird.des.data;

import java.io.Serializable;

/**
 * 
 * @author cennanfang
 * @date 2015年11月14日
 * @filename BasePojo.java
 */
public abstract class BasePojo  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 长度为32
	 */
	private  String uuid;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
