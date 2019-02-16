package com.firm.investment.project.service.impl;

import java.math.BigDecimal;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firm.investment.assessory.vo.AssessoryVO;
import com.firm.investment.base.dao.BaseQueryDao;
import com.firm.investment.base.service.impl.BaseServiceImpl;
import com.firm.investment.base.vo.BaseVO;
import com.firm.investment.interest.vo.InterestVO;
import com.firm.investment.project.dao.ProjectDao;
import com.firm.investment.project.entity.ProjectAssessoryRelationEntity;
import com.firm.investment.project.entity.ProjectEntity;
import com.firm.investment.project.service.IProjectService;
import com.firm.investment.project.vo.AreaVO;
import com.firm.investment.project.vo.InvestMoneyAndRateVO;
import com.firm.investment.project.vo.ProjectAssessoryRelationVO;
import com.firm.investment.project.vo.ProjectVO;

@Service
public class ProjectServiceImpl extends BaseServiceImpl<ProjectEntity, ProjectVO> implements IProjectService {

	@Autowired
	private BaseQueryDao queryDao;
	@Autowired
	private ProjectDao dao;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public ProjectVO findVOById(String id, Class<ProjectVO> cls) throws Exception {
		ProjectVO vo = new ProjectVO();
		if (id == "-1") {
			vo = (ProjectVO) findAll(cls);

		} else {
			vo = super.findVOById(id, cls);
		}
		List<ProjectVO> projectVOs = new ArrayList<ProjectVO>();
		projectVOs.add(vo);
		projectVOs = queryProjectAssessorys(projectVOs);
		vo = projectVOs.get(0);
		return vo;
	}

	@Override
	public List<ProjectVO> findAssessUnitProjectList(String assessUnitId, int level) throws Exception {
		List<ProjectVO> reVos = new ArrayList<>();
		if (assessUnitId != null && !assessUnitId.equals("")) {
			if (assessUnitId.equals("-1")) {
				reVos = findAll(ProjectVO.class);
			} else {
				String levelName = null;
				switch (level) {
				case 1:
					levelName = "市重点";
					break;
				case 2:
					levelName = "县重点";
					break;
				default:
					levelName = "市重点";
				}
				List<ProjectEntity> ens = new ArrayList<>();
				ens = dao.findAssessUnitProjectList(assessUnitId, levelName);
				if (ens != null && ens.size() > 0) {
					for (ProjectEntity en : ens) {
						ProjectVO vo = new ProjectVO();
						BeanUtils.copyProperties(en, vo);
						/*
						 * List<ProjectAssessoryRelationVO> relationVos = new
						 * ArrayList<>(); if(en.getAssessoryRelations() !=null
						 * && en.getAssessoryRelations().size()>0){
						 * List<ProjectAssessoryRelationEntity> relationEns =
						 * en.getAssessoryRelations();
						 * for(ProjectAssessoryRelationEntity ralationEn :
						 * relationEns){ ProjectAssessoryRelationVO enVo = new
						 * ProjectAssessoryRelationVO();
						 * BeanUtils.copyProperties(ralationEn, enVo);
						 * relationVos.add(enVo); }
						 * vo.setAssessoryRelations(relationVos); }
						 */
						vo.setAssessoryRelations(null);
						vo.setAreaId(assessUnitId);
						vo.setLevel(level);
						reVos.add(vo);
					}
					if (reVos != null && reVos.size() > 0) {
						reVos = queryProjectAssessorys(reVos);
					}
				}
			}
		} else {
			return null;
		}
		return reVos;
	}

	@Override
	public List<AreaVO> findAssessUnitProjectArea() throws Exception {

		String sql = "Select name,id from t_31_data_dic where P_ID = (select id from t_31_data_dic  where ENGLIST_NAME = 'area')";
		Map<String, Object> map = new HashMap<>();
		List<AreaVO> vos = queryDao.findListBySql(sql, map, AreaVO.class);
		return vos;
	}

	@Transactional
	public void updateProjectState(String id, int actionType) throws Exception {
		String actionTypeName = null;
		switch (actionType) {
		case 1:
			actionTypeName = "已入库";
		case 2:
			actionTypeName = "未交办";
		case 3:
			actionTypeName = "已交办";
		case 4:
			actionTypeName = "已办结";
		case 5:
			actionTypeName = "已出库";
		}
		if (actionTypeName == null) {
			return;
		}
		String sql = "update t_31_project_detail set current_state = (select id from t_31_data_dic where name='"
				+ actionTypeName + "') where id='" + id + "'";
		queryDao.executeUpdateSQL(sql);
	}

