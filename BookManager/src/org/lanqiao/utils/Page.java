package org.lanqiao.utils;

import java.util.List;

import org.lanqiao.entity.Book;

public class Page {
	private Integer currentPage;
	private Integer pageSize;
	private Integer totalCount;
	private Integer totalPage;
	private List<Book> bookList;
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Page(Integer currentPage, Integer pageSize, Integer totalCount, Integer totalPage, List<Book> bookList) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.bookList = bookList;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
		this.totalPage = totalCount%pageSize ==0?totalCount/pageSize:totalCount/pageSize+1;
	}
	public List<Book> getBookList() {
		return bookList;
	}
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	
}
