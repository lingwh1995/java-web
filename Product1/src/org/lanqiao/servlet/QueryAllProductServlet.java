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

public class QueryAllProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		ProductServices productServices  = new ProductServices();
		//1.调用services层中的方法,查询所有商品
		List<Product> productList  = null;
		try {
			productList = productServices.queryAllProduct();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//2.将list放入request域中
		request.setAttribute("productList", productList);
		//3.请求转发
		request.getRequestDispatcher("/views/product_list.jsp").forward(request, response);
	}

} 