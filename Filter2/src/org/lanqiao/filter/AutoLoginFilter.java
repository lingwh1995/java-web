package org.lanqiao.filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.domain.User;
import org.lanqiao.service.UserService;
import org.lanqiao.utils.CookieUtils;

/**
 * 实现自动登录的过滤器
 * url-pattern: <url-pattern>/*</url-pattern>
 * @author ronin
 *
 */
public class AutoLoginFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("过滤器开始工作.....");
		/*
		 * 1.强转:
		 * 		把ServletRequest强制转换为HttpServletRequest,这样才能获取到Cookie
		 * 		把ServletResponse强制转换为HttpServletResponse,这样才能获取到Cookie
		 * 只有强制转换数据类型后,才能调用指定的方法,否则不可以调用指定的方法
		 */
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		//2.完成自动 登录
		//2.1判断session中有无登录用户,没有的情况下才会 自动登录
		User login_user = (User) request.getSession().getAttribute("user");
		if(login_user==null){
			//session没有已经登录的用户,需要自动登录
			//2.2判断访问的资源是否和登录注册相关,没有才自动登录
			String path = request.getRequestURI();
			if(!path.contains("/login")){
				//2.3获取Cookie(使用CookieUtisl工具类来获取)
				Cookie[] cookies = request.getCookies();
				Cookie cookie = CookieUtils.getCookByName("autologin", cookies);
				//3.判断Cookie是否为空
				if(cookie!=null){
					//若不为空,获取值(username和password),调用service完成登录,判断user是否未为空,为空则不放入session
					//从Cookie中获取username和password
					String username = cookie.getValue().split("-")[0];
					String password = cookie.getValue().split("-")[1];
					User user;
					try {
						//调用service完成登录
						user = new UserService().login(username, password);
						//如果user不为空,则将user放入session中
						if(user!=null){
							request.getSession().setAttribute("user", user);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		}
		}
		//4.放行
		chain.doFilter(req, resp);
		System.out.println("过滤器完成工作.....");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
