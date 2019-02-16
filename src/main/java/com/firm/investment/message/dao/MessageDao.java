package com.firm.investment.message.dao;

import java.util.List;

import com.firm.investment.base.dao.BaseDao;
import com.firm.investment.message.entity.MessageEntity;

public interface MessageDao extends BaseDao<MessageEntity>{
	
	List<MessageEntity> findByUserId(String userId);

}
