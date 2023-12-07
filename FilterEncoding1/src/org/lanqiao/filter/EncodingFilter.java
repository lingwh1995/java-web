package org.lanqiao.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * 过滤器+装饰者模式 解决乱码问题
 * @author ronin
 *
 */
public class EncodingFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 装饰者模式解决乱码问题
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		//1.强转
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		//2.放行 
			//将包装过的request放行
		chain.doFilter(new MyRequest(request), response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}


/**
 * 装饰者模式书写步骤:
		1.要求装饰者(MyRequest)和被装饰者(HttpServletRequest)实现同一个接口或者继承同一个类(HttpServletRequestWrapper)
		2.创建装饰者的构造器,并要求装饰者中要有被装饰者的引用
		3.对需要加强方法进行加强
		4.对不需要加强的方法调用原来的方法即可
 * @author ronin
 *
 */

//1.要求装饰者(MyRequest)和被装饰者(HttpServletRequest)实现同一个接口或者继承同一个类(HttpServletRe
class MyRequest extends HttpServletRequestWrapper{
	private HttpServletRequest request;

	//2.创建装饰者的构造器,并要求装饰者中要有被装饰者的引用
	public MyRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	
	//加强getParameter(String name)这个方法
	@Override
	public String getParameter(String name) {
		/*
		 * 根据请求点的方式的不同,处理的方式也不同
		 * 若是get()请求:
		 * 		new String(value.getByte("iso8859-1"),"utf-8")
		 * 若是post请求:
		 * 		request.setCharacterEncoding("utf-8");
		 * 最后将包装过的request对象,传递给Servlet即可
		 */
		String method = request.getMethod();
		if("get".equalsIgnoreCase(method)){
			//get请求
			String value = request.getParameter(name);
			try {
				return new String(value.getBytes("iso8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}else if("post".equalsIgnoreCase(method)){
			try {
				request.setCharacterEncoding("utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return request.getParameter(name);
		}
		return super.getParameter(name);
	}
}



