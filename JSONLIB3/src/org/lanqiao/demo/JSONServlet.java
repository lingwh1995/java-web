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
 * Servlet implementation class JSONServlet
 */
public class JSONServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSONServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1、组装JSON
		JSONObject userName = new JSONObject();
		userName.put("username", "wangwu");
		JSONArray history = new JSONArray();
		JSONObject otherJson = new JSONObject();
		otherJson.put("first", "hongheibang");
		otherJson.put("second", "choujiang");
		history.add(0, otherJson);
		JSONObject anotherJSON = new JSONObject();
		anotherJSON.put("work", "shen6");
		anotherJSON.put("sal", 2);
		history.add(1, anotherJSON);
		JSONObject param = new JSONObject();
		param.put("username", userName);
		param.put("history", history);
		// 2、对JSON进行字符串化
		String paramStr = param.toString();
		// response进行输出
		PrintWriter out = response.getWriter();
		out.write(paramStr);
	}	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
