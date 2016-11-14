package com.redbird.wehelp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redbird.wehelp.dao.MessageDao;
import com.redbird.wehelp.service.MessageService;
import com.redbird.wehelp.utils.MessagesModel;

@Service
public class MessageServiceImpl implements MessageService{
	
	@Autowired
	private MessageDao messageDao;

	@Override
	public MessagesModel load(int startMsgId) {
		return messageDao.loadMsgs(startMsgId);
	}

	@Override
	public MessagesModel loadbefore() {
		// TODO Auto-generated method stub
		return null;
	}

	public MessageDao getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

}
