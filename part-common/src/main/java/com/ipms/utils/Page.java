package com.ipms.utils;

public class Page<T> {
	
	private Integer itemsTotal; // 计划总数
	private Integer pageNumber; // 总共多少页
	private Integer amountPerPage; // 每页显示的计划数
	
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
