package com.firm.investment.message.comtroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.firm.investment.base.uitls.JsonBackData;
import com.firm.investment.message.entity.MessageEntity;
import com.firm.investment.message.service.IMessageService;
import com.firm.investment.message.vo.MessageVO;

@Controller
@RequestMapping(value = "message")
public class MessageController {

	private static Logger logger = LoggerFactory.getLogger(MessageController.class);
	@Autowired
	private IMessageService service;
	
	
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonBackData save(@RequestBody MessageVO vo) {
		JsonBackData back = new JsonBackData();
		try {
				MessageVO reVo = service.save(vo, MessageEntity.class, MessageVO.class);
				back.setBackData(JSON.toJSON(reVo).toString());
				back.setSuccess(true);
				back.setBackMsg("保存成功！");
			
		}catch (Exception e) {
			logger.error("消息保存方法：", e);
			back.setSuccess(false);
			back.setBackMsg("保存失败,"+e.getMessage());
		}
		return back;
	}
	
	@RequestMapping(value = "queryList")
	@ResponseBody
	public JsonBackData queryList(@RequestParam String userId) {
		JsonBackData back = new JsonBackData();
		try {
				List<MessageVO> reVo = service.queryMessageByUserId(userId);
				back.setBackData(JSON.toJSON(reVo).toString());
				back.setSuccess(true);
				back.setBackMsg("查询成功！");
			
		}catch (Exception e) {
			logger.error("消息查询方法：", e);
			back.setSuccess(false);
			back.setBackMsg("查询成功,"+e.getMessage());
		}
		return back;
	}
}
