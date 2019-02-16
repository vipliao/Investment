package com.firm.investment.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.firm.investment.base.dao.BaseDao;
import com.firm.investment.project.entity.ProjectMothReportEntity;

public interface ProjectMothReportDao extends BaseDao<ProjectMothReportEntity>{
	
	@Query(value="select * from t_project_tbale_moth_report where taskpro_id = :taskproId",nativeQuery=true)
	List<ProjectMothReportEntity> findbyTaskProId(@Param("taskproId") String taskProId);
	
	@Query(value="select * from t_project_tbale_moth_report where taskpro_id = :taskproId and year =:year",nativeQuery=true)
	List<ProjectMothReportEntity> findbyTaskProIdAndYear(@Param("taskproId") String taskProId,@Param("year") String year);
	
	@Query(value="select * from t_project_tbale_moth_report where taskpro_id = :taskproId and moth =:moth",nativeQuery=true)
	List<ProjectMothReportEntity> findbyTaskProIdAndMoth(@Param("taskproId") String taskProId,@Param("moth")String moth);

	@Query(value="select * from t_project_tbale_moth_report where taskpro_id = :taskproId and moth =:moth and year =:year",nativeQuery=true)
	List<ProjectMothReportEntity> findbyTaskProIdAndYearAndMoth(@Param("taskproId") String taskProId,@Param("year") String year,@Param("moth")String moth);
	
	@Query(value="select * from t_project_tbale_moth_report where  taskpro_id = (select taskpro_id from t_31_project_detail where id=:projectId )",nativeQuery=true)
	List<ProjectMothReportEntity> findbyProjectId(@Param("projectId") String projectId);
	
	@Query(value="select * from t_project_tbale_moth_report where  year =:year and taskpro_id = (select task_pro from t_31_project_detail where id=:projectId )",nativeQuery=true)
	List<ProjectMothReportEntity> findbyProjectIdAndYear(@Param("projectId") String projectId,@Param("year") String year);
	
	@Query(value="select * from t_project_tbale_moth_report where  moth =:moth and taskpro_id = (select task_pro from t_31_project_detail where id=:projectId )",nativeQuery=true)
	List<ProjectMothReportEntity> findbyProjectIdAndMoth(@Param("projectId") String projectId,@Param("moth")String moth);

	@Query(value="select * from t_project_tbale_moth_report where moth =:moth and year =:year and taskpro_id = (select task_pro from t_31_project_detail where id=:projectId )",nativeQuery=true)
	List<ProjectMothReportEntity> findbyProjectIdAndYearAndMoth(@Param("projectId") String projectId,@Param("year") String year,@Param("moth")String moth);
}
