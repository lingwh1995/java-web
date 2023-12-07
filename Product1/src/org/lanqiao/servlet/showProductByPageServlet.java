package org.lanqiao.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.PageBean;
import org.lanqiao.entity.Product;
import org.lanqiao.services.ProductServices;

public class showProductByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		//1.获取currentPage
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		//2.固定每页显示的条数
		int pageSize = 3;
		//3.调用services层的方法完成分页查询,返回值:一个PageBean对象
		PageBean<Product> pageBean = null;
		try {
			pageBean = new ProductServices().queryProductByPage(currentPage,pageSize);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//3.将pageBean放入到request域中,请求转发到product_page.jsp
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("/views/product_page.jsp").forward(request, response);
	}

}
