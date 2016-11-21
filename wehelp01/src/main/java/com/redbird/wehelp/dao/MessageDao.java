package com.redbird.wehelp.dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.redbird.wehelp.pojo.Message;

@Repository
public interface MessageDao extends BaseDao<Message>{
	/**
	 * 加载信息startMsgId之后的信息
	 * @param markPublishedDate 最新的信息记录发布时间
	 * @param pageSize 查询的数据条数
	 * @return
	 */
	public List<Message> loadMesgsAfter(
							@Param("markPublishedDate") Timestamp markPublishedDate,
							@Param("pageSize") int pageSize);
	/**
	 * 加载信息startMsgId之前的信息
	 * @param markPublishedDate 最大的信息发布时间
	 * @param limitPublishedDate 最新的信息发布时间
	 * @return
	 */
	public List<Message> loadMesgsBefore(
							@Param("markPublishedDate") Timestamp markPublishedDate,
							@Param("limitPublishedDate") Timestamp limitPublishedDate,
							@Param("pageSize") int pageSize);
}