package com.firm.investment.news.vo;


import java.util.ArrayList;
import java.util.List;

import com.firm.investment.assessory.vo.AssessoryVO;
import com.firm.investment.base.vo.SuperVO;

public class NewsVO extends SuperVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String title;
	private String content;
	private int type;
	private List<AssessoryVO> assessorys = new ArrayList<>();
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public List<AssessoryVO> getAssessorys() {
		return assessorys;
	}
	public void setAssessorys(List<AssessoryVO> assessorys) {
		this.assessorys = assessorys;
	}
	
	

}
