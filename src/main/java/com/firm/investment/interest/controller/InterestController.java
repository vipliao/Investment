package com.firm.investment.interest.controller;

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
import com.firm.investment.interest.entity.InterestEntity;
import com.firm.investment.interest.service.IInterestService;
import com.firm.investment.interest.vo.InterestVO;

@Controller
@RequestMapping(value = "interest")
public class InterestController {

	private static Logger logger = LoggerFactory.getLogger(InterestController.class);
	@Autowired
	private IInterestService service;
	
	
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonBackData save(@RequestBody InterestVO vo) {
		JsonBackData back = new JsonBackData();
		try {
				InterestVO reVo = service.save(vo, InterestEntity.class, InterestVO.class);
				back.setBackData(JSON.toJSON(reVo).toString());
				back.setSuccess(true);
				back.setBackMsg("保存成功！");
			
		}catch (Exception e) {
			logger.error("关注保存方法：", e);
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
				List<InterestVO> reVo = service.queryInterestByUserId(userId);
				back.setBackData(JSON.toJSON(reVo).toString());
				back.setSuccess(true);
				back.setBackMsg("查询成功！");
			
		}catch (Exception e) {
			logger.error("关注查询方法：", e);
			back.setSuccess(false);
			back.setBackMsg("关注查询成功,"+e.getMessage());
		}
		return back;
	}
	
}
