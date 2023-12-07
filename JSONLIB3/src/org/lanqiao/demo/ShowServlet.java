package org.lanqiao.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class ShowServlet
 */
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 当前台使用复杂的JSON进行数据传输时，后台需要采用复杂的方式进行处理
		// 1、前台的JSON建议使用统一的名称进行控制
		// 2、后台采用统一的方式去接受数据
		String param = request.getParameter("param");
		PrintWriter out = response.getWriter();
		// out.write(param);
		// 3、后台把接收到的数据统一处理成JSON对象
		JSONObject paramJSON = JSONObject.fromObject(param);
		String userName = paramJSON.getString("username");
		JSONArray history = paramJSON.getJSONArray("history");
		for(int i = 0; i < history.size(); i++){
			JSONObject json = history.getJSONObject(i);
			String first = json.getString("first");
			if (first != null){
				out.write(first);
				return;
			}
		}
	}

}
