package org.lanqiao.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EncodingFilter implements Filter {

    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String method = req.getMethod();
		if("get".equalsIgnoreCase(method)){
			/**
			 * 处理get请求乱码问题
			 * 装饰request
			 * 		1.写一个request的装饰类
			 * 		2.在放行时使用我们自己的request
			 * 这一块二相当于掉包了HttpServletRequest这个类,换成我们自己装饰过的类
			 */
			WarrpRequest warrpRequest = new WarrpRequest(req);
			/**
			 * 处理get响应的乱码问题
			 */
			response.setContentType("text/html;charset=utf-8");
			chain.doFilter(warrpRequest, response);
		}else if("post".equalsIgnoreCase(method)){
			/**
			 * 处理post请求的乱码问题
			 */
			request.setCharacterEncoding("utf-8");
			/**
			 * 处理post响应的乱码问题
			 */
			response.setContentType("text/html;charset=utf-8");
			chain.doFilter(request, response);
		}
			
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

	@Override
	public void destroy() {
		
	}

}
