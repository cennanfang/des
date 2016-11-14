package com.redbird.wehelp.service;

import org.springframework.stereotype.Service;

import com.redbird.wehelp.utils.MessagesModel;

/**
 * 信息管理类
 * 
 * 用户下拉刷新：
 * 1、用户传入参数：用户查看过最新一条记录的ID=userMsgId
 * 2、message表查询ID大于userMsgID的数据
 *   a、是大于等于指定条数（默认15条） ---> 返回 指定条数
 *   b、否则，返回全部
 * @author cennanfang
 *
 */
@Service
public interface MessageService {
	
	public MessagesModel load(int startMsgId);
	
	public MessagesModel loadbefore();
}
