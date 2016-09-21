package com.redbird.wehelp.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.redbird.wehelp.dao.UserDao;
import com.redbird.wehelp.pojo.User;

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
        UserDao userDao=(UserDao) ctx.getBean("userDao");
        User user=new User();
        //�����������
        user = generateUser();
        userDao.add(user);
        System.out.println("��ӳɹ�");
//        //��ѯ����
//        user.setUsername("Jessica");
//        user.setPassword("123");
//        System.out.println(userDao.getUser(user).toString());
//        user.setUsername("Jessica2");
//        user.setPassword("123");
//        System.out.println(userDao.getUser(user).toString());
//        //�޸�����
//        user.setId(2);
//        user.setPassword("802");
//        userDao.updateUser(user);
//        System.out.println("�޸ĳɹ�");
//        //ɾ������
//        userDao.deleteUser(1);
//        System.out.println("ɾ���ɹ�");
	}
	
	public static User generateUser() {
		User u = new User();
		u.setId(GUID.generate());
		u.setUserName("zhangsan");
		u.setPassword("zs123");
		u.setSex(1);
		u.setAge(18);
		return u;
	}
}
