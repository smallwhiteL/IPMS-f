package com.ipms.pojo;
/**
 * 该类用于前后端传输的计划的内容格式化为String
 * @author smallwhiteL
 *
 */
public class FormatPlanToJson {
	
	private String plan_id;
	private String plan_title;
	private String plan_starting_time;
	private String plan_ending_time;
	private String plan_describe;
	private String plan_status;
	
	public FormatPlanToJson() {
		super();
	}
	public FormatPlanToJson(String plan_title, String plan_starting_time, String plan_ending_time, String plan_describe,
			String plan_status) {
		super();
		this.plan_title = plan_title;
		this.plan_starting_time = plan_starting_time;
		this.plan_ending_time = plan_ending_time;
		this.plan_describe = plan_describe;
		this.plan_status = plan_status;
	}
	public FormatPlanToJson(String plan_id, String plan_title, String plan_starting_time, String plan_ending_time,
			String plan_describe, String plan_status) {
		super();
		this.plan_id = plan_id;
		this.plan_title = plan_title;
		this.plan_starting_time = plan_starting_time;
		this.plan_ending_time = plan_ending_time;
		this.plan_describe = plan_describe;
		this.plan_status = plan_status;
	}
	
	@Override
	public String toString() {
		return "FormatPlanToJson [plan_id=" + plan_id + ", plan_title=" + plan_title + ", plan_starting_time="
				+ plan_starting_time + ", plan_ending_time=" + plan_ending_time + ", plan_describe=" + plan_describe
				+ ", plan_status=" + plan_status + "]";
	}
	public String getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(String plan_id) {
		this.plan_id = plan_id;
	}
	public String getPlan_title() {
		return plan_title;
	}
	public void setPlan_title(String plan_title) {
		this.plan_title = plan_title;
	}
	public String getPlan_starting_time() {
		return plan_starting_time;
	}
	public void setPlan_starting_time(String plan_starting_time) {
		this.plan_starting_time = plan_starting_time;
	}
	public String getPlan_ending_time() {
		return plan_ending_time;
	}
	public void setPlan_ending_time(String plan_ending_time) {
		this.plan_ending_time = plan_ending_time;
	}
	public String getPlan_describe() {
		return plan_describe;
	}
	public void setPlan_describe(String plan_describe) {
		this.plan_describe = plan_describe;
	}
	public String getPlan_status() {
		return plan_status;
	}
	public void setPlan_status(String plan_status) {
		this.plan_status = plan_status;
	}

}
