package org.lnaqiao.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClassLoaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	}
	
	public static void main(String[] args) {
		//获取类加载器获取类路径的文件,不用依赖于ServletContext()就可以获取文件
		String path = ClassLoaderServlet.class.getClassLoader().getResource("a.txt").getPath();
		System.out.println(path);
	}
}
