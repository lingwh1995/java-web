package org.lanqiao.services.impl;

import java.util.List;

import org.lanqiao.dao.IBookDao;
import org.lanqiao.dao.impl.BookDaoImpl;
import org.lanqiao.entity.Book;
import org.lanqiao.services.IBookServices;

public class BookServicesImpl implements IBookServices{
	IBookDao bookDao = new BookDaoImpl();
	@Override
	public List<Book> queryBooks() {
		return bookDao.queryBooks();
	}

	@Override
	public List<Book> queryBooksByName(String bookName) {
//		System.out.println(bookDao.queryBooksByName(bookName));
		return bookDao.queryBooksByName(bookName);
	}

	@Override
	public List<Book> queryBookById(Integer bookId) {
		return bookDao.isExit(bookId)?bookDao.queryBookById(bookId):null;
	}


	@Override
	public boolean deleteBookById(Integer bookId) {
		return bookDao.deleteBookById(bookId);
	}

	@Override
	public List<Book> queryBooksByPage(Integer currentPage, Integer PageSize) {
		return bookDao.queryBooksByPage(currentPage, PageSize);
	}

	@Override
	public Integer totalCount() {
		return bookDao.totalCount();
	}

	@Override
	public boolean upateBookById(String bookId, Book book) {
		return bookDao.upateBookById(bookId, book);
	}

}
