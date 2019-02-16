package com.firm.investment.project.service;

import java.util.List;
import java.util.Map;

import com.firm.investment.base.service.IBaseService;
import com.firm.investment.project.entity.ProjectEntity;
import com.firm.investment.project.vo.AreaVO;
import com.firm.investment.project.vo.InvestMoneyAndRateVO;
import com.firm.investment.project.vo.ProjectVO;

public interface IProjectService extends IBaseService<ProjectEntity, ProjectVO>{

	 List<ProjectVO> findAssessUnitProjectList(String assessUnitId,int level) throws Exception;
	 List<AreaVO> findAssessUnitProjectArea()throws Exception;
	 void updateProjectState(String id,int actionType) throws Exception;
	 List<ProjectVO> queryInterestPjtIdByUserId(String userId) throws Exception;
	InvestMoneyAndRateVO queryInvestMoneyAndRate() throws Exception;
	List<ProjectVO> queryProjectList(Map<String,Object> map) throws Exception;
	List<ProjectVO> findAssessUnitPrjsByName(String name) throws Exception;
}
