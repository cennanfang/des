package com.redbird.wehelp.dao.mybatis;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.redbird.wehelp.dao.MessageDao;
import com.redbird.wehelp.pojo.Message;
import com.redbird.wehelp.service.impl.BaseTest;
import com.redbird.wehelp.utils.DataUtils;

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
		try {
			Timestamp t = DataUtils.stringToTimesamp("2016-11-21 11:08:06.128");
			List<Message> ms = messageDao.loadMesgsAfter(t, 3);
			for (Message message : ms) {
				System.out.println(message);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testLoadMesgsBefore() {
		try {
			Timestamp maxPuhishedDate = DataUtils.stringToTimesamp("2016-11-21 11:08:06.151");
			Timestamp minPuhishedDate = DataUtils.stringToTimesamp("2016-11-21 11:08:06.134");
			List<Message> ms = messageDao.loadMesgsBefore(maxPuhishedDate, minPuhishedDate, 3);
			for (Message message : ms) {
				System.out.println(message);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
}
