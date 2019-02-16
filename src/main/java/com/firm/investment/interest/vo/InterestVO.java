package com.firm.investment.interest.vo;

import com.firm.investment.base.vo.SuperVO;

public class InterestVO extends SuperVO{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userId;
	private String projectId;
	private int action;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
}
