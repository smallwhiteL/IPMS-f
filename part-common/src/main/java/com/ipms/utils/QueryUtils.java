package com.ipms.utils;

public class QueryUtils {
	
	private Integer status;
	private String plan_userId;
	private Integer start_row;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getPlan_userId() {
		return plan_userId;
	}
	public void setPlan_userId(String plan_userId) {
		this.plan_userId = plan_userId;
	}
	public Integer getStart_row() {
		return start_row;
	}
	public void setStart_row(Integer start_row) {
		this.start_row = start_row;
	}
	
	public QueryUtils() {
		super();
	}
	
	public QueryUtils(Integer status, String plan_userId, Integer start_row) {
		super();
		this.status = status;
		this.plan_userId = plan_userId;
		this.start_row = start_row;
	}

	
}
