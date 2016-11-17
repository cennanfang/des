package com.redbird.wehelp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.redbird.wehelp.pojo.Message;

@Repository
public interface MessageDao extends BaseDao<Message>{
	/**
	 * 加载信息startMsgId之后的信息
	 * @param startMsgId
	 * @return
	 */
	public List<Message> loadMesgsAfter(@Param("startMsgId") int startMsgId,
								  @Param("pageSize") int pageSize);
	/**
	 * 加载信息startMsgId之前的信息
	 * @param startMsgId
	 * @return
	 */
	public List<Message> loadMesgsBefore(@Param("startMsgId") int startMsgId,
			@Param("pageSize") int pageSize);
}