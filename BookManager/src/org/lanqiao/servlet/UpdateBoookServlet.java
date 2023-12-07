package org.lanqiao.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Book;
import org.lanqiao.services.IBookServices;
import org.lanqiao.services.impl.BookServicesImpl;

public class UpdateBoookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookId = request.getParameter("bookId");
		String bookName = request.getParameter("bookName");
		Double bookPrice = Double.parseDouble(request.getParameter("bookPrice"));
		Integer bookCount = Integer.parseInt(request.getParameter("bookCount"));
		Book book = new Book(bookId,bookName,bookPrice,bookCount);
		IBookServices bookServices = new BookServicesImpl();
		bookServices.upateBookById(bookId, book);
		response.sendRedirect(request.getContextPath()+"/QueryBooksServlet");
	}

}
