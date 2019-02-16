package com.firm.investment.project.service;

import java.util.List;
import java.util.Map;

import com.firm.investment.base.service.IBaseService;
import com.firm.investment.project.entity.ProjectMothReportEntity;
import com.firm.investment.project.vo.ProjectMothReportVO;

public interface IProjectMothReportService extends IBaseService<ProjectMothReportEntity, ProjectMothReportVO>{

	List<ProjectMothReportVO> queryPjtMothReport(Map<String,Object> map) throws Exception;

}
