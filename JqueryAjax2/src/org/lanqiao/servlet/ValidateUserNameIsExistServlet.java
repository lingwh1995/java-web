package org.lanqiao.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.User;
import org.lanqiao.services.UserServices;

public class ValidateUserNameIsExistServlet extends HttpServlet {
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
		//2.获取参数值
		String username = request.getParameter("username");
		//3.调用servicec层的方法
		User user = null;
		try {
			user = new UserServices().queryUserByName(username);
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().print("通过名字查询失败...");
		}
		//4.判断用户名是否已经存在
		if(user!=null){ 
			//向页面返回信息:用户名已经存在
			response.getWriter().print("1");
		}else{
			//向页面返回信息:用户名不存在
			response.getWriter().print("0");
		}
	}

}