	@Override
	@Transactional
	public ProjectVO save(ProjectVO vo, Class<ProjectEntity> clazzE, Class<ProjectVO> clazzV) throws Exception {

		ProjectVO reVo = super.save(vo, clazzE, clazzV);
		reVo.setTaskPro(reVo.getId());
		String t_panel_task_pro_id = UUID.randomUUID().toString();
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String nowStr = dateFormat.format(now);
		String sql = "INSERT INTO t_panel_task_pro" + " VALUES ('" + t_panel_task_pro_id + "'," + " '" + nowStr + "', '"
				+ nowStr + "'," + " null, '" + reVo.getProjectName() + "'," + " null, '0', null, 'project', null,"
				+ " '" + reVo.getId() + "')";
		queryDao.executeUpdateSQL(sql);
		if (vo.getAreaId() == null || vo.getAreaId().equals("")) {
			throw new Exception("areaId没有值！");
		}
		String levelName = null;
		switch (vo.getLevel()) {
		case 1:
			levelName = "市重点";
			break;
		case 2:
			levelName = "县重点";
			break;
		default:
			levelName = "市重点";
		}
		String sql2 = "select id from t_31_data_dic where name ='" + levelName + "'";
		Map<String, Object> map = new HashMap<>();
		List<BaseVO> baseVos = queryDao.findListBySql(sql2, map, BaseVO.class);
		if (baseVos != null && baseVos.size() > 0) {
			reVo.setSupervisoryLevel(baseVos.get(0).getId());
		}
		String sql1 = "INSERT INTO T_31_PROJECT_DETAIL_AREAS" + " VALUES ('" + reVo.getId() + "','" + vo.getAreaId()
				+ "')";
		queryDao.executeUpdateSQL(sql1);
		if (vo.getAssessorys() != null && vo.getAssessorys().size() > 0) {
			List<ProjectAssessoryRelationVO> assessoryRelations = new ArrayList<>();
			for (AssessoryVO assessory : vo.getAssessorys()) {
				ProjectAssessoryRelationVO relationVO = new ProjectAssessoryRelationVO();
				relationVO.setVersionId(assessory.getId());
				relationVO.setName(vo.getProjectName() + "_" + assessory.getName());
				relationVO.setTaskId(reVo.getId());
				relationVO.setDelFlag(new BigDecimal(assessory.getDelFlag()));
				assessoryRelations.add(relationVO);
			}
			reVo.setAssessoryRelations(assessoryRelations);
		}
		reVo = super.save(reVo, clazzE, clazzV);
		reVo.setAssessoryRelations(null);
		reVo.setAssessorys(vo.getAssessorys());
		reVo.setAreaId(vo.getAreaId());
		reVo.setLevel(vo.getLevel());
		return reVo;
	}

	@Override
	public List<ProjectVO> queryInterestPjtIdByUserId(String userId) throws Exception {
		List<ProjectVO> reVOs = new ArrayList<>();
		String sql = "select project_id projectId from invest_interest where user_id='" + userId + "' and action=1";
		Map<String, Object> map = new HashMap<>();
		List<InterestVO> interestVOs = queryDao.findListBySql(sql, map, InterestVO.class);
		if (interestVOs == null || interestVOs.size() <= 0) {
			return null;
		}
		List<String> ids = new ArrayList<>();
		for (InterestVO interestVO : interestVOs) {
			if (interestVO.getProjectId() != null && !interestVO.getProjectId().equals("")) {
				ids.add(interestVO.getProjectId());
			}

		}
		if (ids != null || ids.size() > 0) {
			List<ProjectEntity> ens = dao.findbyIds(ids);
			if (ens != null && ens.size() > 0) {
				for (ProjectEntity en : ens) {
					ProjectVO vo = new ProjectVO();
					/*
					 * List<ProjectAssessoryRelationVO> relationVos = new
					 * ArrayList<>(); if(en.getAssessoryRelations() !=null &&
					 * en.getAssessoryRelations().size()>0){
					 * List<ProjectAssessoryRelationEntity> relationEns =
					 * en.getAssessoryRelations();
					 * for(ProjectAssessoryRelationEntity ralationEn :
					 * relationEns){ ProjectAssessoryRelationVO enVo = new
					 * ProjectAssessoryRelationVO();
					 * BeanUtils.copyProperties(ralationEn, enVo);
					 * relationVos.add(enVo); }
					 * vo.setAssessoryRelations(relationVos); }
					 */
					BeanUtils.copyProperties(en, vo);
					vo.setAssessoryRelations(null);
					reVOs.add(vo);
				}
			}
			if (reVOs != null && reVOs.size() > 0) {
				reVOs = queryProjectAssessorys(reVOs);
			}

		}

		return reVOs;
	}

