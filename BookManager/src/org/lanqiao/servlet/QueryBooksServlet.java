package org.lanqiao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Book;
import org.lanqiao.services.IBookServices;
import org.lanqiao.services.impl.BookServicesImpl;
import org.lanqiao.utils.Page;


public class QueryBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("utf-8");
		IBookServices bookServices = new BookServicesImpl();
//		List<Book> bookList = bookServices.queryBooks();
//		request.setAttribute("bookList", bookList);
//		request.getRequestDispatcher("index.jsp").forward(request, response);
		String currentPageStr = request.getParameter("currentPage");
		int currentPage = currentPageStr==null?1:Integer.parseInt(currentPageStr);
		System.out.println(currentPage);
		int pageSize = 5;
		List<Book> bookList = bookServices.queryBooksByPage(currentPage, pageSize);
		request.setAttribute("bookList", bookList);
		Page page = new Page();
		page.setTotalCount(bookServices.totalCount());
		page.setCurrentPage(currentPage);
		page.setPageSize(pageSize);
		page.setBookList(bookList);
		request.setAttribute("mypage", page);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
