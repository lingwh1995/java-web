package org.lanqiao.demo;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import com.ronin.commons.CommonUtils;

/**
 * 
 * 演示使用beanutils
 * BeanUtils内部依赖内省，内省依赖反射
 *
 */
public class Demo1 {
	@Test
	public void fun1() throws Exception {
		System.out.println("----------fun1()--------------------");
		String className = "org.lanqiao.demo.Person";
		Class clazz = Class.forName(className);
		Object personBean = clazz.newInstance();
		
		//使用BeanUtils设置属性值
		BeanUtils.setProperty(personBean, "name", "张三");
		BeanUtils.setProperty(personBean, "age", "18");
		BeanUtils.setProperty(personBean, "gender", "mail");
		System.out.println(personBean.toString());
		System.out.println("------------------------------");
		//使用BeanUtils读取属性值
		//注意：返回值为String类型
		String name = BeanUtils.getProperty(personBean, "name");
		System.out.println(name);
		String age = BeanUtils.getProperty(personBean, "age");
		System.out.println(age);
		
	}
	
	
	@Test
	public void fun2() throws Exception {
		System.out.println("----------fun2()--------------------");
		//把Map中的数据直接封装到Bean中
		//map("username":"张三","password":"123")
		Map<String,String> map = new HashMap<String,String>();
		//注意：map的键要和bean的属性名要相同
		map.put("username", "张三");
		map.put("password", "123");
		User user = new User();
		BeanUtils.populate(user, map);
		
		String username = BeanUtils.getProperty(user, "username");
		String password = BeanUtils.getProperty(user, "password");
		System.out.println(username+"-----"+password);
	}
	
	@Test
	public void fun3() throws Exception {
		System.out.println("----------fun3()--------------------");
		//使用我们自己封装号好的方法把Map中的数据直接封装到Bean中
		//map("username":"张三","password":"123")
		Map<String,String> map = new HashMap<String,String>();
		//注意：map的键要和bean的属性名要相同
		map.put("username", "张三");
		map.put("password", "123");
		//和上一版相比，省去了创建对象这一步
		//User user = new User();
		User user = CommonUtils.toBean(map, User.class);
		
		String username = BeanUtils.getProperty(user, "username");
		String password = BeanUtils.getProperty(user, "password");
		System.out.println(username+"-----"+password);
		/*
		 * 用途：把从表单数据快速的封装到javabean中
		 * request.getParameterMap();
		 */
	}
}
