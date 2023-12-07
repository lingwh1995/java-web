package org.lanqiao.beanutils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

/**
 * 演示使用BeanUtils封装数据
 * BeanUtils依赖内省,内省依赖反射
 * 用到的jar包(两个): commons-beanutils-1.8.3.jar commons-logging-1.1.1.jar
 * @author ronin
 *
 */
public class BeanUtils_Test {
	
	/**
	 * 演示使用BeanUtils封装设置属性值和读取属性值
	 */
	@Test
	public void fun1() throws Exception{
		//1.通过反射获取类的对象
		String className = "org.lanqiao.domain.Person";
		Class personClz = Class.forName(className);
		Person personBean = (Person) personClz.newInstance();
		//2.使用BeanUtils设置属性
		BeanUtils.setProperty(personBean, "name", "张三");
		BeanUtils.setProperty(personBean, "age", "18");//如果JavaBean中的这个字段是int类型的,这里也可传入一个int类型数据,也可以传入一个String类型的数据
		BeanUtils.setProperty(personBean, "gender", "男");
		//使用BeanUtils设置属性值
		System.out.println(personBean);
		//使用BeanUtils读取属性值
		String name = BeanUtils.getProperty(personBean, "name");
		String age = BeanUtils.getProperty(personBean, "age");
		String gender = BeanUtils.getProperty(personBean, "gender");
		System.out.println("name:"+name+",age:"+age+",gender:"+gender);
	}
	
	
	
	/**
	 * 演示使用Beanutils把map中的数据封装到JavaBean中
	 * 注意:
	 * 		1.map的键和JavaBean的属性要相同
	 * 		2.map的键值对的值的数据类型可以和JavaBea的属性的数据类型不一致
	 */
	@Test
	public void fun2() throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		//注意:map的键和JavaBean的属性要相同
		map.put("name", "李四");
		map.put("age", "23");
		map.put("gender", "男");
		Person person = new Person();
		BeanUtils.populate(person, map);
		System.out.println(person);
	}
	
	
	
	/**
	 * 演示使用自己封装的方法简化把map中的数据封装到JavaBean
	 */
	@Test
	public void fun3(){
		Map<String,String> map = new HashMap<String,String>();
		//注意:map的键和JavaBean的属性要相同
		map.put("name", "王五");
		map.put("age", "23");
		map.put("gender", "男");
		Person person = CommonUtils.toBean(map, Person.class);
		System.out.println(person);
	}
}
