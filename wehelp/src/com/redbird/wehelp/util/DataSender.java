package com.redbird.wehelp.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author c
 * 数据输出类 ，都使用静态方法。
 */
public final class DataSender {
	
	/**
	 * 使用 HTTP协议，输出json格式的字符串
	 * @param json 输出的json格式字符串
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
