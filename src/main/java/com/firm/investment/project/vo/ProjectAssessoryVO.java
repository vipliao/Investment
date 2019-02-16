package com.firm.investment.project.vo;

import java.math.BigDecimal;

import com.firm.investment.base.vo.SuperVO;

public class ProjectAssessoryVO extends SuperVO {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	private String bigPath;
	private BigDecimal fileSize;
	private BigDecimal isImage;
	private String miniPath;
	private String name;
	private String path;
	private String smallPath;
	private String thumPath;
	private BigDecimal totalPage;
	private String transPath;
	private String transStatus;
	private String type;

	public String getBigPath() {
		return bigPath;
	}

	public void setBigPath(String bigPath) {
		this.bigPath = bigPath;
	}

	public BigDecimal getFileSize() {
		return fileSize;
	}

	public void setFileSize(BigDecimal fileSize) {
		this.fileSize = fileSize;
	}

	public String getMiniPath() {
		return miniPath;
	}

	public void setMiniPath(String miniPath) {
		this.miniPath = miniPath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSmallPath() {
		return smallPath;
	}

	public void setSmallPath(String smallPath) {
		this.smallPath = smallPath;
	}

	public String getThumPath() {
		return thumPath;
	}

	public void setThumPath(String thumPath) {
		this.thumPath = thumPath;
	}

	public BigDecimal getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(BigDecimal totalPage) {
		this.totalPage = totalPage;
	}

	public String getTransPath() {
		return transPath;
	}

	public void setTransPath(String transPath) {
		this.transPath = transPath;
	}

	public String getTransStatus() {
		return transStatus;
	}

	public void setTransStatus(String transStatus) {
		this.transStatus = transStatus;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getIsImage() {
		return isImage;
	}

	public void setIsImage(BigDecimal isImage) {
		this.isImage = isImage;
	}

}
