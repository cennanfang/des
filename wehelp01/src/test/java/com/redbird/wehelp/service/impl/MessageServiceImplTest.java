package com.redbird.wehelp.service.impl;

import java.sql.Timestamp;
import java.text.ParseException;

import javax.annotation.Resource;

import org.junit.Test;

import com.redbird.wehelp.service.MessageService;
import com.redbird.wehelp.utils.DataUtils;
import com.redbird.wehelp.utils.MessagesModel;

public class MessageServiceImplTest extends BaseTest{

	@Resource
	private MessageService messageService;
	
	@Test
	public void testRefreshMessage() {
		try {
			Timestamp markPublishedDate = DataUtils.stringToTimesamp("2016-11-21 11:08:06.128");
			System.out.println(markPublishedDate);
			MessagesModel mm = messageService.refreshMessage(markPublishedDate, 4);
			System.out.println(mm);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testLoadMessage() {
		try {
			Timestamp maxPuhlishedDate = DataUtils.stringToTimesamp("2016-11-21 11:08:06.151");
			Timestamp minPuhlishedDate = DataUtils.stringToTimesamp("2016-11-21 11:08:06.134");
			MessagesModel mm = messageService.loadMessage(maxPuhlishedDate, minPuhlishedDate, 3);
			System.out.println(mm);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
}