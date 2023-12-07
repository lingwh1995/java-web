package org.lanqiao.demo;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerifyCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.生成图片
		 * 2.把图片上的文本保存到session中
		 * 3.把图片响应到客户端
		 */
		VerifyCode vc = new VerifyCode();
		BufferedImage image = vc.getImage();
		String text = vc.getText();
		request.getSession().setAttribute("sesson_code", text);
		VerifyCode.output(image, response.getOutputStream());//把图片放在输出流中
	}

}
