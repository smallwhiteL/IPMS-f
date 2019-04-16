package com.ipms.utils;

public class Page {
	
	private Integer itemsTotal; // 计划总数
	private Integer pageNumber; // 总共多少页
	private Integer amountPerPage; // 每页显示的计划数
	private Integer start_row; // 每页的起始行
	private Integer page_index; // 页号 
	
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
