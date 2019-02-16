package com.firm.investment.project.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.firm.investment.base.entity.SuperEntity;

@Entity
@Table(name="t_31_project_detail")
@NamedQuery(name="ProjectEntity.findAll", query="SELECT m FROM ProjectEntity m")
public class ProjectEntity extends SuperEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="assess_unit")
	private String assessUnit;
	
	@Column(name="assess_unit_id")
	private String assessUnitId;
	
	@Column(name="build_begin_time")
	private String buildBeginTime;
	
	@Column(name="build_content")
	private String buildContent;
	
	@Column(name="build_end_time")
	private String buildEndTime;
	
	@Column(name="comment_content")
	private String commentContent;
	
	@Column(name="display_content")
	private String displayContent;
	
	private String dqdept;
	@Column(name="enable")
	private String enable;
	
	@Column(name="entering_date")
	private String enteringDate;
	
	@Column(name="invest_year")
	private String investYear;

	private String investor;
	
	@Column(name="investor_contract")
	private String investorContract;
	
	@Column(name="investor_liaison")
	private String investorLiaison;
	
	@Column(name="investor_phone")
	private String investorPhone;
	private Double lat;
	private Double lng;
	
	@Column(name="paixu_value")
	private BigDecimal paixuValue;
	
	@Column(name="project_from")
	private String projectFrom;
	
	@Column(name="project_name")
	private String projectName;
	
	@Column(name="project_sn")
	private String projectSn;
	
	private String reason;
	private String remark;
	
	@Column(name="remark_time")
	private String remarkTime;
	
	@Column(name="responsible_org")
	private String responsibleOrg;
	
	@Column(name="responsible_org_id")
	private String responsibleOrgId;
	
	@Column(name="serve_name")
	private String serveName;
	
	@Column(name="serve_unit")
	private String serveUnit;
	
	@Column(name="serve_unit_id")
	private String serveUnitId;
	
	@Column(name="service_team_leader_id")
	private String serviceTeamLeaderId;
	
	@Column(name="service_team_liaison_id")
	private String serviceTeamLiaisonId;
	
	@Column(name="special_service_team_leader")
	private String specialServiceTeamLeader;
	
	@Column(name="special_service_team_liaison")
	private String specialServiceTeamLiaison;
	
	@Column(name="special_service_team_phone")
	private String specialServiceTeamPhone;
	/*@Column(name="starting")
	private String starting;*/
	
	@Column(name="total_investment")
	private Double totalInvestment;
	private BigDecimal type;
	
	@Column(name="year_plan")
	private String yearPlan;
	
	@Column(name="yi_chang_fang")
	private String yiChangFang;
	
	@Column(name="build_properties")
	private String buildProperties;
	
	@Column(name="chief_serve_officer")
	private String chiefServeOfficer;
	
	@Column(name="current_state")
	private String currentState;
	
	@Column(name="entering_man")
	private String enteringMan;
	
	@Column(name="industry_classification")
	private String industryClassification;
	
	@Column(name="remark_man")
	private String remarkMan;
	
	@Column(name="responsibility_area")
	private String responsibilityArea;
	
	@Column(name="supervisory_level")
	private String supervisoryLevel;
	
	@Column(name="task_pro")
	private String taskPro;
	
	@Column(name="daily_project_id")
	private String dailyProjectId;
	private BigDecimal genre;
	@Column(name="pid")
	private String pId;
	
	@Column(name="startingflag")
	private String startingFlag;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "parent")
	private List<ProjectAssessoryRelationEntity> assessoryRelations = new ArrayList<>(); 
	
	public String getAssessUnit() {
		return assessUnit;
	}
	public void setAssessUnit(String assessUnit) {
		this.assessUnit = assessUnit;
	}
	public String getAssessUnitId() {
		return assessUnitId;
	}
	public void setAssessUnitId(String assessUnitId) {
		this.assessUnitId = assessUnitId;
	}
	public String getBuildBeginTime() {
		return buildBeginTime;
	}
	public void setBuildBeginTime(String buildBeginTime) {
		this.buildBeginTime = buildBeginTime;
	}
	public String getBuildContent() {
		return buildContent;
	}
	public void setBuildContent(String buildContent) {
		this.buildContent = buildContent;
	}
	public String getBuildEndTime() {
		return buildEndTime;
	}
	public void setBuildEndTime(String buildEndTime) {
		this.buildEndTime = buildEndTime;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getDisplayContent() {
		return displayContent;
	}
	public void setDisplayContent(String displayContent) {
		this.displayContent = displayContent;
	}
	public String getDqdept() {
		return dqdept;
	}
	public void setDqdept(String dqdept) {
		this.dqdept = dqdept;
	}
	public String getEnable() {
		return enable;
	}
	public void setEnable(String enable) {
		this.enable = enable;
	}
	public String getEnteringDate() {
		return enteringDate;
	}
	public void setEnteringDate(String enteringDate) {
		this.enteringDate = enteringDate;
	}
	public String getInvestYear() {
		return investYear;
	}
	public void setInvestYear(String investYear) {
		this.investYear = investYear;
	}
	public String getInvestor() {
		return investor;
	}
	public void setInvestor(String investor) {
		this.investor = investor;
	}
	public String getInvestorContract() {
		return investorContract;
	}
	public void setInvestorContract(String investorContract) {
		this.investorContract = investorContract;
	}
	public String getInvestorLiaison() {
		return investorLiaison;
	}
	public void setInvestorLiaison(String investorLiaison) {
		this.investorLiaison = investorLiaison;
	}
	public String getInvestorPhone() {
		return investorPhone;
	}
	public void setInvestorPhone(String investorPhone) {
		this.investorPhone = investorPhone;
	}
	
	public BigDecimal getPaixuValue() {
		return paixuValue;
	}
	public void setPaixuValue(BigDecimal paixuValue) {
		this.paixuValue = paixuValue;
	}
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectSn() {
		return projectSn;
	}
	public void setProjectSn(String projectSn) {
		this.projectSn = projectSn;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRemarkTime() {
		return remarkTime;
	}
	public void setRemarkTime(String remarkTime) {
		this.remarkTime = remarkTime;
	}
	public String getResponsibleOrg() {
		return responsibleOrg;
	}
	public void setResponsibleOrg(String responsibleOrg) {
		this.responsibleOrg = responsibleOrg;
	}
	public String getResponsibleOrgId() {
		return responsibleOrgId;
	}
	public void setResponsibleOrgId(String responsibleOrgId) {
		this.responsibleOrgId = responsibleOrgId;
	}
	public String getServeName() {
		return serveName;
	}
	public void setServeName(String serveName) {
		this.serveName = serveName;
	}
	public String getServeUnit() {
		return serveUnit;
	}
	public void setServeUnit(String serveUnit) {
		this.serveUnit = serveUnit;
	}
	public String getServeUnitId() {
		return serveUnitId;
	}
	public void setServeUnitId(String serveUnitId) {
		this.serveUnitId = serveUnitId;
	}
	public String getServiceTeamLeaderId() {
		return serviceTeamLeaderId;
	}
	public void setServiceTeamLeaderId(String serviceTeamLeaderId) {
		this.serviceTeamLeaderId = serviceTeamLeaderId;
	}
	public String getServiceTeamLiaisonId() {
		return serviceTeamLiaisonId;
	}
	public void setServiceTeamLiaisonId(String serviceTeamLiaisonId) {
		this.serviceTeamLiaisonId = serviceTeamLiaisonId;
	}
	public String getSpecialServiceTeamLeader() {
		return specialServiceTeamLeader;
	}
	public void setSpecialServiceTeamLeader(String specialServiceTeamLeader) {
		this.specialServiceTeamLeader = specialServiceTeamLeader;
	}
	public String getSpecialServiceTeamLiaison() {
		return specialServiceTeamLiaison;
	}
	public void setSpecialServiceTeamLiaison(String specialServiceTeamLiaison) {
		this.specialServiceTeamLiaison = specialServiceTeamLiaison;
	}
	public String getSpecialServiceTeamPhone() {
		return specialServiceTeamPhone;
	}
	public void setSpecialServiceTeamPhone(String specialServiceTeamPhone) {
		this.specialServiceTeamPhone = specialServiceTeamPhone;
	}
	/*public String getStarting() {
		return starting;
	}
	public void setStarting(String starting) {
		this.starting = starting;
	}*/
	
	public BigDecimal getType() {
		return type;
	}
	public void setType(BigDecimal type) {
		this.type = type;
	}
	public String getYearPlan() {
		return yearPlan;
	}
	public void setYearPlan(String yearPlan) {
		this.yearPlan = yearPlan;
	}
	public String getYiChangFang() {
		return yiChangFang;
	}
	public void setYiChangFang(String yiChangFang) {
		this.yiChangFang = yiChangFang;
	}
	public String getBuildProperties() {
		return buildProperties;
	}
	public void setBuildProperties(String buildProperties) {
		this.buildProperties = buildProperties;
	}

	public String getCurrentState() {
		return currentState;
	}
	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}
	public String getEnteringMan() {
		return enteringMan;
	}
	public void setEnteringMan(String enteringMan) {
		this.enteringMan = enteringMan;
	}
	public String getIndustryClassification() {
		return industryClassification;
	}
	public void setIndustryClassification(String industryClassification) {
		this.industryClassification = industryClassification;
	}
	public String getRemarkMan() {
		return remarkMan;
	}
	public void setRemarkMan(String remarkMan) {
		this.remarkMan = remarkMan;
	}
	public String getResponsibilityArea() {
		return responsibilityArea;
	}
	public void setResponsibilityArea(String responsibilityArea) {
		this.responsibilityArea = responsibilityArea;
	}
	public String getSupervisoryLevel() {
		return supervisoryLevel;
	}
	public void setSupervisoryLevel(String supervisoryLevel) {
		this.supervisoryLevel = supervisoryLevel;
	}
	public String getTaskPro() {
		return taskPro;
	}
	public void setTaskPro(String taskPro) {
		this.taskPro = taskPro;
	}
	public String getDailyProjectId() {
		return dailyProjectId;
	}
	public void setDailyProjectId(String dailyProjectId) {
		this.dailyProjectId = dailyProjectId;
	}
	public BigDecimal getGenre() {
		return genre;
	}
	public void setGenre(BigDecimal genre) {
		this.genre = genre;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	public Double getTotalInvestment() {
		return totalInvestment;
	}
	public void setTotalInvestment(Double totalInvestment) {
		this.totalInvestment = totalInvestment;
	}
	public String getProjectFrom() {
		return projectFrom;
	}
	public void setProjectFrom(String projectFrom) {
		this.projectFrom = projectFrom;
	}
	public String getChiefServeOfficer() {
		return chiefServeOfficer;
	}
	public void setChiefServeOfficer(String chiefServeOfficer) {
		this.chiefServeOfficer = chiefServeOfficer;
	}
	public List<ProjectAssessoryRelationEntity> getAssessoryRelations() {
		return assessoryRelations;
	}
	public void setAssessoryRelations(List<ProjectAssessoryRelationEntity> assessoryRelations) {
		this.assessoryRelations = assessoryRelations;
	}
	public String getStartingFlag() {
		return startingFlag;
	}
	public void setStartingFlag(String startingFlag) {
		this.startingFlag = startingFlag;
	}
	
	

}
