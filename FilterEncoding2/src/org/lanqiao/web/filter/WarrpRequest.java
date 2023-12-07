package org.lanqiao.web.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 装饰request
 * @author ronin
 *
 */
public class WarrpRequest extends HttpServletRequestWrapper{
	private HttpServletRequest request;
	public WarrpRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	@Override
	public String getParameter(String name) {
		String value = request.getParameter(name);
		System.out.println(value);
		//处理编码问题
		try {
			//value = new String(value.getBytes("iso-8859-1"),"utf-8");
			value = new String(value.getBytes("utf-8"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return value;
	}
}
