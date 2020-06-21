package com.laptrinhjavaweb.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AbstractDTO {

	private Long id;

	private Date createdDate;

	private String createdBy;

	private Date modifiedDate;

	private String modifiedBy;
	
	private List<AbstractDTO> listResult = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public List<AbstractDTO> getListResult() {
		return listResult;
	}

	public void setListResult(List<AbstractDTO> listResult) {
		this.listResult = listResult;
	}

}
