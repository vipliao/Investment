package com.firm.investment.project.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.firm.investment.base.entity.SuperEntity;

@Entity
@Table(name="t_panel_annex")
public class ProjectAssessoryRelationEntity extends SuperEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name="T_PROJECT_ANNEXES")
	private ProjectEntity parent;
	@Column(name="del_flag")
	private BigDecimal delFlag;
	private String name;
	private String stage;
	@Column(name="version_id")
	private String versionId;
	@Column(name="task_id")
	private String taskId;
	@Column(name="user_id")
	private String userId;
	@Column(name="T_DAILY_PROJECT_ANNEXES")
	private String tDailyProjectAnnexes;
	
	public ProjectEntity getParent() {
		return parent;
	}
	public void setParent(ProjectEntity parent) {
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
