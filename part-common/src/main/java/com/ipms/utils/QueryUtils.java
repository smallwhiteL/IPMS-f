package com.ipms.utils;
/**
 * 查询工具类
 * @author ASUS
 *
 */
public class QueryUtils {
	
	private Integer status;
	private String plan_userId;
	private Integer page_index;
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
	public Integer getPage_index() {
		return page_index;
	}
	public void setPage_index(Integer page_index) {
		this.page_index = page_index;
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
	public QueryUtils(Integer status, String plan_userId, Integer page_index, Integer start_row) {
		super();
		this.status = status;
		this.plan_userId = plan_userId;
		this.page_index = page_index;
		this.start_row = start_row;
	}
	
	
	
}
