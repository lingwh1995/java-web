package org.lanqiao.utils;

import java.util.List;

import org.lanqiao.entity.Student;

//分页帮助类
public class Page {

	//第几页
	private int currentPage;
	//页面大小
	private int pageSize;
	//总页数
	private int totalPage;
	//总数据量
	private int totalCount;
	//当前页的数据集合
	private List<Student> students;
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Page(int currentPage, int pageSize, int totalPage, int totalCount, List<Student> students) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalPage = totalPage;
		this.totalCount = totalCount;
		this.students = students;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	//先写这个
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	//再写这个
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		//程序执行到这里，已经设置好了数据量、页面大小
		//自动计算总页数
		this.totalPage = this.totalCount % this.pageSize ==0?this.totalCount / this.pageSize:this.totalCount / this.pageSize+1;
	}
	
	
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public int getTotalPage() {
		return totalPage;
	}
	
	//注意：总页数不需要set方法，它是根据:总数据量+页面大小 自动计算出来的
//	public void setTotalPage(int totalPage) {
//		this.totalPage = totalPage;
//	}
}
