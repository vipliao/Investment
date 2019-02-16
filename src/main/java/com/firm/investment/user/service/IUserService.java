package com.firm.investment.user.service;

import java.util.List;

import com.firm.investment.base.service.IBaseService;
import com.firm.investment.user.entity.UserEntity;
import com.firm.investment.user.vo.UserVO;

public interface IUserService extends IBaseService<UserEntity,UserVO>{
	
	UserVO register(UserVO vo,int type) throws Exception;
	
	UserVO login(UserVO vo) throws Exception;
	
	UserVO queryUserByPhone(String Phone) throws Exception;
	
	void deleteByPhone(String Phone) throws Exception;
	
	List<UserVO> queryUsersByType(int type) throws Exception;

}
