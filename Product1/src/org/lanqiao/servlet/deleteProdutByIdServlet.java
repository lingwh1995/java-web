package org.lanqiao.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.services.ProductServices;

public class deleteProdutByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String pid = request.getParameter("pid");
		try {
			boolean flag = new ProductServices().deleteProductById(pid);
			if(flag){
				System.out.println("删除商品成功...");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("删除商品失败...");
		}
		request.getRequestDispatcher("/QueryAllProductServlet").forward(request, response);
	}

}