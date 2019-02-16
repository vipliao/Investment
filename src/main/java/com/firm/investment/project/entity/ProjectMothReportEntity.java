package com.firm.investment.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.firm.investment.base.entity.SuperEntity;

@Entity
@Table(name="t_project_tbale_moth_report")
public class ProjectMothReportEntity extends SuperEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String moth;
	@Column(name="moth_in_vestor")
	private String mothInVestor;
	@Column(name="moth_in_vestor_rate")
	private String mothInVestorRate;
	private String name;
	private String remake;
	@Column(name="write_time")
	private String writeTime;
	@Column(name="taskpro_id")
	private String taskProId;
	private String enable;
	private String year;
	private String taskproboost;
	private String difficult;
	private String coordinate;
	private String delegate;
	public String getMoth() {
		return moth;
	}
	public void setMoth(String moth) {
		this.moth = moth;
	}
	public String getMothInVestor() {
		return mothInVestor;
	}
	public void setMothInVestor(String mothInVestor) {
		this.mothInVestor = mothInVestor;
	}
	public String getMothInVestorRate() {
		return mothInVestorRate;
	}
	public void setMothInVestorRate(String mothInVestorRate) {
		this.mothInVestorRate = mothInVestorRate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRemake() {
		return remake;
	}
	public void setRemake(String remake) {
		this.remake = remake;
	}
	public String getWriteTime() {
		return writeTime;
	}
	public void setWriteTime(String writeTime) {
		this.writeTime = writeTime;
	}
	public String getTaskProId() {
		return taskProId;
	}
	public void setTaskProId(String taskProId) {
		this.taskProId = taskProId;
	}
	public String getEnable() {
		return enable;
	}
	public void setEnable(String enable) {
		this.enable = enable;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getTaskproboost() {
		return taskproboost;
	}
	public void setTaskproboost(String taskproboost) {
		this.taskproboost = taskproboost;
	}
	public String getDifficult() {
		return difficult;
	}
	public void setDifficult(String difficult) {
		this.difficult = difficult;
	}
	public String getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}
	public String getDelegate() {
		return delegate;
	}
	public void setDelegate(String delegate) {
		this.delegate = delegate;
	}
	
	

}
