package com.firm.investment.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.firm.investment.base.dao.BaseDao;
import com.firm.investment.project.entity.ProjectProgressEntity;

public interface ProjectProgressDao extends BaseDao<ProjectProgressEntity>{
	
	@Query(value="select * from t_31_panle_pro_progress where task_step_id =:taskId",nativeQuery = true)
	List<ProjectProgressEntity> findBytaskStepId(String taskId);

}
