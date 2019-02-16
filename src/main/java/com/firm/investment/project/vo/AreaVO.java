package com.firm.investment.project.vo;

import com.firm.investment.base.vo.SuperVO;

public class AreaVO extends SuperVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	String id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
