package com.redbird.wehelp.service.impl;

import javax.annotation.Resource;

import org.junit.Test;

import com.redbird.wehelp.service.MessageService;
import com.redbird.wehelp.utils.MessagesModel;

public class MessageServiceImplTest extends BaseTest{

	@Resource(name = "messageService")
	private MessageService messageService;
	
	@Test
	public void testLoad() {
		MessagesModel mm = messageService.load(2, 3);
		System.out.println(mm);
	}
}