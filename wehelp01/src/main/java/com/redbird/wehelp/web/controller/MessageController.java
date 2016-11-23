package com.redbird.wehelp.web.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.redbird.wehelp.pojo.MessagesModel;
import com.redbird.wehelp.service.MessageService;
import com.redbird.wehelp.utils.DataUtils;

/**
 * 
 * @author cennanfang
 *
 */
@Controller
@RequestMapping("/msg")
public class MessageController {
	@Autowired
	private MessageService messageService;

	@ResponseBody
	@RequestMapping("/refresh")
	public String refreshMessages() throws Exception {
		String json = "{}";
		try {
			Timestamp markPublishedDate = DataUtils.stringToTimesamp("2016-11-21 11:08:06.128");
			MessagesModel msgModel = messageService.refreshMessage(markPublishedDate, 3);
			json = DataUtils.pojoToJson(msgModel);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
			throw e;
		}
		return json;
	}
	
	@ResponseBody
	@RequestMapping("/load")
	public String loadMessages() throws Exception {
		String json = "{}";
		try {
			Timestamp maxPuhlishedDate = DataUtils.stringToTimesamp("2016-11-21 11:08:06.151");
			Timestamp minPuhlishedDate = DataUtils.stringToTimesamp("2016-11-21 11:08:06.134");
			MessagesModel msgModel = messageService.loadMessage(maxPuhlishedDate, minPuhlishedDate, 3);
			json = DataUtils.pojoToJson(msgModel);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
			throw e;
		}
		return json;
	}

	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
}
