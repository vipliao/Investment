package com.firm.investment.project.service;

import java.util.List;

import com.firm.investment.base.service.IBaseService;
import com.firm.investment.project.entity.ProjectFlowStepEntity;
import com.firm.investment.project.vo.ProjectFlowStepVO;

public interface IProjectFlowStepService extends IBaseService<ProjectFlowStepEntity, ProjectFlowStepVO>{
	List<ProjectFlowStepVO> queryByProjectId(String projectId) throws Exception;
	ProjectFlowStepVO saveProjectFlowStepWithProjectId(ProjectFlowStepVO vo) throws Exception;
}
