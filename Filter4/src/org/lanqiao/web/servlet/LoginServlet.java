package org.lanqiao.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		/**
		 * 1.获取用户名,判断用户名是否包含lanqiao
		 * 		包含就是管理员
		 * 		不包含就是普通会员
		 * 2.把登录的用户名称保存到session中
		 * 3.成功之后转发到index.jsp
		 */
		String username = request.getParameter("username");
		if(username!=""&& username!=null){
			if(username.contains("lanqiao")){
				//包含就是管理员
				request.getSession().setAttribute("admin", username);
			}else{
				//不包含就是普通会员
				request.getSession().setAttribute("username", username);
			}
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else{
			System.out.println("您输入的用户名为空,请重新输入...");
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
	}

}