package com.firm.investment.interest.service;

import java.util.List;

import com.firm.investment.base.service.IBaseService;
import com.firm.investment.interest.entity.InterestEntity;
import com.firm.investment.interest.vo.InterestVO;

public interface IInterestService extends IBaseService<InterestEntity, InterestVO>{
	List<InterestVO> queryInterestByUserId(String userId) throws Exception;
}
