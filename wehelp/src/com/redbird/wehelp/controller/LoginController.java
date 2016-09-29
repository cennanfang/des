package com.redbird.wehelp.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.redbird.wehelp.pojo.User;

/****
 * 用户登录Controller
 * 
 * @author Swinglife
 * 
 */
@Controller
@RequestMapping("/")
public class LoginController {
	
	/***
	 * 跳转到登录页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String toLogin() {
		// 跳转到/page/login.jsp页面
		return "login";
	}
	/***
	 * 跳转到主页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/home")
	public String home() {
		// 跳转到/page/login.jsp页面
		return "home";
	}
	
	/**
	 * 登陆验证和调转
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/doLogin")
	public String doLogin(@ModelAttribute("user") User user) {
		String username = user.getUserName().trim();
		String password = user.getPassword().trim();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password); 
        Subject currentUser = SecurityUtils.getSubject();   
        // 先登出
        SecurityUtils.getSecurityManager().logout(currentUser);
        // 再登入
        try {
        	currentUser.login(token);
        } catch(AuthenticationException e) {
        	e.printStackTrace();
        	return "redirect:login";
        }
		// 登录成功后会跳转到successUrl配置的链接，不用管下面返回的链接。
		return "redirect:home";
	}
}
