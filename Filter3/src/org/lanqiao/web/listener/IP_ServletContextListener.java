package org.lanqiao.web.listener;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 这个监听器的作用:在服务器启动的时候创建Map,并保存到ServletContext中
 *
 */
public class IP_ServletContextListener implements ServletContextListener {


	public void contextInitialized(ServletContextEvent sce)  { 
		//创建Map
		Map<String,Integer> map = new LinkedHashMap<String,Integer>();
		//获取ServletContext
		ServletContext application = sce.getServletContext();
		//把map保存到application中
		application.setAttribute("map", map);
	}
	
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

}
