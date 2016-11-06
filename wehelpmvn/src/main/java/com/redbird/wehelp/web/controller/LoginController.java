package com.redbird.wehelp.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login() {
		System.out.println("----------login----------");
		return "login";
	}

	@RequestMapping(value = "/doLogin")
	public String doLogin(String username, String password) {
		System.out.println("----------doLogin----------");
		username = username.trim();
		password = password.trim();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject currentUser = SecurityUtils.getSubject();
		SecurityUtils.getSecurityManager().logout(currentUser);
		try {
			currentUser.login(token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
			return "redirect:index";
		}
		return "redirect:login";
	}

}
