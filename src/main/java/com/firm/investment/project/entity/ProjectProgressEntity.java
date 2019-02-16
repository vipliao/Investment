package com.firm.investment.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.firm.investment.base.entity.SuperEntity;

@Entity
@Table(name="t_31_panle_pro_progress")
public class ProjectProgressEntity extends SuperEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String content;
	
	@Column(name="feed_bake_id")
	private String feedBakeId;
	
	@Column(name="task_step_id")
	private String taskStepId;
	
	private String title;
	
	@Column(name="user_id")
	private String userId;
	
	private String username;
	
	@Column(name="task_pro_id")
	private String taskProId;
	

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFeedBakeId() {
		return feedBakeId;
	}

	public void setFeedBakeId(String feedBakeId) {
		this.feedBakeId = feedBakeId;
	}

	public String getTaskStepId() {
		return taskStepId;
	}

	public void setTaskStepId(String taskStepId) {
		this.taskStepId = taskStepId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTaskProId() {
		return taskProId;
	}

	public void setTaskProId(String taskProId) {
		this.taskProId = taskProId;
	}

	

}
