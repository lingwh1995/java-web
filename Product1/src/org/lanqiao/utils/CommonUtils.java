package org.lanqiao.utils;

import java.util.UUID;

public class CommonUtils {
	/**
	 * 返回一个32位的不重复的字符串,用作商品的id
	 * @return
	 */
	public static String getId(){
		return UUID.randomUUID().toString().toUpperCase().replace("-", "");
	}
	
	/**
	 * 生成令牌的随机码:用于防止表单数据重读提交
	 * @return
	 */
	public static String getRandomCode(){
		//这个随机码可以是随机数也可以是uuid
		return getId();
	}
}
