package com.redbird.wehelp.util;

import java.util.UUID;

/**
 * GUID ��������
 * 
 * @author c
 *
 */
public final class GUID {
	
	/**
	 * ����Ψһ�ɣ�
	 * @return ͨ�����ɵ�ID
	 */
	public static String generate(){
		// ���� GUID ����
		UUID uuid = UUID.randomUUID();
		// �õ����������ID
		String id = uuid.toString();
		// ת��Ϊ��д
		id = id.toUpperCase();
		// �滻 -
		id = id.replaceAll("-", "");
		return id;
	}
}
