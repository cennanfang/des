package com.redbird.wehelp.dao.mybatis;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.redbird.wehelp.dao.MessageDao;
import com.redbird.wehelp.pojo.Message;
import com.redbird.wehelp.service.impl.BaseTest;

public class MessageDaoTest extends BaseTest {

	@Resource
	private MessageDao messageDao;
	
	@Test
	public void testFind() {
		Message m = messageDao.find(2);
		System.out.println(m);
	}
	
	@Test
	public void testLoadMesgsAfter() {
		List<Message> ms = messageDao.loadMesgsAfter(0, 3);
		for (Message message : ms) {
			System.out.println(message);
		}
	}
	
	@Test
	public void testLoadMesgsBefore() {
		List<Message> ms = messageDao.loadMesgsBefore(6, 3);
		for (Message message : ms) {
			System.out.println(message);
		}
	}

}
