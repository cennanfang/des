package com.redbird.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mvc")
public class MvcController {

	@RequestMapping("/hello")
    public String hello(){       
        return "hello";
    }
	
	
	@RequestMapping("/out")
	public void responseOutWithJson(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		String jsonStr = "{username:'²ÐÈ±µÄ¹Â¶À',password:'admin123'}";
		out.write(jsonStr);
		out.flush();
		out.close();
	}
	
	@RequestMapping("/out_jsp")
	public String outDataJsp(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		String jsonStr = "{username:'²ÐÈ±µÄ¹Â¶À',password:'admin123'}";
		out.write(jsonStr);
		out.flush();
		out.close();
		return "out";
	}
}
