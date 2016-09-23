package com.redbird.wehelp.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.redbird.wehelp.dao.MessageDao;
import com.redbird.wehelp.pojo.Message;

/**
 * �������ݿ�
 * @author c
 *
 */
public class DBManager {

	@SuppressWarnings("resource")
	public static void main(String args[]) {
		ApplicationContext ctx=null;
        ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        MessageDao messageDao = (MessageDao) ctx.getBean("messageDao");
        Message msg = messageDao.find(1);
        System.out.println(msg);
//        User user=new User();
        //�����������
//        user = generateUser();
//        userDao.add(user);
//        System.out.println("��ӳɹ�");
//        //��ѯ����
//        System.out.println(userDao.find("B2B2CC32030842C18E310FA39A8D33F3").toString());
//        System.out.println(userDao.find("387BE1A242244CB7BA1B898BBCEA2255").toString());
//        //�޸�����
//        user = userDao.find("387BE1A242244CB7BA1B898BBCEA2255");
//        user.setSex(2);;
//        userDao.update(user);
//        System.out.println("�޸ĳɹ�");
//        //ɾ������
//        userDao.delete("B2B2CC32030842C18E310FA39A8D33F3");
//        System.out.println("ɾ���ɹ�");
	}
	
//	public static User generateUser() {
//		User u = new User();
//		u.setId(GUID.generate());
//		u.setUserName("jack");
//		u.setPassword("jack123");
//		u.setNickName("�ܿ�");
//		u.setSex(1);
//		u.setAge(18);
//		return u;
//	}
}
