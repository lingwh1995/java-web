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

public class QueryProductByConditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.设置编码  
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		//2.设置两个参数
		String pname = request.getParameter("pname");
		String keyword = request.getParameter("keyword");
		//3.调用service层方法完成操作,返回list
		List<Product> productList = null;
		try {
			productList = new ProductServices().QueryProductByCondition(pname,keyword);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("多条件查询商品失败...");
		}
		//4.将list放到request域中,请求转发
		request.setAttribute("productList", productList);
		request.getRequestDispatcher("/views/product_list.jsp").forward(request, response);
	}

}
