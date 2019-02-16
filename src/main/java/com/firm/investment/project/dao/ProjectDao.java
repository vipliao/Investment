package com.firm.investment.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.firm.investment.base.dao.BaseDao;
import com.firm.investment.project.entity.ProjectEntity;

public interface ProjectDao extends BaseDao<ProjectEntity>{

	@Query(value = "Select * from t_31_project_detail where id in (select T_31_PROJECT_DETAIL from T_31_PROJECT_DETAIL_AREAS where AREAS = ?1)  and supervisory_level=(select id from t_31_data_dic where name = ?2)", nativeQuery = true)
	List<ProjectEntity> findAssessUnitProjectList(String assessUnitId,String levelName);
	
	@Query(value="select * from t_31_project_detail where id in (?1)",nativeQuery = true)
	List<ProjectEntity> findbyIds(List<String> ids);
	
	@Query(value="select * from t_31_project_detail where project_name like :likeName ", nativeQuery=true)
	List<ProjectEntity> findListbyLikeName(@Param("likeName") String likeName);
}
