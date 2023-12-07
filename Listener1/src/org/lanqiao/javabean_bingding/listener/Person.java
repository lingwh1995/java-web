package org.lanqiao.javabean_bingding.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * 演示监听session中的Javabean的状态:监听JavaBean的绑定和解绑
 * 注意:这个比较特殊,并不是编写一个单独的Listener实现一个接口去实现监听,而是需要通过JavaBean来实现一个接口,来实现监听功能
 * 绑定:把JavaBean放到Session中,解绑:把JavaBean从Session中移除
 * @author ronin
 *	 步骤:
 * 			1.创建一个JavaBean,实现HttpSessionBindingListener这个接口
 * 			2.实现接口中的方法
 */
public class Person implements HttpSessionBindingListener{
	private int id;
	private String name;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 绑定到了Session中
	 */
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		System.out.println("Pserson对象绑定到了Session中....");
		//获取session中的javabean对象,通过这个方法的event参数
		System.out.println("session中的属性名:"+event.getName()+"---"+"session中的属性名值:"+event.getValue());
	}
	
	/**
	 * 从Session中移除
	 */
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		System.out.println("Pserson对象绑定到了从Session中移除了....");
		
	}
	
	
}
