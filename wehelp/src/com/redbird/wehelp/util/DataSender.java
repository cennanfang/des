package com.redbird.wehelp.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author c
 * ��������� ����ʹ�þ�̬������
 */
public final class DataSender {
	
	/**
	 * ʹ�� HTTPЭ�飬���json��ʽ���ַ���
	 * @param json �����json��ʽ�ַ���
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public static void responseOutWithJson(String json, HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write(json);
			out.flush();
		} catch (IOException e) {
			 throw e;
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

}
