package com.redbird.wehelp.util;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.redbird.wehelp.dao.UserRoleDao;
import com.redbird.wehelp.pojo.BasePojo;
import com.redbird.wehelp.pojo.Message;
import com.redbird.wehelp.pojo.Role;
import com.redbird.wehelp.pojo.User;
import com.redbird.wehelp.pojo.UserRole;

/**
 * 管理数据库
 * 
 * @author c
 *
 */
public class DBManager {

	@SuppressWarnings("resource")
	public static void main(String args[]) {
		ApplicationContext ctx = null;
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserRoleDao urd = (UserRoleDao) ctx.getBean("userRoleDao");
//		UserRole ur = urd.find(1);
//		System.out.println(ur.getUser().toString() + " ： " + ur.getRole().toString());
		List<UserRole> urs = urd.findByUserId(1);
		for (UserRole userRole : urs) {
			Role role = userRole.getRole();
			User user = userRole.getUser();
			System.out.println(user.toString() + " ： " + role.toString());
		}
		// MessageDao messageDao = (MessageDao) ctx.getBean("messageDao");
		// MessageTypeDao messageTypeDao = (MessageTypeDao)
		// ctx.getBean("messageTypeDao");
		// System.out.println(messageTypeDao.find(1).toString());
		// UserDao userDao = (UserDao) ctx.getBean("userDao");
		// User user = userDao.findByUserName("rose");
		// System.out.println(user.toString());
		// Message msg = (Message)generateBasePojo();
		// msg.setUser(userDao.find(2));
		// msg.setMessageType(messageTypeDao.find(2));
		// Message msg = messageDao.find(3);
		// msg.setContacts("0859-4323889");
		// messageDao.update(msg);
		// Message msg = messageDao.find(1);
		// System.out.println(msg);
	}

	public static BasePojo generateBasePojo() {
		Message b = new Message();
		b.setContent("本人要从册亨兴义");
		b.setContacts("123123132342432");
		return b;
	}
}
