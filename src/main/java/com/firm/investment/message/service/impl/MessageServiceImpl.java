package com.firm.investment.message.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firm.investment.base.service.impl.BaseServiceImpl;
import com.firm.investment.message.dao.MessageDao;
import com.firm.investment.message.entity.MessageEntity;
import com.firm.investment.message.service.IMessageService;
import com.firm.investment.message.vo.MessageVO;

@Service
public class MessageServiceImpl extends BaseServiceImpl<MessageEntity, MessageVO> implements IMessageService{


	@Autowired
	private MessageDao dao;
	@Override
	public List<MessageVO> queryMessageByUserId(String userId) throws Exception {
		List<MessageVO> reVos = new ArrayList<MessageVO>();
		List<MessageEntity> ens =  dao.findByUserId(userId);
		if(ens !=null && ens.size()>0){
			for(MessageEntity en:ens){
				MessageVO vo = new MessageVO();
				BeanUtils.copyProperties(en, vo);
				reVos.add(vo);
			}
		}
		return reVos;
	}

}
