package com.firm.investment.project.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.firm.investment.base.vo.SuperVO;

public class ProjectFlowStepVO extends SuperVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String configmstepId;
	
	private BigDecimal isFinish;
	private BigDecimal lev;
	private String name;
	private BigDecimal sort;
	private BigDecimal pid;
	private String taskProId;
	private String fullCalendarId;
	private BigDecimal isExceed;
	private String projectId;
	private String startTime;
	
	private List<EventFullCalendarVO> eventFullCalendars = new ArrayList<>(); 
	
	
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
	
	public List<EventFullCalendarVO> getEventFullCalendars() {
		return eventFullCalendars;
	}
	public void setEventFullCalendars(List<EventFullCalendarVO> eventFullCalendars) {
		this.eventFullCalendars = eventFullCalendars;
	}
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
	public BigDecimal getLev() {
		return lev;
	}
	public void setLev(BigDecimal lev) {
		this.lev = lev;
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
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	
	
}
