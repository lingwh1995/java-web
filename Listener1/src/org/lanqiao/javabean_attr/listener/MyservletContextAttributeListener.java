package org.lanqiao.javabean_attr.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * 演示ServletContextAttributeListener对象的创建和销毁
 * 作用:监听javabean中ServletContext中的属性的状态的变化(添加属性、删除属性、替换属性)
 * @author ronin
 *	 步骤:
 * 			1.创建一个类,实现ServletContextAttributeListener这个接口
 * 			2.重写接口中的方法
 */
public class MyservletContextAttributeListener implements ServletContextAttributeListener{

	/**
	 * 增加属性
	 */
	@Override
	public void attributeAdded(ServletContextAttributeEvent scab) {
		// TODO Auto-generated method stub
		System.out.println("往ServletContext域中添加了一个属性.....添加属性的名称是:"+scab.getName()+",属性值值是:"+scab.getValue());
	}

	/**
	 * 移除属性
	 */
	@Override
	public void attributeRemoved(ServletContextAttributeEvent scab) {
		// TODO Auto-generated method stub
		System.out.println("删除了ServletContext域中的一个属性.....被删除的属性的名称是:"+scab.getName()+",被删除的属性值是:"+scab.getValue());
	}

	/**
	 * 替换属性
	 */
	@Override
	public void attributeReplaced(ServletContextAttributeEvent scab) {
		// TODO Auto-generated method stub
		System.out.println("替换了ServletContext域中的一个属性.....被替换的属性的名称是:"+scab.getName()+",被替换的属性值值是:"+scab.getValue());
		
	}

}
