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
		// ��ǰ̨ʹ�ø��ӵ�JSON�������ݴ���ʱ����̨��Ҫ���ø��ӵķ�ʽ���д���
		// 1��ǰ̨��JSON����ʹ��ͳһ�����ƽ��п���
		// 2����̨����ͳһ�ķ�ʽȥ��������
		String param = request.getParameter("param");
		PrintWriter out = response.getWriter();
		// out.write(param);
		// 3����̨�ѽ��յ�������ͳһ�����JSON����
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
