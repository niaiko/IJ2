package com.cnaps.pagination;

import java.util.List;

public class PageResponse<T> {
	private List<T> list;
	private int totalPages;
	
	public PageResponse(List<T> list, int totalPages) {
		super();
		this.list = list;
		this.totalPages = totalPages;
	}
	
	public List<T> getList() {
		return list;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
}
