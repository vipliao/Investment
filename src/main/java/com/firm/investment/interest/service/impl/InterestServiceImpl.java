package com.firm.investment.interest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firm.investment.base.service.impl.BaseServiceImpl;
import com.firm.investment.interest.dao.InterestDao;
import com.firm.investment.interest.entity.InterestEntity;
import com.firm.investment.interest.service.IInterestService;
import com.firm.investment.interest.vo.InterestVO;

@Service
public class InterestServiceImpl extends BaseServiceImpl<InterestEntity, InterestVO>implements IInterestService{
	
	@Autowired
	private InterestDao dao;
	@Override
	public List<InterestVO> queryInterestByUserId(String userId) throws Exception {
		List<InterestVO> reVos = new ArrayList<InterestVO>();
		List<InterestEntity> ens =  dao.findByUserId(userId);
		if(ens !=null && ens.size()>0){
			for(InterestEntity en:ens){
				InterestVO vo = new InterestVO();
				BeanUtils.copyProperties(en, vo);
				reVos.add(vo);
			}
		}
		return reVos;
	}

}
