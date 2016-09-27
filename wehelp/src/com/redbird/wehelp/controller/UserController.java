package com.redbird.wehelp.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.redbird.wehelp.pojo.User;
import com.redbird.wehelp.util.DataSender;

/**
 * 
 * @author c
 */
@Controller
@RequestMapping("/")
public class UserController {

	/**
	 * 自动封装
	 * @param user 用户对象
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="/xxxx", method=RequestMethod.POST)
	public void login(@ModelAttribute("user") User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(user.getUserName());
		System.out.println(user.getNickName());
		String json ="{name : zhangsan; age = 18}";
		DataSender.responseOutWithJson(json, request, response);
	}
}
