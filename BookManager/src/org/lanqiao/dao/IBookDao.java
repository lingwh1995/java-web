package org.lanqiao.dao;

import java.util.List;

import org.lanqiao.entity.Book;

public interface IBookDao {
	//查询所有图书
	public abstract List<Book> queryBooks();
	//分页查询所有图书
	public abstract List<Book> queryBooksByPage(Integer currentPage,Integer PageSize);
	//查询总记录数
	public abstract Integer totalCount();
	//根据编号删除图书
	public abstract boolean deleteBookById(Integer bookId);
	//按图书名称查询(模糊查询)
	public abstract List<Book> queryBooksByName(String bookName);
	//按图书编号查询(精确查询)
	public abstract List<Book> queryBookById(Integer bookId);
	//是否存在
	public abstract boolean isExit(Integer bookId);
	//更新图书信息
	public abstract boolean upateBookById(String bookId,Book book);
	
}
