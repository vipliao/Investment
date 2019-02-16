package com.firm.investment.project.vo;

import java.util.ArrayList;
import java.util.List;

import com.firm.investment.assessory.vo.AssessoryVO;
import com.firm.investment.base.vo.SuperVO;


public class ProjectProgressVO extends SuperVO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String content;
	

	private String feedBakeId;
	
	private String taskStepId;
	
	private String title;
	
	private String userId;
	
	private String username;
	
	private String taskProId;
	
	
	private List<AssessoryVO> assessorys = new ArrayList<>();//附件

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


	public List<AssessoryVO> getAssessorys() {
		return assessorys;
	}

	public void setAssessorys(List<AssessoryVO> assessorys) {
		this.assessorys = assessorys;
	}

	
	

}
