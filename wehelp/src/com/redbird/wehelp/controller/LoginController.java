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
 * �û���¼Controller
 * 
 * @author Swinglife
 * 
 */
@Controller
@RequestMapping("/")
public class LoginController {
	// �����û�ҵ����
	@Autowired
	private UserServiceImpl userService;
	
	
	/***
	 * ��ת����¼ҳ��
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toLogin")
	public String toLogin() {
		// ��ת��/page/login.jspҳ��
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
			System.out.println("�˺��������");
			return "toLogin";
		}
		System.out.println(user.toString());
		System.out.println("�˺���֤�ɹ�");
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);   
        Subject currentUser = SecurityUtils.getSubject();   
        currentUser.login(token); 
		
//		SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());
//		// ��¼���Ž�shiro token
//		UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
//		Subject subject = SecurityUtils.getSubject();
//		subject.login(token);
		// ��¼�ɹ������ת��successUrl���õ����ӣ����ù����淵�ص����ӡ�
		return "home";
	}
}
