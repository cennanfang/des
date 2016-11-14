package com.redbird.wehelp.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@RequestMapping(value = "/login")
	public String toLogin() {
		return "login";
	}
	
	@RequestMapping(value = "/home")
	@RequiresPermissions(value="/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/subLogin", method=RequestMethod.POST)
	public String subLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
		username = username.trim();
		password = password.trim();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password); 
        Subject currentUser = SecurityUtils.getSubject();   
        SecurityUtils.getSecurityManager().logout(currentUser);
        try {
        	currentUser.login(token);
        } catch(AuthenticationException e) {
        	e.printStackTrace();
        	return "redirect:login";
        }
		return "redirect:home";
	}
}
