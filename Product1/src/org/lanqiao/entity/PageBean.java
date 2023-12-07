package org.lanqiao.entity;

import java.util.List;

/**
 * 存放分页信息的类:有五个属性,四个通过查询或者计算获取,第五个通过计算获取
 * @author ronin
 * @param <T>
 *
 */
public class PageBean<T> {
	private List<T> list;//当前页内容			查询
	private int currentPage;//当前页码		传递
	private int pageSize;//每页显示的的条数		固定
	private int toltalCount;//总条数 			查询
	private int totalPage;//总页数			计算
	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageBean(List<T> list, int currentPage, int pageSize, int toltalCount) {
		super();
		this.list = list;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.toltalCount = toltalCount;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getToltalCount() {
		return toltalCount;
	}
	public void setToltalCount(int toltalCount) {
		this.toltalCount = toltalCount;
	}
	/**
	 * 获取总页数:不需要设置setTotalPage()方法了,因为这个值是计算出来的。
	 * @return
	 */
	public int getTotalPage() {
		//
		return (int)Math.ceil(toltalCount*1.0/pageSize);
	}
	
	/**
	 * 这个方法不需要有了
	 */
//	public void setTotalPage(int totalPage) {
//		this.totalPage = totalPage;
//	}
	
}
