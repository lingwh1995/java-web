package org.lanqiao.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.lanqiao.entity.User;
import org.lanqiao.services.UserServices;

public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.设置字符编码
		request.setCharacterEncoding("utf-8");
		//2.接收参数(封装数据)
		try {
			//beanUtils使用步骤导入jar包(commons-beanutils-1.8.3.jar、commons-logging-1.1.1.jar)
			//调用BeanUtils.populate(Object bean,Map<> 参数);
			User user = new User();
			//request.getParameterMap():获取所有的参数名称和值
			BeanUtils.populate(user, request.getParameterMap());
			Map<String, String[]> parameterMap = request.getParameterMap();
			System.out.println(parameterMap);
			//3.调用UserServices.regist(user),返回值为int
			int i;
			try {
				i = new UserServices().regist(user);
				//4.判断int,将信息转发到msgServlet
				if(i==1){
					request.setAttribute("msg", "添加成功！");
				}else {
					request.setAttribute("msg", "添加失败！");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("/MsgServlet").forward(request, response);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}