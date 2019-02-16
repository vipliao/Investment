package com.firm.investment.project.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.firm.investment.assessory.vo.AssessoryVO;
import com.firm.investment.base.vo.SuperVO;

public class ProjectVO extends SuperVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String assessUnit;
	private String assessUnitId;
	private String buildBeginTime;
	private String buildContent;
	private String buildEndTime;
	private String commentContent;
	private String displayContent;
	private String dqdept;
	private String enable;
	private String enteringDate;
	private String investYear;
	private String investor;
	private String investorContract;
	private String investorLiaison;
	private String investorPhone;
	private Double lat;
	private Double lng;
	private BigDecimal paixuValue;
	private String projectFrom;
	private String projectName;
	private String projectSn;
	private String reason;
	private String remark;
	private String remarkTime;
	private String responsibleOrg;
	private String responsibleOrgId;
	private String serveName;
	private String serveUnit;
	private String serveUnitId;
	private String serviceTeamLeaderId;
	private String serviceTeamLiaisonId;
	private String specialServiceTeamLeader;
	private String specialServiceTeamLiaison;
	private String specialServiceTeamPhone;
/*	private String starting;*/
	private Double totalInvestment;
	private BigDecimal type;
	private String yearPlan;
	private String yiChangFang;
	private String buildProperties;
	private String chiefServeOfficer;
	private String currentState;
	private String enteringMan;
	private String industryClassification;
	private String remarkMan;
	private String responsibilityArea;
	private String supervisoryLevel;
	private String taskPro;
	private String dailyProjectId;
	private BigDecimal genre;
	private String pId;
	private String startingFlag;


	private String areaId;
	private int level;

	private List<AssessoryVO> assessorys = new ArrayList<>();//附件
	
	private List<ProjectAssessoryRelationVO> assessoryRelations = new ArrayList<>();//附件关系，项目子表

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

	
	public String getProjectFrom() {
		return projectFrom;
	}

	public void setProjectFrom(String projectFrom) {
		this.projectFrom = projectFrom;
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

	

	public String getChiefServeOfficer() {
		return chiefServeOfficer;
	}

	public void setChiefServeOfficer(String chiefServeOfficer) {
		this.chiefServeOfficer = chiefServeOfficer;
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

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public List<AssessoryVO> getAssessorys() {
		return assessorys;
	}

	public void setAssessorys(List<AssessoryVO> assessorys) {
		this.assessorys = assessorys;
	}

	public List<ProjectAssessoryRelationVO> getAssessoryRelations() {
		return assessoryRelations;
	}

	public void setAssessoryRelations(List<ProjectAssessoryRelationVO> assessoryRelations) {
		this.assessoryRelations = assessoryRelations;
	}

	public String getStartingFlag() {
		return startingFlag;
	}

	public void setStartingFlag(String startingFlag) {
		this.startingFlag = startingFlag;
	}
	
	

}
