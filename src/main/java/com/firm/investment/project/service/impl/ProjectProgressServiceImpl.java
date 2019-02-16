package com.firm.investment.project.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firm.investment.assessory.vo.AssessoryVO;
import com.firm.investment.base.dao.BaseQueryDao;
import com.firm.investment.base.service.impl.BaseServiceImpl;
import com.firm.investment.project.entity.ProjectProgressEntity;
import com.firm.investment.project.service.IProjectProgressService;
import com.firm.investment.project.vo.ProjectProgressVO;

@Service
public class ProjectProgressServiceImpl extends BaseServiceImpl<ProjectProgressEntity, ProjectProgressVO> implements IProjectProgressService{

	@Autowired
	private BaseQueryDao queryDao;

	@Override
	public List<ProjectProgressVO> queryPjtProgressByPjtId(String projectId) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("select id,content,feed_bake_id feedBakeId,"
				+ " task_step_id taskStepId,title,user_id userId,"
				+ " username,task_pro_id taskProId "
				+ " from t_31_panle_pro_progress "
				+ " where task_pro_id =(select task_pro from t_31_project_detail where id='"+projectId+"')");
		
		Map<String,Object> params = new HashMap<>();
		List<ProjectProgressVO> vos= queryDao.findListBySql(sql.toString(), params, ProjectProgressVO.class);
		vos = queryPjtProgressAssessory(vos);
		return vos;
	}

	@Override
	public List<ProjectProgressVO> queryPjtProgressByStepId(String stepId) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("select id,content,feed_bake_id feedBakeId,"
				+ " task_step_id taskStepId,title,user_id userId,"
				+ " username,task_pro_id taskProId "
				+ " from t_31_panle_pro_progress " 
				+ " where "
				+ " (task_step_id in (SELECT id FROM t_panel_event_full_calendar WHERE step_id ='"+ stepId + "'))"
						+ " or"
						+ " (task_step_id = '"+stepId+"')");
		
		Map<String, Object> params = new HashMap<>();
		List<ProjectProgressVO> vos = queryDao.findListBySql(sb.toString(), params, ProjectProgressVO.class);
	
		vos = queryPjtProgressAssessory(vos);
		return vos;
	}

	@Override
	@Transactional
	public ProjectProgressVO save(ProjectProgressVO vo, Class<ProjectProgressEntity> clazzE,
			Class<ProjectProgressVO> clazzV) throws Exception {
		ProjectProgressVO reVo = super.save(vo, clazzE, clazzV);
		if (vo.getAssessorys() != null && vo.getAssessorys().size() > 0) {
			StringBuffer sql = new StringBuffer("insert into t_31_panle_progress_annex values ");
			int length = vo.getAssessorys().size();
			for (int i = 0; i < length; i++) {
				if (i < length - 1) {
					sql.append(" ('" + reVo.getId() + "','" + vo.getAssessorys().get(i).getId() + "'),");
				} else {
					sql.append(" ('" + reVo.getId() + "','" + vo.getAssessorys().get(i).getId() + "') ");
				}
			}
			queryDao.executeUpdateSQL(sql.toString());
		}
		reVo.setAssessorys(vo.getAssessorys());
		return reVo;
	}
	
	private List<ProjectProgressVO> queryPjtProgressAssessory(List<ProjectProgressVO> vos){
		if(vos == null || vos.size()<=0){
			return null;
		}
		List<String> ids = new ArrayList<>();
		for(ProjectProgressVO vo : vos){
			ids.add(vo.getId());
		}
		String sql ="SELECT version.id id,version.name name,version.path path,"
				+ " version.create_time createTime,progress.id businessId"
				+ " FROM t_doc_document_version version"
				+ " left join t_panel_annex annex on version.id = annex.version_id"
				+ " left JOIN t_31_panle_progress_annex progressannex on progressannex.annex_id= annex.id"
				+ " LEFT JOIN t_31_panle_pro_progress progress on progress.id = progressannex.progress_id "
				+ " where progress.id in (:ids)";
		Map<String,Object> map = new HashMap<>();
		map.put("ids", ids);
		List<AssessoryVO> assessoryVOs = queryDao.findListBySql(sql, map, AssessoryVO.class);
		if(assessoryVOs !=null && assessoryVOs.size()>0){
			for(ProjectProgressVO vo : vos){
				List<AssessoryVO> iAssessoryVOs = new ArrayList<>();
				for(AssessoryVO assessoryVO :assessoryVOs){
					if(assessoryVO.getBusinessId() != null && assessoryVO.getBusinessId().equals(vo.getId())){
						assessoryVO.setUrl("/project/download?fileName="+assessoryVO.getName());
						iAssessoryVOs.add(assessoryVO);
					}
				}
				if(iAssessoryVOs !=null && iAssessoryVOs.size()>0){
					vo.setAssessorys(iAssessoryVOs);
				}
			}
		}else{
			String sql1 ="SELECT version.id id,version.name name,version.path path,"
					+ " version.create_time createTime,progress.id businessId"
					+ " FROM t_doc_document_version version"
					+ " left JOIN t_31_panle_progress_annex progressannex on progressannex.annex_id= version.id"
					+ " LEFT JOIN t_31_panle_pro_progress progress on progress.id = progressannex.progress_id "
					+ " where progress.id in (:ids)";
			List<AssessoryVO> assessoryVOs1 = queryDao.findListBySql(sql1, map, AssessoryVO.class);
			if(assessoryVOs1 !=null && assessoryVOs1.size()>0){
				for(ProjectProgressVO vo : vos){
					List<AssessoryVO> iAssessoryVOs = new ArrayList<>();
					for(AssessoryVO assessoryVO :assessoryVOs1){
						if(assessoryVO.getBusinessId() != null && assessoryVO.getBusinessId().equals(vo.getId())){
							assessoryVO.setUrl("/project/download?fileName="+assessoryVO.getName());
							iAssessoryVOs.add(assessoryVO);
						}
					}
					if(iAssessoryVOs !=null && iAssessoryVOs.size()>0){
						vo.setAssessorys(iAssessoryVOs);
					}
				}
			}
		}
		return vos;
	} 
	

}
