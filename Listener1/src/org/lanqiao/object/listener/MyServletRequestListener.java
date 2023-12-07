package org.lanqiao.object.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * 演示ServletRequestListenerServlet对象的创建和销毁
 * @author ronin
 *	 步骤:
 * 			1.创建一个类,实现ServletRequestListenerServlet这个接口
 * 			2.重写接口中的方法
 */
public class MyServletRequestListener implements ServletRequestListener{

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		System.out.println("ServletRequest对象创建了...");
	}
	
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		System.out.println("ServletRequest对象销毁了...");
	}


}
