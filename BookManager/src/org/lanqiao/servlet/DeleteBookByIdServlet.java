package org.lanqiao.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.services.IBookServices;
import org.lanqiao.services.impl.BookServicesImpl;

/**
 * Servlet implementation class DeleteBookByIdServlet
 */
public class DeleteBookByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("utf-8");
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		IBookServices bookServices = new BookServicesImpl();
		boolean isDelete = bookServices.deleteBookById(bookId);
		if(isDelete) {
			System.out.println("删除成功 ！");
		}else {
			System.out.println("删除失败");
		}
		response.sendRedirect(request.getContextPath()+"/QueryBooksServlet");
	}
	
}
