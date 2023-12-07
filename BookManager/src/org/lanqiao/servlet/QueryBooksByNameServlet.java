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


public class QueryBooksByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("utf-8");
		String bookName = request.getParameter("bookName");
		IBookServices bookServices = new BookServicesImpl();
		List<Book> book = bookServices.queryBooksByName(bookName);
		request.setAttribute("bookList", book);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
		

}
