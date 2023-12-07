package com.ronin.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.ronin.commoms.CommonUtils;

public class CommonUtilsTest {
	
	/**
	 * 测试uuid
	 * 		返回一个随机的32长的字符串
	 */
	@Test
	public void testUuid(){
		String uuid = CommonUtils.uuid();
		System.out.println(uuid);
	}
	
	
	/**
	 * 测试toBean
	 * 作用:把一个map中的数据封装到javabean中
	 * 要求:
	 * 		1.map中的key名称与javabean中的属性相同
	 * 
	 */
	@Test
	public void testToBean(){
		/*
		 * 1.创建一个map
		 * 2.往map中加数据
		 */
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pid", "123");
		map.put("pname", "张三");
		map.put("page", 18);
		//通过map的数据来创建Person类型的javabean
		Person per = CommonUtils.toBean(map, Person.class);
		System.out.println(per);
	}
}
