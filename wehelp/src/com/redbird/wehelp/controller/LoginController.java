package com.redbird.wehelp.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.redbird.wehelp.pojo.User;
import com.redbird.wehelp.service.impl.UserServiceImpl;

/****
 * 用户登录Controller
 * 
 * @author Swinglife
 * 
 */
@Controller
@RequestMapping("/")
public class LoginController {
	// 处理用户业务类
	@Autowired
	private UserServiceImpl userService;
	
	
	/***
	 * 跳转到登录页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toLogin")
	public String toLogin() {
		// 跳转到/page/login.jsp页面
		System.out.println("-----------------toLogin--------------");
		return "login";
	}
	
	@RequestMapping(value = "/login")
	public String home(@ModelAttribute("user") User user) {
		System.out.println("-----------------home--------------");
		String username = user.getUserName();
		String password = user.getPassword();
		user = userService.findByUserName(username);
		System.out.println(username + "---------home-----------" + password);
		if (user == null) {
			System.out.println("user id null!");
			return "toLogin";
		}
		if (!user.getPassword().equals(password)) {
			System.out.println("账号密码错误");
			return "toLogin";
		}
		System.out.println(user.toString());
		System.out.println("账号验证成功");
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);   
        Subject currentUser = SecurityUtils.getSubject();   
        currentUser.login(token); 
		
//		SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());
//		// 登录后存放进shiro token
//		UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
//		Subject subject = SecurityUtils.getSubject();
//		subject.login(token);
		// 登录成功后会跳转到successUrl配置的链接，不用管下面返回的链接。
		return "home";
	}
}
