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
 * �û���¼Controller
 * 
 * @author Swinglife
 * 
 */
@Controller
@RequestMapping("/")
public class LoginController {
	
	/***
	 * ��ת����¼ҳ��
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String toLogin() {
		// ��ת��/page/login.jspҳ��
		return "login";
	}
	/***
	 * ��ת����ҳ��
	 * 
	 * @return
	 */
	@RequestMapping(value = "/home")
	public String home() {
		// ��ת��/page/login.jspҳ��
		return "home";
	}
	
	/**
	 * ��½��֤�͵�ת
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/doLogin")
	public String doLogin(@ModelAttribute("user") User user) {
		String username = user.getUserName().trim();
		String password = user.getPassword().trim();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password); 
        Subject currentUser = SecurityUtils.getSubject();   
        // �ȵǳ�
        SecurityUtils.getSecurityManager().logout(currentUser);
        // �ٵ���
        try {
        	currentUser.login(token);
        } catch(AuthenticationException e) {
        	e.printStackTrace();
        	return "redirect:login";
        }
		// ��¼�ɹ������ת��successUrl���õ����ӣ����ù����淵�ص����ӡ�
		return "redirect:home";
	}
}