	/**
	 * 获取项目附件
	 * 
	 * @param projectVOs
	 * @return
	 * @throws Exception
	 */
	private List<ProjectVO> queryProjectAssessorys(List<ProjectVO> projectVOs) throws Exception {
		if (projectVOs == null || projectVOs.size() <= 0) {
			return null;
		}
		List<String> ids = new ArrayList<>();
		for (ProjectVO vo : projectVOs) {
			ids.add(vo.getTaskPro());
		}
		String sql1 = "SELECT version.create_time createTime,version.id id,version.name name,version.path path,annex.task_id businessId "
				+ " FROM t_doc_document_version version"
				+ " left join t_panel_annex annex on version.id=annex.version_id WHERE annex.task_id in (:ids)";
		Map<String, Object> params = new HashMap<>();
		params.put("ids", ids);
		List<AssessoryVO> assessoryVOs = queryDao.findListBySql(sql1, params, AssessoryVO.class);
		if (assessoryVOs != null && assessoryVOs.size() > 0) {
			for (ProjectVO vo : projectVOs) {
				List<AssessoryVO> iAssessoryVOs = new ArrayList<>();
				for (AssessoryVO assessoryVO : assessoryVOs) {
					if (assessoryVO.getBusinessId() != null && assessoryVO.getBusinessId().equals(vo.getTaskPro())) {
						assessoryVO.setUrl("/project/download?fileName=" + assessoryVO.getName());
						iAssessoryVOs.add(assessoryVO);
					}
				}
				vo.setAssessorys(iAssessoryVOs);
			}
		}
		return projectVOs;
	}

	@Override
	protected ProjectEntity beforeSave(ProjectVO vo, Class<ProjectEntity> clazzE, Class<ProjectVO> clazzV)
			throws Exception {
		ProjectEntity entity = new ProjectEntity();
		BeanUtils.copyProperties(vo, entity);
		List<ProjectAssessoryRelationVO> childVOs = new ArrayList<ProjectAssessoryRelationVO>(
				vo.getAssessoryRelations());
		List<ProjectAssessoryRelationEntity> childEntitys = new ArrayList<ProjectAssessoryRelationEntity>();
		for (ProjectAssessoryRelationVO childDetailVO : childVOs) {
			ProjectAssessoryRelationEntity childEntity = new ProjectAssessoryRelationEntity();
			BeanUtils.copyProperties(childDetailVO, childEntity);
			childEntity.setParent(entity);
			childEntitys.add(childEntity);

		}
		entity.setAssessoryRelations(childEntitys);
		return entity;
	}

	@Override
	protected ProjectVO afterSave(ProjectEntity entity, Class<ProjectEntity> clazzE, Class<ProjectVO> clazzV)
			throws Exception {
		ProjectVO vo = new ProjectVO();
		BeanUtils.copyProperties(entity, vo);
		List<ProjectAssessoryRelationVO> childVOs = new ArrayList<ProjectAssessoryRelationVO>();
		List<ProjectAssessoryRelationEntity> childEntitys = new ArrayList<ProjectAssessoryRelationEntity>(
				entity.getAssessoryRelations());
		for (ProjectAssessoryRelationEntity childEntity : childEntitys) {
			ProjectAssessoryRelationVO childVO = new ProjectAssessoryRelationVO();
			BeanUtils.copyProperties(childEntity, childVO);
			childVO.setParent(vo);
			childVOs.add(childVO);

		}
		vo.setAssessoryRelations(childVOs);
		return vo;
	}

