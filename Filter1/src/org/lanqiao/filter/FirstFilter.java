package org.lanqiao.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 演示FiLter入门案例 
 * @author ronin
 * 步骤:
 * 		1.编写一个类,实现Filter接口,重写方法(或直接新建 一个Filter)
 * 		2.在web.xml配置Filter信息
 */
public class FirstFilter implements Filter{

	/**
	 * 关于init()方法:需要注意的是,这个方法是在项目启动或者说服务器启动时就执行的,不是用户发送请求时执行的,所以
	 * 要查看init()方法中输出的内容,需要在前面的日志文件中找,而不是用户发送请求之后再去查看输出的内容
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("FirstFilter初始化....");
		/**
		 * 获取filter初始化参数
		 */
		String param_value = filterConfig.getInitParameter("param_name");
		System.out.println(param_value);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//放行之前过滤请求
		System.out.println("FirstFilter收到了请求....");
		
		//放行,不放行的话请求之能到达 FirstFilter这个过滤器这里,不能到达处理请求的Servlet
		chain.doFilter(request, response);
		
		//放行之后过滤响应
		System.out.println("FirstFilter收到了响应....");
	}

	@Override
	public void destroy() {
		System.out.println("FirstFilter销毁....");
	}

}
