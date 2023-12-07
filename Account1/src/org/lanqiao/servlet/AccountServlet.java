package org.lanqiao.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.services.AccountServices;

public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.设置编码
		response.setContentType("text/html;charset=UTF-8");
		//2.获取三个参数
		String fromUser = request.getParameter("fromuser");
		String toUser = request.getParameter("touser");
		String money = request.getParameter("money");
		//3.调用services层的方法完成转账方法完成操作
		AccountServices services = new AccountServices();
		try {
			services.account(fromUser,toUser,money);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("转账失败...");
		}
		//4.打印信息
		System.out.println("转账成功...");
	}

}