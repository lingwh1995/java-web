package org.lanqiao.object.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 演示HttpSessionListener对象的创建和销毁
 * 作用:
 * @author ronin
 *	 步骤:
 * 			1.创建一个类,实现HttpSessionListener这个接口
 * 			2.重写接口中的方法
 */
public class MyHttpSessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("HttpSessionListener对象创建了....");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("HttpSessionListener对象销毁了....");
	}

}
