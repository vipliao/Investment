package com.firm.investment.project.service;

import java.util.List;

import com.firm.investment.base.service.IBaseService;
import com.firm.investment.project.entity.ProjectProgressEntity;
import com.firm.investment.project.vo.ProjectProgressVO;

public interface IProjectProgressService extends IBaseService<ProjectProgressEntity, ProjectProgressVO>{

	List<ProjectProgressVO> queryPjtProgressByPjtId(String projectId) throws Exception;
	List<ProjectProgressVO> queryPjtProgressByStepId(String stepId) throws Exception;
	
	
}
