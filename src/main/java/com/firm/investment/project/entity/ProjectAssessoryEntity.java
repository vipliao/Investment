package com.firm.investment.project.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.firm.investment.base.entity.SuperEntity;

@Entity
@Table(name="t_doc_document_version")
public class ProjectAssessoryEntity extends SuperEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="big_path")
	private String bigPath;
	@Column(name="file_size")
	private BigDecimal fileSize;
	@Column(name="is_image")
	private BigDecimal isImage;
	@Column(name="mini_path")
	private String miniPath;
	private String name;
	private String path;
	@Column(name="small_path")
	private String smallPath;
	@Column(name="thum_path")
	private String thumPath;
	@Column(name="total_page")
	private BigDecimal totalPage;
	@Column(name="trans_path")
	private String transPath;
	@Column(name="trans_status")
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
