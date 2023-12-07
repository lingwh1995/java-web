package org.lanqiao.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.domain.User;
import org.lanqiao.services.UserServices;

/**
 * 演示自动刷新
 * 演示统计登录次数
 * @author ronin
 *
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//初始化登陆次数
	@Override
	public void init() throws ServletException {
		//获取全局管理立者
		ServletContext application = this.getServletContext();
		//初始化次数
		application.setAttribute("count", 0);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//1.接受用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//2.调用userservices里面的login(username,password),返回值:User user 
		User user = null;
		try {
			user = new UserServices().login(username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("网络异常,清稍后再试？");
		}
		/**
		 * 演示自动刷新
		 * 演示自动统计登录次数
		 */
		//3.判断user是否为空
			//若为空写"用户名和密码不匹配"
		if(user==null) {
			System.out.println("用户名或密码错误！");
			//演示自动刷新
			response.setHeader("refresh", "3;url=https://www.baidu.com");
		}else {//若不为空写，xxx:欢迎回来
			//演示统计登录次数
			System.out.println(user.getUsername()+"登录成功！");
			//获取servletContext
			ServletContext application = this.getServletContext();
			//获取登录次数
			Integer count = (Integer)application.getAttribute("count");
			//登陆次数+1
			count++;
			application.setAttribute("count", count);
			System.out.println(count);
		}
	}

}