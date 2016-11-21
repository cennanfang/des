package com.redbird.wehelp.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redbird.wehelp.dao.MessageDao;
import com.redbird.wehelp.pojo.Message;
import com.redbird.wehelp.service.MessageService;
import com.redbird.wehelp.utils.MessagesModel;

@Service
public class MessageServiceImpl implements MessageService{
	
	@Autowired
	private MessageDao messageDao;
	
	@Override
	public MessagesModel refreshMessage(Timestamp startMsgId, int pageSize) {
		List<Message> messages = messageDao.loadMesgsAfter(startMsgId, pageSize);
		MessagesModel messagesModel = null;
		if(messages != null) {
			messagesModel = new MessagesModel();
			// 装载数据
			messagesModel.setMessages(messages);
			// 记录最新一条数据的Id
			messagesModel.setCurrentMesgsPoint(messages.get(0).getId());
		}
		return messagesModel;
	}


	@Override
	public MessagesModel loadMessage(Timestamp markPublishedDate, Timestamp limitPublishedDate, int pageSize) {
		// TODO loadMessage
		return null;
	}

	public MessageDao getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}
}
