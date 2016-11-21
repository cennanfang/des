package com.redbird.wehelp.dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.redbird.wehelp.pojo.Message;

@Repository
public interface MessageDao extends BaseDao<Message>{
	/**
	 * 加载信息
	 * @param markPublishedDate 最新的信息记录发布时间
	 * @param pageSize 查询的数据条数
	 * @return
	 */
	public List<Message> loadMesgsAfter(
							@Param("markPublishedDate") Timestamp markPublishedDate,
							@Param("pageSize") int pageSize);
	/**
	 * 加载信息
	 * @param maxPublishedDate 最新的信息发布时间
	 * @param minPublishedDate 在这个时间之后的信息发布时间
	 * @return
	 */
	public List<Message> loadMesgsBefore(
							@Param("maxPublishedDate") Timestamp maxPublishedDate,
							@Param("minPublishedDate") Timestamp minPublishedDate,
							@Param("pageSize") int pageSize);
}