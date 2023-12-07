package org.lanqiao.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.User;
import org.lanqiao.services.UserServices;

/**
 * 演示原生的ajax验证用户名是否已经被注册
 * @author ronin
 *
 */
public class AjaxValidateUsernameServlet extends HttpServlet {
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
		//2.接受用户名
		String username = request.getParameter("username");
		//3.调用service层的方法完成查询,返回值user
		User user = null;
		try {
			user = new UserServices().ValidateUserNameByObjectIsExist(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(user==null){
			//用户名不存在
			response.getWriter().print("0");
		}else{
			//用户名已经存在
			response.getWriter().print("1");
		}
	}

}