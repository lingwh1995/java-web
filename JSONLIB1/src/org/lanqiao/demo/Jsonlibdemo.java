package org.lanqiao.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 
 * 演示json-lib小工具(使用前先导入jar包)
 *
 */
public class Jsonlibdemo {
	/*
	json-lib
	1. 是什么？
	  * 它可以把javabean转换成json串
	2. jar包
	  * 略
	3. 核心类
	  * JSONObject --> Map
	    > toString();
	    > JSONObject map = JSONObject.fromObject(person)：把对象转换成JSONObject对象
	  * JSONArray --> List
	    > toString()
	    > JSONArray jsonArray = JSONObject.fromObject(list)：把list转换成JSONArray对象
	 */
	@Test
	public void fun1() {
		JSONObject map = new JSONObject();
		map.put("name", "zs");
		map.put("age", 27);
		map.put("sex", "male");
		String jsonStr = map.toString();
		System.out.println(jsonStr);//结果为：{"name":"zs","age":27,"sex":"mail"}
	}
	@Test
	public void fun2() {
		//把person对象转换为JSONObject对象
		Person person = new Person("lisi",25,"male"); 
		JSONObject jsonPerson = JSONObject.fromObject(person);
		System.out.println(jsonPerson.toString());
	}
	
	@Test
	public void fun3() {
		//把map转换为JSON对象、
		Map map = new HashMap();
		map.put("name", "zl");
		map.put("age", 27);
		map.put("sex", "male");
		JSONObject mapJson = JSONObject.fromObject(map);
		System.out.println(mapJson.toString());
	}
	@Test
	public void fun4() {
		//把对象封装到JSONlist中，把JSONlist转换成字符串
		Person p1 = new Person("a",25,"b"); 
		Person p2 = new Person("c",25,"d"); 
		JSONArray list = new JSONArray();
		list.add(p1);
		list.add(p2);
		System.out.println(list.toString());
	}
	@Test
	public void fun5() {
		//把对象存储在list中
		Person p1 = new Person("aa",25,"bb"); 
		Person p2 = new Person("cc",25,"dd"); 
		List<Person> list = new ArrayList<Person>();
		list.add(p1);
		list.add(p2);
		//把list转换为JSONArray对象
		JSONArray listJsonArray = JSONArray.fromObject(list);
		System.out.println(listJsonArray.toString());//注意：输出的是一个数组格式
	}
}
