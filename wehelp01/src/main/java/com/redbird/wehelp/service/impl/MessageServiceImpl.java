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
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageDao messageDao;

	@Override
	public MessagesModel refreshMessage(Timestamp markPublishedDate, int pageSize) {
		List<Message> messages = messageDao.loadMesgsAfter(markPublishedDate, pageSize);
		MessagesModel messagesModel = null;
		if (messages != null && !messages.isEmpty()) {
			messagesModel = new MessagesModel();
			// 装载数据
			messagesModel.setMessages(messages);
			// 记录最新一条数据
			messagesModel.setMarkPublishedDate(messages.get(0).getPublishedDate());
		}
		return messagesModel;
	}

	@Override
	public MessagesModel loadMessage(Timestamp maxPublishedDate, Timestamp minPublishedDate, int pageSize) {
		List<Message> messages = messageDao.loadMesgsBefore(maxPublishedDate, minPublishedDate, pageSize);
		MessagesModel messagesModel = null;
		if (messages != null && !messages.isEmpty()) {
			messagesModel = new MessagesModel();
			// 装载数据
			messagesModel.setMessages(messages);
			// 记录
			messagesModel.setMarkPublishedDate(messages.get(messages.size() - 1).getPublishedDate());
		}
		return messagesModel;
	}

	public MessageDao getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}
}
