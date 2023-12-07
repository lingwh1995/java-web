package org.lanqiao.web.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;


public class UploadServlet extends HttpServlet {
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
		 * 上传三步
		 * 	1.得到工厂
		 * 	2.通过工厂创建解析器
		 * 	3.解析request,得到FileItem集合
		 * 	4.遍历FileItem集合,调用API完成文件的保存
		 */
		
		//1.创建工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//2.通过工厂创建解析器
		ServletFileUpload sfu = new ServletFileUpload(factory);
		try {
			List<FileItem> fileItemList = sfu.parseRequest(request);
			FileItem file1 = fileItemList.get(0);
			FileItem file2 = fileItemList.get(1);
			System.out.println("普通表单项:"+file1.getFieldName()+"="+file1.getString("utf-8"));
			System.out.println("文件表单项表单项:");
			System.out.println("Content-Type:"+file2.getContentType());
			System.out.println("size:"+file2.getSize());
			System.out.println("fileName:"+file2.getName());
			
			///保存文件
				//将文件保存到d盘下
			String root = this.getServletContext().getRealPath("/WEB-INF/files/");
			File destFile = new File("d:/白冰.jpg");
			try {
				file2.write(destFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		ServletInputStream in = request.getInputStream();
//		String string = IOUtils.toString(in);
//		System.out.println(string);
	}

}