package com.redbird.wehelp.util;

/**
 * 管理数据库
 * 
 * @author c
 *
 */
public class DBManager {

	public static void main(String args[]) {
//		ApplicationContext ctx = null;
//		ctx = new ClassPathXmlApplicationContext("classpath:ApplicationContext-*.xml");
//		UserServiceImpl accountService = (UserServiceImpl) ctx.getBean("accountService");
//		
//		User user = accountService.getUserByUserName("rose");
//		if (user == null) {
//			System.out.println("用户不存在");
//		} else {
//			System.out.println(user.toString());
//		}
//		if (user.getPassword().equals("rose123")) {
//			System.out.println("用户存在,且密码验证通过！");
//		}
//		SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());
//		// 登录后存放进shiro token
//		UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
//		Subject subject = SecurityUtils.getSubject();
//		subject.login(token);
		// 登录成功后会跳转到successUrl配置的链接，不用管下面返回的链接。
		System.out.println("测试步骤成功！");
	}

}
