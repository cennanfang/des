package com.redbird.wehelp.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author cennafang
 *
 */
public final class DataSender {
	/**
	 * 给请求返回json
	 * @param json
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
