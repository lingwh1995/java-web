package org.lanqiao.demo;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.beanutils.BeanUtils;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		String className = "org.lanqiao.demo.Person";
		Class clazz = Class.forName(className);
		Object personBean = clazz.newInstance();
		ArrayList list = new ArrayList();
		//使用BeanUtils设置属性值
		BeanUtils.setProperty(personBean, "name", "张三");
		BeanUtils.setProperty(personBean, "age", "18");
		BeanUtils.setProperty(personBean, "gender", "mail");
		list.add(personBean);
		Iterator i = list.iterator();
		
		while(i.hasNext()){
			System.out.println(i.next());
			
		}
//		System.out.println(personBean.toString());
		System.out.println("------------------------------");
//		//使用BeanUtils读取属性值
//		//注意：返回值为String类型
//		String name = BeanUtils.getProperty(personBean, "name");
//		System.out.println(name);
//		String age = BeanUtils.getProperty(personBean, "age");
//		System.out.println(age);
	}
}
