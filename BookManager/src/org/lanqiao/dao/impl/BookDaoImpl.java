package org.lanqiao.dao.impl;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.lanqiao.dao.IBookDao;
import org.lanqiao.entity.Book;
import org.lanqiao.utils.DataSourceUtils;

public class BookDaoImpl implements IBookDao{
	QueryRunner DBUtils = new QueryRunner(DataSourceUtils.getDataSource());
	@Override
	public List<Book> queryBooks() {
		String sql = "select * from book";
		List<Book> bookList = null ;
		try {
			bookList = DBUtils.query(sql, new BeanListHandler<>(Book.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookList;
	}
	@Override
	public List<Book> queryBooksByName(String bookName) {
		String sql = "select * from book where bookName like ?";
		Object[] params = {"%"+bookName+"%"};
		List<Book> bookList = null ;
		try {
			bookList = DBUtils.query(sql,new BeanListHandler<>(Book.class), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookList;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Book> queryBookById(Integer bookId) {
		String sql = "select * from book where bookId = ?";
		Object[] params = {bookId};
		List<Book> bookList = null ;
		try {
			bookList = DBUtils.query(sql, params,new BeanListHandler<>(Book.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookList;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean isExit(Integer bookId) {
		boolean flag = false;
		String sql = "select * from book where bookId = ?";
		Object[] params = {bookId};
		List<Book> bookList = null ;
		try {
			bookList = DBUtils.query(sql, params,new BeanListHandler<>(Book.class));
			if(bookList!=null) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	@Override
	public boolean deleteBookById(Integer bookId) {
		boolean flag = false;
		String sql = "delete from book where bookId = ?";
		Object[] params = {bookId};
		int count;
		try {
			count = DBUtils.update(sql, params);
			if(count>0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	@Override
	public List<Book> queryBooksByPage(Integer currentPage, Integer PageSize) {
		String sql = "select * from (select rownum as rn,b.* from book b where rownum<=?*?) where rn>(?-1)*?";
		Object[] params = {currentPage,PageSize,currentPage,PageSize};
		List<Book> bookList = null;
		try {
			bookList = DBUtils.query(sql,new BeanListHandler<>(Book.class), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookList;
	}
	@Override
	public Integer totalCount() {
		String sql = "select count(1) from book";
		Integer count = 0;
		try {
			String countStr = DBUtils.query(sql,new ScalarHandler()).toString();
			 count = Integer.parseInt(countStr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	@Override
	public boolean upateBookById(String bookId,Book book) {
		boolean flag = false;
		String sql = "update book set bookName=? ,bookPrice =? ,bookCount=? where bookId =?";
		Object[] params = {book.getBookName(),book.getBookPrice(),book.getBookCount(),bookId};
		int upadateCount = -1;
		try {
			upadateCount = DBUtils.update(sql, params);
			if(upadateCount>0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
}
