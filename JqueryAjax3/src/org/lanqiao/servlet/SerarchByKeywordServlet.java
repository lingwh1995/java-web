package org.lanqiao.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lanqiao.service.KeyWordService;

public class SerarchByKeywordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.设置编码
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		// 2.获取参数
		String keyword = request.getParameter("keyword");
		// 3.调用service层的方法完成模糊查询,返回值:list
		List<Object> list = null;
		try {
			list = new KeyWordService().queryByName(keyword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 4.将数据 [a,aa,aaa] 去掉括号 写回去 a,aaa,aa
		if (list != null && list.size() > 0) {
			String s = list.toString();
			s = s.substring(1, s.length() - 1);
			System.out.println(s);
			response.getWriter().println(s);
		}
	}

}
