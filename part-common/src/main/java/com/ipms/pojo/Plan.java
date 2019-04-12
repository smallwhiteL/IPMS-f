package com.ipms.pojo;

import java.util.Date;

public class Plan {
	private Integer plan_id;
	private String plan_title;
	private Date plan_starting_time;
	private Date plan_ending_time;
	private String plan_describe;
	private Integer plan_status;
	private String plan_userId;
	public Integer getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(Integer plan_id) {
		this.plan_id = plan_id;
	}
	public String getPlan_title() {
		return plan_title;
	}
	public void setPlan_title(String plan_title) {
		this.plan_title = plan_title;
	}
	public Date getPlan_starting_time() {
		return plan_starting_time;
	}
	public void setPlan_starting_time(Date plan_starting_time) {
		this.plan_starting_time = plan_starting_time;
	}
	public Date getPlan_ending_time() {
		return plan_ending_time;
	}
	public void setPlan_ending_time(Date plan_ending_time) {
		this.plan_ending_time = plan_ending_time;
	}
	public String getPlan_describe() {
		return plan_describe;
	}
	public void setPlan_describe(String plan_describe) {
		this.plan_describe = plan_describe;
	}
	public Integer getPlan_status() {
		return plan_status;
	}
	public void setPlan_status(Integer plan_status) {
		this.plan_status = plan_status;
	}
	public String getPlan_userId() {
		return plan_userId;
	}
	public void setPlan_userId(String plan_userId) {
		this.plan_userId = plan_userId;
	}
	@Override
	public String toString() {
		return "Plan [plan_id=" + plan_id + ", plan_title=" + plan_title + ", plan_starting_time=" + plan_starting_time
				+ ", plan_ending_time=" + plan_ending_time + ", plan_describe=" + plan_describe + ", plan_status="
				+ plan_status + ", plan_userId=" + plan_userId + "]";
	}
	
	public Plan(Integer plan_id, String plan_title, Date plan_starting_time, Date plan_ending_time,
			String plan_describe, Integer plan_status, String plan_userId) {
		super();
		this.plan_id = plan_id;
		this.plan_title = plan_title;
		this.plan_starting_time = plan_starting_time;
		this.plan_ending_time = plan_ending_time;
		this.plan_describe = plan_describe;
		this.plan_status = plan_status;
		this.plan_userId = plan_userId;
	}
	public Plan() {
		super();
	}
	public Plan(String plan_title, Date plan_starting_time, Date plan_ending_time, String plan_describe,
			Integer plan_status, String plan_userId) {
		super();
		this.plan_title = plan_title;
		this.plan_starting_time = plan_starting_time;
		this.plan_ending_time = plan_ending_time;
		this.plan_describe = plan_describe;
		this.plan_status = plan_status;
		this.plan_userId = plan_userId;
	}
}