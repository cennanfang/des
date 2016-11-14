package com.redbird.wehelp.dao;

import org.springframework.stereotype.Repository;

import com.redbird.wehelp.pojo.Message;
import com.redbird.wehelp.utils.MessagesModel;

@Repository
public interface MessageDao extends BaseDao<Message>{
	//TODO 没有在xml文件中实现，先去改变实体了
	public MessagesModel loadMsgs(int startMsgId);
}