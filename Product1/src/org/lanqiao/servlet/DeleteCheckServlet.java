package org.lanqiao.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.services.ProductServices;

public class DeleteCheckServlet extends HttpServlet {
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
		//2.获取来自前台的多个pid,调用services层的根据id删除的方法,实现删除选中商品的操作
		String[] pids = request.getParameterValues("pid");
		for(String pid:pids){
			try {
				new ProductServices().deleteProductById(pid);
				System.out.println("删除选中商品成功,被删除的商品的id是:"+Arrays.toString(pids));
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("删除选中商品失败...");
			}
		}
		//3.转发到查询页面
		request.getRequestDispatcher("/QueryAllProductServlet").forward(request, response);;
	}

}
