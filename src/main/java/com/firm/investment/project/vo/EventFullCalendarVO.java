package com.firm.investment.project.vo;

import java.math.BigDecimal;

import com.firm.investment.base.vo.SuperVO;

public class EventFullCalendarVO extends SuperVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BigDecimal allDay;

	private String className;

	private BigDecimal editable;

	private String endTime;

	private String memo;
	private String num;
	private BigDecimal oder;
	private String schedule;

	private String startTime;
	private String sources;
	private String title;
	private String urls;
	private String warn;

	private String taskId;

	private String cbUser;
	private String content;
	private BigDecimal finish;

	private String editWarnInfoReson;

	private String editedWranStatus;

	private String projId;

	private String checkId;

	private String finishTime;
	
	 private ProjectFlowStepVO parent;

	public BigDecimal getAllDay() {
		return allDay;
	}

	public void setAllDay(BigDecimal allDay) {
		this.allDay = allDay;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public BigDecimal getEditable() {
		return editable;
	}

	public void setEditable(BigDecimal editable) {
		this.editable = editable;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public BigDecimal getOder() {
		return oder;
	}

	public void setOder(BigDecimal oder) {
		this.oder = oder;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getSources() {
		return sources;
	}

	public void setSources(String sources) {
		this.sources = sources;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrls() {
		return urls;
	}

	public void setUrls(String urls) {
		this.urls = urls;
	}

	public String getWarn() {
		return warn;
	}

	public void setWarn(String warn) {
		this.warn = warn;
	}

	

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getCbUser() {
		return cbUser;
	}

	public void setCbUser(String cbUser) {
		this.cbUser = cbUser;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public BigDecimal getFinish() {
		return finish;
	}

	public void setFinish(BigDecimal finish) {
		this.finish = finish;
	}

	public String getEditWarnInfoReson() {
		return editWarnInfoReson;
	}

	public void setEditWarnInfoReson(String editWarnInfoReson) {
		this.editWarnInfoReson = editWarnInfoReson;
	}

	public String getEditedWranStatus() {
		return editedWranStatus;
	}

	public void setEditedWranStatus(String editedWranStatus) {
		this.editedWranStatus = editedWranStatus;
	}

	public String getProjId() {
		return projId;
	}

	public void setProjId(String projId) {
		this.projId = projId;
	}

	public String getCheckId() {
		return checkId;
	}

	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}

	public String getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}

	public ProjectFlowStepVO getParent() {
		return parent;
	}

	public void setParent(ProjectFlowStepVO parent) {
		this.parent = parent;
	}
	
	

}
