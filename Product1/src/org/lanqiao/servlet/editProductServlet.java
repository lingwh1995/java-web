package org.lanqiao.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.lanqiao.entity.Product;
import org.lanqiao.services.ProductServices;

/**
 * 根据商品的id修改商品
 * @author ronin
 *
 */
public class editProductServlet extends HttpServlet {
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
		//使用beanUtils封装数据
		Product product = new Product();
		try {
			BeanUtils.populate(product, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		try {
			new ProductServices().updateProductById(product);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("更新商品信息失败...");
		}
		request.getRequestDispatcher("/QueryAllProductServlet").forward(request, response);
	}

}
