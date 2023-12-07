package org.lanqiao.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理乱码
		request.setCharacterEncoding("utf-8");
		//验证码
		/*
		 * 1.获取session中验证码和用户输入的验证码
		 * 2.比较
		 * 3.正确向下运行，错误保存错误信息并转发
		 */
		String sessioncode = (String)request.getSession().getAttribute("sesson_code");
		String paramcode = request.getParameter("verifycode");
		System.out.println(paramcode.equalsIgnoreCase(sessioncode));
		if(!paramcode.equalsIgnoreCase(sessioncode)) {
			request.setAttribute("msg", "验证码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;//防止代码向下执行
		}
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username.equals("lwh")) {
			//如果用户为lwh,则证明登录成功，重定向到succ1.jsp
			//并将用户名保存在session中
			HttpSession session = request.getSession();
			session.setAttribute("uname", username);
			Cookie c = new Cookie("uname",username);
			c.setMaxAge(60*60*24);//设置cookie命长为1天
			response.addCookie(c);
			response.sendRedirect("/CZ_SessionDemo2/succ1.jsp");
		}else {
			//如果用户不是lwh，转发到首页，并传递错误信息
			request.setAttribute("msg", "用户名或密码不正确");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
