package org.lanqiao.utils;

import javax.servlet.http.Cookie;

/**
 * Cookie工具类,根据Cookie的名称查找指定的Cookie
 * @author ronin
 *
 */
public class CookieUtils {
	public static Cookie getCookByName(String name,Cookie[] cookies){
		if(cookies!=null){
			//通过名称获取
			for(Cookie cookie:cookies){
				if(name.equals(cookie.getName())){
					//返回Cookie
					return cookie;
				}
			}
		}
		return null;
	}
}
