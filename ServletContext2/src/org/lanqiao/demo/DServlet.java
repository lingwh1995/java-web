package org.lanqiao.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * ServletContext增强
 * 本类演示使用ServletContext获取资源路径(得到的是有盘符的路径)
 *
 */
public class DServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.获取ServeltContext
			//方式一
//		ServletContext context = this.getServletConfig().getServletContext();
			//方式二
		ServletContext application = this.getServletContext();
		String path1 = application.getContextPath();//得到项目名
		System.out.println(path1);
		System.out.println("---------------------------------");
		String realPath = application.getRealPath("/index.jsp");
		//得到带有盘符的实际资源路径：
		//D:\develop\apache-tomcat-7.0.42\wtpwebapps\CZ_ServletContextDemo1\index.jsp
		System.out.println(realPath);
		//通过ServletContext得到真实路径，然后和IO配合产生一个输入流
		InputStream in = new FileInputStream(realPath);
		System.out.println("---------------------------------");
		//有一个方法，可以一步完成上面的操作，实现直接通过Servlet获取输入流
		/*
		 * 获取资源的路径后，再创建输入输出流
		 */
		InputStream in1 = this.getServletContext().getResourceAsStream("/index.jsp");
		
		/*
		 * 获取当前路径下所有资源(WEB-INF目录下的资源)
		 */
		Set<String> paths = this.getServletConfig().getServletContext().getResourcePaths("/WEB-INF");
		System.out.println(paths);
		//输出结果为：[/WEB-INF/lib/, /WEB-INF/classes/, /WEB-INF/web.xml]
		//注意：1.仅仅是资源名称而不是资源路径   2.只能拿到lib，而不能拿到lib下的a.txt
		InputStream in2 = this.getServletContext().getResourceAsStream("/WEB-INF/lib/a.txt");
		//通过测试发现，	WEB-INF下的文件是无法通过浏览器访问的
	}

}
