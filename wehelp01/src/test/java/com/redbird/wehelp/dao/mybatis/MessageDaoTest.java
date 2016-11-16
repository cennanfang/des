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
	public void testLoadMesgs() {
		List<Message> ms = messageDao.loadMesgs(0, 3);
		for (Message message : ms) {
			System.out.println(message);
		}
	}
	
	@Test
	public void testListMesgs() {
		List<Message> ms = messageDao.listMesgs();
		for (Message message : ms) {
			System.out.println(message);
		}
	}

}
