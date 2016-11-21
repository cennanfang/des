package com.redbird.wehelp.service;

import java.sql.Timestamp;

import com.redbird.wehelp.utils.MessagesModel;

/**
 * 信息管理类
 * 
 * 用户下拉刷新：
 * 1、用户传入参数：用户查看过最新一条记录的ID=startMsgId
 * 2、message表查询ID大于userMsgID的数据
 *   a、是大于等于指定条数（默认15条） ---> 返回 指定条数（默认15条）
 *   b、否则，返回全部
 * 用户上拉加载：
 * （这里涉及到一个问题，本地存储的数据，最新的一条ID是多少；用户已经加载的信息最旧的一条信息是多少）
 * 更重要的问题是加载策略的问题，有待确认
 * @author cennanfang
 *
 */
public interface MessageService {
	/**
	 * 更新信息列表，查看markPublishedDate之后是否有新的数据
	 * @param markPublishedDate 其实发布时间
	 * @param pageSize （最高）返回结果数据
	 * @return
	 */
	public MessagesModel refreshMessage(Timestamp markPublishedDate, int pageSize);
	
	/**
	 * 加载信息列表，maxPublishedDate和minPublishedDate的信息
	 * @param maxPublishedDate 最新时间
	 * @param minPublishedDate 最旧时间
	 * @param pageSize （最高）返回结果数据
	 * @return
	 */
	public MessagesModel loadMessage(Timestamp maxPublishedDate, 
									 Timestamp minPublishedDate, 
									 int pageSize);
}
