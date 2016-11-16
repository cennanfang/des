package com.redbird.wehelp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.redbird.wehelp.pojo.Message;

@Repository
public interface MessageDao extends BaseDao<Message>{
	/**
	 * 加载信息
	 * @param startMsgId
	 * @return
	 */
	public List<Message> loadMesgs(@Param("startMsgId") int startMsgId,
								  @Param("pageSize") int pageSize);
	
	public List<Message> listMesgs();
}