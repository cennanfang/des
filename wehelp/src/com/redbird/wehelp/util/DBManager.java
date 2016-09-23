package com.redbird.wehelp.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.redbird.wehelp.dao.MessageTypeDao;
import com.redbird.wehelp.pojo.BasePojo;
import com.redbird.wehelp.pojo.Message;

/**
 * 管理数据库
 * @author c
 *
 */
public class DBManager {

	@SuppressWarnings("resource")
	public static void main(String args[]) {
		ApplicationContext ctx=null;
        ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
//        MessageDao messageDao = (MessageDao) ctx.getBean("messageDao");
        MessageTypeDao messageTypeDao = (MessageTypeDao) ctx.getBean("messageTypeDao");
        System.out.println(messageTypeDao.find(1).toString());
//        UserDao userDao = (UserDao) ctx.getBean("userDao");
//        Message msg = (Message)generateBasePojo();
//        msg.setUser(userDao.find(2));
//        msg.setMessageType(messageTypeDao.find(2));
//        Message msg = messageDao.find(3);
//        msg.setContacts("0859-4323889");
//        messageDao.update(msg);
//        Message msg = messageDao.find(1);
//        System.out.println(msg);
	}
	
	public static BasePojo generateBasePojo() {
		Message b = new Message();
		b.setContent("本人要从册亨兴义");
		b.setContacts("123123132342432");
		return b;
	}
}
