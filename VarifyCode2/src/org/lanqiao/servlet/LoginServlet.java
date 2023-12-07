package org.lanqiao.servlet;

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
		/**
		 * 逻辑:
		 * 在这个包中VerifyCode这个类是产生验证码的类,在VerifyCodeServlet这个servlet中调用这个VerifyCode类的方法
		 * 把图片通过流的形式发送到前台,前台访问VerifyCodeServlet即可自动获取
		 * 把图片中的文本放在session，在验证登录的servlert中通过session.getAttribute(xxx);获取验证码中的文本
		 */
		response.setContentType("text/html;charset=UTF-8");
		String code = (String)request.getSession().getAttribute("code");
		System.out.println(code);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
