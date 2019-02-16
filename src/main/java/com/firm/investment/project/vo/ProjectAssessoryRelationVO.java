package com.firm.investment.project.vo;

import java.math.BigDecimal;

import com.firm.investment.base.vo.SuperVO;

public class ProjectAssessoryRelationVO extends SuperVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private ProjectVO parent;
	
	private BigDecimal delFlag;
	private String name;
	private String stage;
	
	private String versionId;
	
	private String taskId;
	
	private String userId;
	
	private String tDailyProjectAnnexes;

	public ProjectVO getParent() {
		return parent;
	}

	public void setParent(ProjectVO parent) {
		this.parent = parent;
	}

	public BigDecimal getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(BigDecimal delFlag) {
		this.delFlag = delFlag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getVersionId() {
		return versionId;
	}

	public void setVersionId(String versionId) {
		this.versionId = versionId;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String gettDailyProjectAnnexes() {
		return tDailyProjectAnnexes;
	}

	public void settDailyProjectAnnexes(String tDailyProjectAnnexes) {
		this.tDailyProjectAnnexes = tDailyProjectAnnexes;
	}
	
	

}
