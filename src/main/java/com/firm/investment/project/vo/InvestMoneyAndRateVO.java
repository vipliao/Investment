package com.firm.investment.project.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class InvestMoneyAndRateVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String projectId;
	private String rate;
	private BigDecimal investMoney;
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public BigDecimal getInvestMoney() {
		return investMoney;
	}
	public void setInvestMoney(BigDecimal investMoney) {
		this.investMoney = investMoney;
	}
	
	
	
	
}
