package com.ronin.commoms;

import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

/**
 * 工具类说明:
 * CommonUtils依赖的jar:commons-beanutils-1.8.3.jar commons-logging-1.1.1.jar(间接依赖)
 */
/**
 * 小小工具
 * @author qdmmy6
 *
 */
public class CommonUtils {
	public static String uuid() {
		/**
		 * 结果:返回一个不重复的字符串
		 * 用途:
		 * 		1.用来做id，数据库的主键是不能重复的，他就是不重复的!
		 * 		2.可以用作激活码，激活码也是 不能重复的
		 * @return
		 */
		
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}

	/**
	 * 把map转换成对象
	 * @param map
	 * @param clazz
	 * @return
	 * 
	 * 把Map转换成指定类型
	 */
	@SuppressWarnings("rawtypes")
	public static <T> T toBean(Map map, Class<T> clazz) {
		/**
		 * 作用:把一个map中的数据封装到javabean中
		 * 要求:
		 * 		1.map中的key名称与javabean中的属性相同
		 */
		try {
			/*
			 * 1. 通过参数clazz创建实例
			 * 2. 使用BeanUtils.populate把map的数据封闭到bean中
			 */
			T bean = clazz.newInstance();
			ConvertUtils.register(new DateConverter(), java.util.Date.class);
			BeanUtils.populate(bean, map);
			return bean;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