	@Override
	public InvestMoneyAndRateVO queryInvestMoneyAndRate() throws Exception {
		InvestMoneyAndRateVO reVO = new InvestMoneyAndRateVO();
		String sql = "select CONVERT(sum(TOTAL_INVESTMENT),decimal(19,9)) investMoney from t_31_project_detail";
		String sql1 = "select CONVERT(sum(TOTAL_INVESTMENT),decimal(19,9)) investMoney from t_31_project_detail where startingflag ='YES'";
		Map<String, Object> map = new HashMap<>();
		List<InvestMoneyAndRateVO> vos = queryDao.findListBySql(sql, map, InvestMoneyAndRateVO.class);
		if (vos == null || vos.size() <= 0) {
			return null;
		}
		BigDecimal investMoney = vos.get(0).getInvestMoney();
		reVO.setInvestMoney(investMoney.divide(new BigDecimal("10000"), 0, BigDecimal.ROUND_HALF_UP));
		List<InvestMoneyAndRateVO> vos1 = queryDao.findListBySql(sql1, map, InvestMoneyAndRateVO.class);
		if (vos1 != null && vos1.size() > 0) {
			BigDecimal yesInvestMoney = vos1.get(0).getInvestMoney();
			BigDecimal result = yesInvestMoney.divide(investMoney, 6, BigDecimal.ROUND_HALF_UP)
					.multiply(new BigDecimal("100")).setScale(2, BigDecimal.ROUND_HALF_UP);
			reVO.setRate(result.toString() + "%");
		}
		return reVO;
	}

