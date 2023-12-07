package org.lanqiao.utils;

import java.util.Map;
import java.util.UUID;


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

}
