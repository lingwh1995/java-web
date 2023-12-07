package org.lanqiao.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.servlet.VerifyCode;

public class VerifyCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		/*
		 * 1.生成图片
		 * 2.把图片上的文本保存到session中
		 * 3.把图片响应到客户端
		 */
		VerifyCode vc = new VerifyCode();
		//获取验证码图片
		BufferedImage image = vc.getImage();
		VerifyCode.output(image, response.getOutputStream());//把图片放在输出流中
		//获取验证码图片中的文本
		String text = vc.getText();
		//把获取到的文本放到session中
		request.getSession().setAttribute("code", text);
	}

}