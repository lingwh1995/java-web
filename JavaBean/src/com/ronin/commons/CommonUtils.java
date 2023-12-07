package com.ronin.commons;

import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;

public class CommonUtils {
	/**
	 * 生成不重复的32位长的字符串
	 * @return
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}
	/**
	 * 把map转换为指定类型的javaBean类型
	 * @param args
	 */
	public static <T> T toBean(Map map,Class<T> clazz) {
		try {
			/*
			 *1.创建指定类型的javabean对象
			 */
			T bean = clazz.newInstance();
			/*
			 * 2.把数据封装到javabean中
			 */
			BeanUtils.populate(bean, map);
			/*
			 * 3.返回javabean对象
			 */
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}

