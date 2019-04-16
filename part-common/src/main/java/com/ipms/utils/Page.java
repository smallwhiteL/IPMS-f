package com.ipms.utils;

import java.util.List;

import com.ipms.pojo.FormatPlanToJson;
/**
 * 分页模型
 * @author ASUS
 *
 */
public class Page {
	
	private Integer itemsTotal; // 计划总数
	private Integer pageNumber; // 总共多少页
	private Integer amountPerPage; // 每页显示的计划数
	private Integer page_index; // 页号
	private List<FormatPlanToJson> formatPlanToJsons; // 获得的格式化后的计划
	
	public List<FormatPlanToJson> getFormatPlanToJsons() {
		return formatPlanToJsons;
	}
	public void setFormatPlanToJsons(List<FormatPlanToJson> formatPlanToJsons) {
		this.formatPlanToJsons = formatPlanToJsons;
	}
	public Integer getPage_index() {
		return page_index;
	}
	public void setPage_index(Integer page_index) {
		this.page_index = page_index;
	}
	public Integer getItemsTotal() {
		return itemsTotal;
	}
	public void setItemsTotal(Integer itemsTotal) {
		this.itemsTotal = itemsTotal;
	}
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	public Integer getAmountPerPage() {
		return amountPerPage;
	}
	public void setAmountPerPage(Integer amountPerPage) {
		this.amountPerPage = amountPerPage;
	}
	
	
}
