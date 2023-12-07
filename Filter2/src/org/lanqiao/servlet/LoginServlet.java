package org.lanqiao.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.constant.Constant;
import org.lanqiao.domain.User;
import org.lanqiao.service.UserService;

public class LoginServlet extends HttpServlet {
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
		//2.获取用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//3.调用service层的方法完成查询,返回值User对象
		User user;
		try {
			user = new UserService().login(username,password);
			//4.判断User对象是否为空
			if(user==null){
				//user为空 
				request.setAttribute("msg", "用户名和密码不匹配...");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				//注意:这里要加return,防止程序继续向下执行
				return;
			}else{
				//user不为空,则跳转到success.jsp
				request.getSession().setAttribute("user", user);
				
				/**
				 * 自动登录
				 */
				//判断是否勾选了自动登录选项,如果勾选了需要将用户名和密码放在Cookie中,写回浏览器
					//比较常量和变量是相等的时候,把常量放在equals()前面,可以避免空指针异常的发生
				if(Constant.IS_AUTO_LOGIN.equals(request.getParameter("autologin"))){
					System.out.println("自动登录已经勾选....");
					//如果勾选了自动登录选项,将用户名和密码放到Cookie中,并写回到浏览器
						//注意:Cookie不支持中文,这里要URLEncoding.encod()进行编码
					Cookie cookie = new Cookie("autologin",username+"-"+password);
						//将Cookie写回到浏览器要设置的几个属性
					cookie.setMaxAge(3600);//生命时长
					cookie.setPath(request.getContextPath()+"/");//Cookie路径
					response.addCookie(cookie);
				}
				
				/**
				 * 记住用户名
				 */
				//判断是否勾选了记住用户名,若勾选了记住用户名
				if(Constant.IS_AUTO_LOGIN.equals(request.getParameter("saveName"))){
					System.out.println("记住用户名已经勾选....");
					//如果勾选了自动登录选项,将用户名和密码放到Cookie中,并写回到浏览器
					Cookie cookie = new Cookie("savename",URLEncoder.encode(username,"utf-8"));
						//将Cookie写回到浏览器要设置的几个属性
					cookie.setMaxAge(3600);//生命时长
					cookie.setPath(request.getContextPath()+"/");//Cookie路径
					response.addCookie(cookie);
				}
				
				
				//5.页面重定向,跳转到success.jsp
				response.sendRedirect(request.getContextPath()+"/success.jsp");
				System.out.println("查询用户成功...");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("查询用户失败...");
		}
	}

}