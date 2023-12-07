package org.lanqiao.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 过滤user目录下的user.jsp
 * @author ronin
 *
 */
public class UserFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/*
		 * 1.得到session
		 * 2.判断域中是否存在admin,如果存在,放行
		 * 3.判断session中是否存在username如果存在,放行,否则,返回到login.jsp
		 */
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String admin = (String) req.getSession().getAttribute("admin");
		if(admin!=null){
			chain.doFilter(request, response);
			return;
		}
		
		String username = (String) req.getSession().getAttribute("username");
		if(username!=null){
			chain.doFilter(request, response);
		}else{
			System.out.println("您不是管理员,也不是会员...");
			resp.sendRedirect(req.getContextPath()+"/index.jsp");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
