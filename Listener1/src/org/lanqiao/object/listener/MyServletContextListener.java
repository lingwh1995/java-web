package org.lanqiao.object.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 演示创建一个ServletContextListener监听器
 * 作用:当项目启动时需要做一些初始化操作,如Spring项目启东时读取配置文件的内容
 * 		步骤:
 * 			1.创建一个类,实现ServletContextListener这个接口
 * 			2.重写接口中的方法
 * @author ronin
 *
 */
public class MyServletContextListener implements ServletContextListener{

	/**
	 * 监听ServletContex的对象创建
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("--------------------------------------------------");
		System.out.println("ServletContextListener对象创建了...");
		System.out.println("--------------------------------------------------");
	}

	/**
	 * ServletContext对象的销毁
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("--------------------------------------------------");
		System.out.println("ServletContextListener对象销毁了...");
		System.out.println("--------------------------------------------------");
	}

}
