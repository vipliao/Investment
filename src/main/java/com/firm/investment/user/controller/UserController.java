package com.firm.investment.user.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.firm.investment.base.uitls.JsonBackData;
import com.firm.investment.user.service.IUserService;
import com.firm.investment.user.vo.UserVO;

@Controller
@RequestMapping(value = "user")
public class UserController {
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private IUserService service;
	
	
	@RequestMapping(value = "register",method = RequestMethod.POST)
	@ResponseBody
	public JsonBackData register(@RequestBody UserVO vo) {
		JsonBackData back = new JsonBackData();
		try {

			UserVO userVO = service.register(vo, 1);
			back.setBackData(JSON.toJSON(userVO).toString());
			back.setSuccess(true);
			back.setBackMsg("注册成功！");

		} catch (Exception e) {
			logger.error("用户注册方法：", e);
			back.setSuccess(false);
			back.setBackMsg("注册失败," + e.getMessage());
		}
		return back;
	}
	
	@RequestMapping(value = "userList")
	@ResponseBody
	public JsonBackData userList() {
		JsonBackData back = new JsonBackData();
		try {
				List<UserVO> userVO = service.queryUsersByType(1);
				back.setBackData(JSON.toJSON(userVO).toString());
				back.setSuccess(true);
				back.setBackMsg("查询已注册用户信息成功！");
			
		}catch (Exception e) {
			logger.error("查询已注册用户信息方法：", e);
			back.setSuccess(false);
			back.setBackMsg("查询已注册用户信息失败,"+e.getMessage());
		}
		return back;
	}
	
	@RequestMapping(value = "allUserList")
	@ResponseBody
	public JsonBackData allUserList() {
		JsonBackData back = new JsonBackData();
		try {
				List<UserVO> userVO = service.findAll(UserVO.class);
				back.setBackData(JSON.toJSON(userVO).toString());
				back.setSuccess(true);
				back.setBackMsg("查询所有用户信息成功！");
			
		}catch (Exception e) {
			logger.error("查询所有用户信息方法：", e);
			back.setSuccess(false);
			back.setBackMsg("查询所有用户信息失败,"+e.getMessage());
		}
		return back;
	}
	
	@RequestMapping(value = "preUserList")
	@ResponseBody
	public JsonBackData preUserList() {
		JsonBackData back = new JsonBackData();
		try {
				List<UserVO> userVO = service.queryUsersByType(0);
				back.setBackData(JSON.toJSON(userVO).toString());
				back.setSuccess(true);
				back.setBackMsg("查询待注册用户信息成功！");
			
		}catch (Exception e) {
			logger.error("查询待注册用户信息方法：", e);
			back.setSuccess(false);
			back.setBackMsg("查询待注册用户信息失败,"+e.getMessage());
		}
		return back;
	}
	
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonBackData delete(@RequestBody Map<String,Object> param) {
		JsonBackData back = new JsonBackData();
		try {	
			if(param.containsKey("phone")){
				String phone = (String) param.get("phone");
				service.deleteByPhone(phone);
				back.setSuccess(true);
				back.setBackMsg("删除用户信息成功！");	
			}else{
				back.setSuccess(false);
				back.setBackMsg("删除用户信息失败,参数缺少phone");
			}
				
		}catch (Exception e) {
			logger.error("删除用户信息方法：", e);
			back.setSuccess(false);
			back.setBackMsg("删除用户信息失败,"+e.getMessage());
		}
		return back;
	}
	
	@RequestMapping(value = "queryUser")
	@ResponseBody
	public JsonBackData queryUser(@RequestParam String phone) {
		JsonBackData back = new JsonBackData();
		try {
				UserVO userVO = service.queryUserByPhone(phone);
				back.setBackData(JSON.toJSON(userVO).toString());
				back.setSuccess(true);
				back.setBackMsg("根据用户名查询用户信息成功！");
			
		}catch (Exception e) {
			logger.error("根据用户名查询用户信息方法：", e);
			back.setSuccess(false);
			back.setBackMsg("根据用户名查询用户信息失败,"+e.getMessage());
		}
		return back;
	}
	
	@RequestMapping(value = "login")
	@ResponseBody
	public JsonBackData login(@RequestParam String phone,@RequestParam String password) {
		JsonBackData back = new JsonBackData();
		try {
				UserVO vo =new UserVO();
				vo.setPhone(phone);
				vo.setPassword(password);
				UserVO userVO = service.login(vo);
				back.setBackData(JSON.toJSON(userVO).toString());
				back.setSuccess(true);
				back.setBackMsg("登录成功！");
			
		}catch (Exception e) {
			logger.error("用户登录方法：", e);
			back.setSuccess(false);
			back.setBackMsg("登录失败,"+e.getMessage());
		}
		return back;
	}
	@RequestMapping(value = "preRegister")
	@ResponseBody
	public JsonBackData preRegister(@RequestBody UserVO vo) {
		JsonBackData back = new JsonBackData();
		try {

			UserVO userVO = service.register(vo, 0);
			back.setBackData(JSON.toJSON(userVO).toString());
			back.setSuccess(true);
			back.setBackMsg("待注册成功！");			
		} catch (Exception e) {
			logger.error("用户注册方法：", e);
			back.setSuccess(false);
			back.setBackMsg("注册失败," + e.getMessage());
		}
		return back;
	}
}
