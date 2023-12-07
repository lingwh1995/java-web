package org.lanqiao.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Product;
import org.lanqiao.services.ProductServices;

/**
 * 通过id获取商品
 * @author ronin
 *
 */
public class QueryProdutByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("pid");
		Product product = null;
		try {
			product = new ProductServices().queryProductById(id);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("根据学号查询失败...");
		}
		request.setAttribute("product", product);
		request.getRequestDispatcher("/views/editProduct.jsp").forward(request, response);
	}

}