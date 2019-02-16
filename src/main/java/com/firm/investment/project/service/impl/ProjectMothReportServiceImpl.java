package com.firm.investment.project.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firm.investment.base.dao.BaseQueryDao;
import com.firm.investment.base.service.impl.BaseServiceImpl;
import com.firm.investment.project.dao.ProjectMothReportDao;
import com.firm.investment.project.entity.ProjectMothReportEntity;
import com.firm.investment.project.service.IProjectMothReportService;
import com.firm.investment.project.vo.ProjectMothReportVO;

@Service
public class ProjectMothReportServiceImpl extends BaseServiceImpl< ProjectMothReportEntity, ProjectMothReportVO> implements IProjectMothReportService{

	@Autowired
	private ProjectMothReportDao dao;
	@Autowired
	private BaseQueryDao queryDao;
	
	@Override
	public List<ProjectMothReportVO> queryPjtMothReport(Map<String, Object> map) throws Exception {
		if(map == null){
			return null;
		}
		if(!map.containsKey("taskProId") && !map.containsKey("projectId")){
			return null;
		}
		List<ProjectMothReportEntity> ens  = new ArrayList<>();
		if(!map.containsKey("taskProId") && map.containsKey("projectId")){
			String projectId = (String) map.get("projectId");
			/*String sql = "select type,task_pro from t_31_project_detail where id= :projectId";
			Map<String,Object> param = new HashMap<>();
			param.put("projectId", projectId);
			List<ProjectVO> pjt =  queryDao.findListBySql(sql,param,ProjectVO.class);
			if(pjt !=null && pjt.size()>0){
				String taskProId = pjt.get(0).getTaskPro();
				BigDecimal type = pjt.get(0).getType();
				if(taskProId !=null && !taskProId.equals("")){
					if(type.compareTo(new BigDecimal(0)) ==0){
						
					}
				}
			}*/
			if(!map.containsKey("year") && !map.containsKey("moth")){
				ens = dao.findbyProjectId(projectId);
			}else if(map.containsKey("year") && !map.containsKey("moth")){
				String year = (String) map.get("year");
				ens = dao.findbyProjectIdAndYear(projectId, year);
			}else if(!map.containsKey("year") && map.containsKey("moth")){
				Calendar cal = Calendar.getInstance();
				String year = cal.get(Calendar.YEAR)+"";
				String moth = (String) map.get("moth");
				ens = dao.findbyProjectIdAndYearAndMoth(projectId, year, moth);
			}else if(map.containsKey("year") && map.containsKey("moth")){
				String year =(String) map.get("year");
				String moth = (String) map.get("moth");
				ens = dao.findbyProjectIdAndYearAndMoth(projectId, year, moth);
			}
		}
		if(map.containsKey("taskProId")){
			String taskProId = (String) map.get("taskProId");
			if(!map.containsKey("year") && !map.containsKey("moth")){
				ens = dao.findbyTaskProId(taskProId);
			}else if(map.containsKey("year") && !map.containsKey("moth")){
				String year = (String) map.get("year");
				ens = dao.findbyTaskProIdAndYear(taskProId, year);
			}else if(!map.containsKey("year") && map.containsKey("moth")){
				Calendar cal = Calendar.getInstance();
				String year = cal.get(Calendar.YEAR)+"";
				String moth = (String) map.get("moth");
				ens = dao.findbyTaskProIdAndYearAndMoth(taskProId, year, moth);
			}else if(map.containsKey("year") && map.containsKey("moth")){
				String year =(String) map.get("year");
				String moth = (String) map.get("moth");
				ens = dao.findbyTaskProIdAndYearAndMoth(taskProId, year, moth);
			}
		}
		if(ens !=null && ens.size()>0){
			List<ProjectMothReportVO> vos = new ArrayList<>();
			for(ProjectMothReportEntity en :ens){
				ProjectMothReportVO vo = new ProjectMothReportVO();
				BeanUtils.copyProperties(en, vo);
				vos.add(vo);
			}
			return vos;
		}
		
		return null;
	}
	
	@Override
	public ProjectMothReportVO save(ProjectMothReportVO vo, Class<ProjectMothReportEntity> clazzE,
			Class<ProjectMothReportVO> clazzV) throws Exception {
		if(vo ==null){
			throw new NullPointerException("传入的保存数据不能为空！");
		}
		if(vo.getYear() ==null || vo.getYear().equals("")){
			Calendar cal = Calendar.getInstance();
			String year = cal.get(Calendar.YEAR)+"";
			vo.setYear(year);
			if(vo.getMoth()== null || vo.getMoth().equals("")){
				String moth = cal.get(Calendar.MONTH )+1+"";
				vo.setMoth(moth);
			}
		}else{
			if(vo.getMoth()== null || vo.getMoth().equals("")){
				Calendar cal = Calendar.getInstance();
				String moth = cal.get(Calendar.MONTH )+1+"";
				vo.setMoth(moth);
			}
		}
		List<ProjectMothReportEntity>  ens = new ArrayList<>();
		if(vo.getTaskProId() ==null || vo.getTaskProId().equals("") ){
			if(vo.getProjectId()==null || vo.getProjectId().equals("")){
				throw new NullPointerException("ProjectId,TaskProId至少有一个不能为空！");
			}else{
				ens = dao.findbyProjectIdAndYearAndMoth(vo.getProjectId(), vo.getYear(), vo.getMoth());	
			}
			
		}else{
			ens = dao.findbyTaskProIdAndYearAndMoth(vo.getTaskProId(), vo.getYear(), vo.getMoth());

		}
		if(ens != null && ens.size()>0){
			vo.setId(ens.get(0).getId());
		}
		return super.save(vo, clazzE, clazzV);
	}

}
