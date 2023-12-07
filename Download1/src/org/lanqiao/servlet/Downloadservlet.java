package org.lanqiao.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.lanqiao.utils.DownLoadUtils;

import sun.nio.ch.IOUtil;

public class Downloadservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	/**
	 * 文件下载Servlet v1.0 
	 * 使用commons-io工具简化操作(需要导入commons-io的jar包)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//1.获取需要下载的文件名称
		String fileName = request.getParameter("name");
		//2.设置文件的mimeType
		ServletContext application = this.getServletContext();
			//通过文件名获取文件的mimeType
		String mimeType = application.getMimeType(fileName);
			//设置文件的mimeType
		response.setContentType(mimeType);
		
		//2.设置下载的头信息
			//如果文件名中含有中文,下面的代码无法实现下载
		//response.setHeader("content-disposition", "attachment;fileName="+fileName);
			//通过工具类可以实现中文文件名实现下载
		String new_fileName = DownLoadUtils.getName(request.getHeader("user-agent"), fileName);
			//注意:下面是"attachment;filname="...不是"attachment;filName=",filname为固定写法
		response.setHeader("content-disposition", "attachment;filname="+new_fileName);
		
		//3.设置对拷流
			//获取输入流
		InputStream in = application.getResourceAsStream("/resource/"+fileName);
			//获取输出流
		ServletOutputStream out = response.getOutputStream();
		//不使用common-io优化
		/*
		int len = 1;
		byte[] bs = new byte[1024];
		while((len=in.read(bs))!=-1) {
			out.write(bs, 0, len);
		}
		*/
		//使用common-io优化
		IOUtils.copy(in, out);
			//关闭流
		out.close();//不关闭也可以,浏览器会自动关
		in.close();
	}

}