package org.lanqiao.web.fifler;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 从application中获取map
 * 从request中获取当前访问客户的ip,进行统计工作,放到map中
 * @author ronin
 *
 */
public class IPFilter implements Filter{

	private ServletContext application;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		application = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/*
		 *  1.得到application中的map
		 *  2.从request获取当前客户端的IP地址
		 *  3.查看map中是否存在这个ip对应的访问地址,如果存在,把次数+1再放回去,如果不存在这个ip,说明是第一个访问本站,设置访问次数为1
		 *  4.把map再放回到application域中
		 *  5.放行
		 */
		
		//1.获取map
		Map<String,Integer> map = (Map<String, Integer>) application.getAttribute("map");
		//2.从request获取当前客户端的IP地址
		String ip = request.getRemoteAddr();
		/*
		 * 3.进行判断,看map中是否含有指定的值
		 */
		if(map.containsKey(ip)){
			//这个ip地址存在,获取上一次的ip地址的访问次数,并+1,再放回去
			Integer count = map.get(ip);
			map.put(ip, count+1);
		}else{
			//如果不存在,说明是第一次访问,设置访问次数为1
			map.put(ip, 1);
		}
		//4.把map再放回到application域中
		application.setAttribute("map", map);
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
