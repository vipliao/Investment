package com.firm.investment.project.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.firm.investment.base.entity.SuperEntity;

@Entity
@Table(name="t_panel_config_task_step")
public class ProjectFlowStepEntity extends SuperEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="CONFIGMSTEP_ID")
	private String configmstepId;
	@Column(name="IS_FINISH")
	private BigDecimal isFinish;
	private BigDecimal LEV;
	private String name;
	private BigDecimal sort;
	private BigDecimal pid;
	@Column(name="task_pro_id")
	private String taskProId;
	@Column(name="full_calendar_id")
	private String fullCalendarId;
	@Column(name="IS_EXCEED")
	private BigDecimal isExceed;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "parent")
	private List<EventFullCalendarEntity> eventFullCalendars = new ArrayList<>(); 
	
	
	public String getConfigmstepId() {
		return configmstepId;
	}
	public void setConfigmstepId(String configmstepId) {
		this.configmstepId = configmstepId;
	}
	public BigDecimal getIsFinish() {
		return isFinish;
	}
	public void setIsFinish(BigDecimal isFinish) {
		this.isFinish = isFinish;
	}
	public BigDecimal getLEV() {
		return LEV;
	}
	public void setLEV(BigDecimal lEV) {
		LEV = lEV;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getSort() {
		return sort;
	}
	public void setSort(BigDecimal sort) {
		this.sort = sort;
	}
	public BigDecimal getPid() {
		return pid;
	}
	public void setPid(BigDecimal pid) {
		this.pid = pid;
	}
	public String getTaskProId() {
		return taskProId;
	}
	public void setTaskProId(String taskProId) {
		this.taskProId = taskProId;
	}
	public String getFullCalendarId() {
		return fullCalendarId;
	}
	public void setFullCalendarId(String fullCalendarId) {
		this.fullCalendarId = fullCalendarId;
	}
	public BigDecimal getIsExceed() {
		return isExceed;
	}
	public void setIsExceed(BigDecimal isExceed) {
		this.isExceed = isExceed;
	}
	public List<EventFullCalendarEntity> getEventFullCalendars() {
		return eventFullCalendars;
	}
	public void setEventFullCalendars(List<EventFullCalendarEntity> eventFullCalendars) {
		this.eventFullCalendars = eventFullCalendars;
	}
	
	

}
