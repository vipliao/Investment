package com.firm.investment.project.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firm.investment.base.dao.BaseQueryDao;
import com.firm.investment.base.service.impl.BaseServiceImpl;
import com.firm.investment.project.entity.EventFullCalendarEntity;
import com.firm.investment.project.entity.ProjectFlowStepEntity;
import com.firm.investment.project.service.IProjectFlowStepService;
import com.firm.investment.project.vo.EventFullCalendarVO;
import com.firm.investment.project.vo.ProjectFlowStepVO;

@Service
public class ProjectFlowStepServiceImpl extends BaseServiceImpl<ProjectFlowStepEntity, ProjectFlowStepVO> implements IProjectFlowStepService{

	@Autowired
	private BaseQueryDao queryDao;
	
	@Override
	public List<ProjectFlowStepVO> queryByProjectId(String projectId) {
		List<ProjectFlowStepVO> steps = null;
		StringBuffer sb = new StringBuffer();
		sb.append("select distinct step.name,step.sort,step.task_pro_id taskProId,step.create_time createTime,step.update_time updateTime,step.id,"
				+ " calendar.start_time startTime"
				+ " from t_panel_config_task_step step"
				+ " left join t_panel_event_full_calendar calendar"
				+ " on step.id = calendar.step_id where ");
		sb.append("(step.task_pro_id =("
				+ " select id from t_panel_task_pro"
				+ " where id=(select task_pro taskPro from t_31_project_detail where id='"+projectId+"')))");
		sb.append(" or ");
		sb.append(" (step.task_pro_id =(select task_pro taskPro from t_31_project_detail where id='"+projectId+"'))");
		
		/*String sql ="select step.name,step.sort,step.task_pro_id taskProId,step.create_time createTime,step.update_time updateTime,step.id,"
				+ " calendar.start_time startTime"
				+ " from t_panel_config_task_step step"
				+ " left join t_panel_event_full_calendar calendar"
				+ " on step.id = calendar.step_id"
				+ " where step.task_pro_id =("
					+ " select id from t_panel_task_pro"
						+ " where id=(select task_pro taskPro from t_31_project_detail where id='"+projectId+"'))"
								+ " order by sort desc";
*/
		Map<String,Object> params=new HashMap<>();
		steps = queryDao.findListBySql(sb.toString(), params, ProjectFlowStepVO.class);
		/*if(steps == null || steps.size()<=0){
			String sql1 = "select step.name,step.sort,step.task_pro_id taskProId,step.create_time createTime,step.update_time updateTime,step.id,"
					+ " calendar.start_time startTime"
					+ " from t_panel_config_task_step step"
					+ " left join t_panel_event_full_calendar calendar"
					+ " on step.id = calendar.step_id"
				+ " where step.task_pro_id =(select task_pro taskPro from t_31_project_detail where id='"+projectId+"')"
								+ " order by sort desc";
			Map<String,Object> params1=new HashMap<>();
			steps = queryDao.findListBySql(sql1, params1, ProjectFlowStepVO.class);
		}*/
		return steps;
	}

	@Override
	public ProjectFlowStepVO saveProjectFlowStepWithProjectId(ProjectFlowStepVO vo) throws Exception {
		List<ProjectFlowStepVO> steps = null;
		String sql =" select taskProTab.id taskProId,project.id projectId from t_panel_task_pro taskProTab "
				+ " inner join t_31_project_detail project on taskProTab.id= project.task_pro"
						+ " where project.id='"+vo.getProjectId()+"'";
		Map<String,Object> params=new HashMap<>();
		steps = queryDao.findListBySql(sql, params, ProjectFlowStepVO.class);
		if(steps !=null && steps.size()>0){
			vo.setTaskProId(steps.get(0).getTaskProId());
			vo.setProjectId(vo.getProjectId());
			List<EventFullCalendarVO> enentFullCalendars = new ArrayList<>();
			EventFullCalendarVO enentFullCalendar = new EventFullCalendarVO();
			enentFullCalendar.setOder(new BigDecimal(0));
			enentFullCalendar.setProjId(steps.get(0).getProjectId());
			enentFullCalendar.setCreateTime(new Timestamp(System.currentTimeMillis()));
			if(vo.getStartTime()!=null && !vo.getStartTime().equals("")){
				enentFullCalendar.setStartTime(vo.getStartTime());
			}else{
				enentFullCalendar.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			}
			enentFullCalendars.add(enentFullCalendar);
			vo.setEventFullCalendars(enentFullCalendars);
		}else{
			String sql1 ="select task_pro taskProId,id from t_31_project_detail where id='"+vo.getProjectId()+"'";
			Map<String,Object> params1=new HashMap<>();
			steps = queryDao.findListBySql(sql1, params1, ProjectFlowStepVO.class);
			if(steps !=null && steps.size()>0){
				vo.setTaskProId(steps.get(0).getTaskProId());
				vo.setProjectId(vo.getProjectId());
				List<EventFullCalendarVO> enentFullCalendars = new ArrayList<>();
				EventFullCalendarVO enentFullCalendar = new EventFullCalendarVO();
				enentFullCalendar.setOder(new BigDecimal(0));
				enentFullCalendar.setProjId(steps.get(0).getId());
				enentFullCalendar.setCreateTime(new Timestamp(System.currentTimeMillis()));
				enentFullCalendars.add(enentFullCalendar);
				vo.setEventFullCalendars(enentFullCalendars);
			}
		}
		ProjectFlowStepVO reVO = save(vo, ProjectFlowStepEntity.class, ProjectFlowStepVO.class);
		reVO.setProjectId(vo.getProjectId());
		reVO.setEventFullCalendars(null);
		return reVO;
	} 
	
	@Override
	protected ProjectFlowStepEntity beforeSave(ProjectFlowStepVO vo, Class<ProjectFlowStepEntity> clazzE, Class<ProjectFlowStepVO> clazzV)
			throws Exception {
		ProjectFlowStepEntity entity = new ProjectFlowStepEntity();
		BeanUtils.copyProperties(vo, entity);
		List<EventFullCalendarVO> childVOs = new ArrayList<EventFullCalendarVO>(vo.getEventFullCalendars());
		List<EventFullCalendarEntity> childEntitys = new ArrayList<EventFullCalendarEntity>();
		for (EventFullCalendarVO childDetailVO : childVOs) {
			EventFullCalendarEntity childEntity = new EventFullCalendarEntity();
			BeanUtils.copyProperties(childDetailVO, childEntity);
			childEntity.setParent(entity);
			childEntitys.add(childEntity);
			
		}
		entity.setEventFullCalendars(childEntitys);
		return entity;
	}
	@Override
	protected ProjectFlowStepVO afterSave(ProjectFlowStepEntity entity, Class<ProjectFlowStepEntity> clazzE, Class<ProjectFlowStepVO> clazzV)
			throws Exception {
		ProjectFlowStepVO vo = new ProjectFlowStepVO();
		BeanUtils.copyProperties(entity, vo);
		List<EventFullCalendarVO> childVOs = new ArrayList<EventFullCalendarVO>();
		List<EventFullCalendarEntity> childEntitys = new ArrayList<EventFullCalendarEntity>(entity.getEventFullCalendars());
		for (EventFullCalendarEntity childEntity : childEntitys) {
			EventFullCalendarVO childVO= new EventFullCalendarVO();
			BeanUtils.copyProperties(childEntity, childVO);
			childVO.setParent(vo);
			childVOs.add(childVO);	
		}
		vo.setEventFullCalendars(childVOs);
		return vo;
	}
	
	

}
