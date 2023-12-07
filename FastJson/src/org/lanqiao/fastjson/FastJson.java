package org.lanqiao.fastjson;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class FastJson {
	
	/**
	 * 演示fastjson的简单的使用
	 */
	@Test
	public void run1(){
		User user = new User();
		user.setUsername("zs");
		user.setPassword("123");
		user.setGender("男");
		// 转换成json的字符串
		String jsonString = JSON.toJSONString(user);
		System.out.println(jsonString);
	}
	
	@Test
	public void run2(){
		List<User> list = new ArrayList<User>();
		User user = new User();
		user.setUsername("zs");
		user.setPassword("123");
		user.setGender("男");
		list.add(user);
		
		User user1 = new User();
		user1.setUsername("ls");
		user1.setPassword("456");
		user1.setGender("男");
		list.add(user1);
		
		// 转换成json的字符串
		String jsonString = JSON.toJSONString(list);
		System.out.println(jsonString);
	}
	
	/**
	 * 默认的情况下，fastjson禁止循环的引用
	 */
	@Test
	public void run3(){
		List<User> list = new ArrayList<User>();
		User user = new User();
		user.setUsername("zs");
		user.setPassword("123");
		user.setGender("男");
		list.add(user);
		list.add(user);
		
		// 转换成json的字符串
		// String jsonString = JSON.toJSONString(list);
		
		// 禁止循环的引用
		String jsonString = JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect);
		System.out.println(jsonString);
	}
	
	/**
	 * 死循环的问题
	 */
	@Test
	public void run4(){
		Person p = new Person();
		p.setPname("美美");
		
		Role r = new Role();
		r.setRname("管理员");
		
		p.setRole(r);
		r.setPerson(p);
		
		// 禁止循环的引用
		String jsonString = JSON.toJSONString(r,SerializerFeature.DisableCircularReferenceDetect);
		System.out.println(jsonString);
	}

}









