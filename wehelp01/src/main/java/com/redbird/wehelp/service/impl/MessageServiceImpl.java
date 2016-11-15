package com.redbird.wehelp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redbird.wehelp.dao.MessageDao;
import com.redbird.wehelp.pojo.Message;
import com.redbird.wehelp.service.MessageService;
import com.redbird.wehelp.utils.MessagesModel;

@Service("messageService")
public class MessageServiceImpl implements MessageService{
	
	@Autowired
	private MessageDao messageDao;

	@Override
	public MessagesModel load(int startMsgId, int pageSize) {
		System.out.println(startMsgId + "  " + pageSize);
		List<Message> messages = messageDao.loadMesgs(startMsgId, pageSize);
		System.out.println("count result: " + messages.size());
		MessagesModel messagesModel = new MessagesModel();
		messagesModel.setMessages(messages);
		return messagesModel;
	}

	public MessageDao getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

}
