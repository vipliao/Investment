package com.firm.investment.message.service;

import java.util.List;

import com.firm.investment.base.service.IBaseService;
import com.firm.investment.message.entity.MessageEntity;
import com.firm.investment.message.vo.MessageVO;

public interface IMessageService extends IBaseService<MessageEntity, MessageVO>{
	
	List<MessageVO> queryMessageByUserId(String userId) throws Exception;

}