	@Override
	public List<ProjectVO> queryProjectList(Map<String, Object> map) throws Exception {
		/*
		 * Field[] fields = new ProjectVO().getClass().getDeclaredFields();
		 * if(ArrayUtils.isEmpty(fields)){ return null; } String[] fieldNames =
		 * new String[fields.length]; for(int i=0 ;i<fields.length;i++){
		 * fieldNames[i]=fields[i].getName(); } String fieldNamesStr =
		 * StringUtils.join(fieldNames,",");
		 */
		StringBuilder sql = new StringBuilder();
		/*
		 * sql.
		 * append("select p.id id,p.create_time createTime,update_time updateTime,p.assess_unit assessUnit,p.assess_unit_id assessUnitId,"
		 * +
		 * " p.build_begin_time buildBeginTime,p.build_content buildContent,p.build_end_time buildEndTime,p.comment_content commentContent,"
		 * +
		 * " p.display_content displayContent,p.dqdept dqdept,p.entering_date enteringDate,p.invest_year investYear,p.investor investor,"
		 * +
		 * " p.investor_contract investorContract,p.investor_liaison investorLiaison,p.investor_phone investorPhone,p.lat lat,p.lng lng,p.paixu_value paixuValue,"
		 * +
		 * " p.project_from projectFrom,p.project_name projectName,p.project_sn projectSn,p.reason reason,p.remark remark,p.remark_time remarkTime,p.responsible_org responsibleOrg,"
		 * +
		 * " p.responsible_org_id responsibleOrgId,p.serve_name serveName,p.serve_unit serveUnit,p.serve_unit_id serveUnitId,p.service_team_leader_id serviceTeamLeaderId,"
		 * +
		 * " p.service_team_liaison_id serviceTeamLiaisonId,p.special_service_team_leader specialServiceTeamLeader,p.special_service_team_liaison specialServiceTeamLiaison,"
		 * +
		 * " p.special_service_team_phone specialServiceTeamPhone,p.total_investment totalInvestment,p.type type,p.year_plan yearPlan,p.yi_chang_fang yiChangFang,"
		 * +
		 * " p.build_properties buildProperties,p.chief_serve_officer chiefServeOfficer,p.current_state currentState,p.entering_man enteringMan,p.industry_classification industryClassification,"
		 * +
		 * " p.remark_man remarkMan,p.responsibility_area responsibilityArea,p.supervisory_level supervisoryLevel,p.task_pro taskPro,p.daily_project_id dailyProjectId,p.genre genre,p.pid pId,"
		 * + " p.startingflag startingFlag" + " from t_31_project_detail p" +
		 * " where 1=1 ");
		 */
		sql.append("select * from t_31_project_detail p  where 1=1");

		String totalInvestmentStr = null;
		String buildBeginTimeStr = null;
		String industryClassification = null;
		String supervisoryLevel = null;
		if (map.containsKey("projectNameKey")) {
			String projectNameKey = URLDecoder.decode((String) map.get("projectNameKey"), "UTF-8");
			sql.append(" and p.project_name like '%" + projectNameKey + "%'");
		}
		if (map.containsKey("totalInvestment")) {
			String totalInvestmentType = (String) map.get("totalInvestment");
			if (totalInvestmentType.equals("1")) {// 一亿以下
				totalInvestmentStr = "p.total_investment <= 10000";
			} else if (totalInvestmentType.equals("2")) {// 1到5亿
				totalInvestmentStr = "p.total_investment >= 10000 and p.total_investment <= 50000";
			} else if (totalInvestmentType.equals("3")) {// 5到10亿
				totalInvestmentStr = "p.total_investment >= 50000 and p.total_investment <= 100000";
			} else if (totalInvestmentType.equals("4")) {// 10到50亿
				totalInvestmentStr = "p.total_investment >= 100000 and p.total_investment <= 500000";
			} else if (totalInvestmentType.equals("5")) {// 50亿以上
				totalInvestmentStr = "p.total_investment >= 500000";
			}
			if (totalInvestmentStr != null && !totalInvestmentStr.equals("")) {
				sql.append(" and " + totalInvestmentStr);
			}
		}
		if (map.containsKey("buildBeginTime")) {
			buildBeginTimeStr = URLDecoder.decode((String) map.get("buildBeginTime"), "UTF-8");
			if (buildBeginTimeStr != null && !buildBeginTimeStr.equals("")) {
				sql.append(" and p.build_begin_time like '%" + buildBeginTimeStr + "%'");
			}
		}
		if (map.containsKey("industryClassification")) {
			industryClassification = URLDecoder.decode((String) map.get("industryClassification"), "UTF-8");
			if (industryClassification != null && !industryClassification.equals("")) {
				sql.append(" and p.industry_classification = " + "(select dic.id from t_31_data_dic dic "
						+ "  where dic.p_id in (select d.id from t_31_data_dic d where d.englist_name = 'industryClassification')"
						+ " and name='" + industryClassification + "')");
			}

		}
		if (map.containsKey("supervisoryLevel")) {
			supervisoryLevel = URLDecoder.decode((String) map.get("supervisoryLevel"), "UTF-8");
			if (supervisoryLevel != null && !supervisoryLevel.equals("")) {
				sql.append(" and p.supervisory_level = " + "(select dic.id from t_31_data_dic dic "
						+ "  where dic.p_id in (select d.id from t_31_data_dic d where d.englist_name = 'supervisoryLevel')"
						+ " and name='" + supervisoryLevel + "')");
			}

		}
		/*
		 * String projectNameKey = (String) map.get("projectNameKey");
		 * List<ProjectEntity> ens =
		 * dao.findListbyLikeName("%"+projectNameKey+"%"); List<ProjectVO> reVos
		 * = new ArrayList<>(); if(ens!=null && ens.size()>0){ for(ProjectEntity
		 * en:ens){ ProjectVO vo = new ProjectVO(); BeanUtils.copyProperties(en,
		 * vo); vo.setAssessoryRelations(null); reVos.add(vo); } if(reVos !=null
		 * && reVos.size()>0){ reVos = queryProjectAssessorys(reVos); } }
		 */
		Map<String, Object> map1 = new HashMap<>();
		List<ProjectVO> reVos = jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<ProjectVO>(ProjectVO.class));
		// List<ProjectVO> reVos = queryDao.findListBySql(sql.toString(),
		// map1,ProjectVO.class);
		if (reVos != null && reVos.size() > 0) {
			reVos = queryProjectAssessorys(reVos);
		}
		return reVos;
	}

	@Override
	public List<ProjectVO> findAssessUnitPrjsByName(String name) throws Exception {
		String sql = "Select * from t_31_project_detail " + " where 1=1 " + " and ID in ("
				+ "  select T_31_PROJECT_DETAIL from T_31_PROJECT_DETAIL_AREAS" + "    where AREAS in ("
				+ "         Select id from t_31_data_dic where P_ID = ("
				+ "             select id from t_31_data_dic where ENGLIST_NAME = 'area'" + "	        ) AND NAME = '"
				+ name + "'" + "   )" + ") OR serve_unit LIKE '%" + name + "%' OR assess_unit LIKE '%" + name + "%'";

		List<ProjectVO> reVos = jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<ProjectVO>(ProjectVO.class));
		if (reVos != null && reVos.size() > 0) {
			reVos = queryProjectAssessorys(reVos);
		}
		return reVos;
	}
}
