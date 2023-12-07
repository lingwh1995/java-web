package org.lanqiao.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(urlPatterns="/UploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取表单文件字段
		Part part = req.getPart("pic");
		/*
		 * 从part中获取需要的数据
		 */
		//获取上传文件的MIME类型
		System.out.println(part.getContentType());
		//获取上传文件的字节数
		System.out.println(part.getSize());
		//获取文件字段名称
		System.out.println(part.getName());
		//获取头,这个头中包含了上传文件的名称
		System.out.println(part.getHeader("Content-Disposition"));
		//从头中截取出文件的名称
		//保存上传文件
		part.write("d:/a.jpg");
	}
}
