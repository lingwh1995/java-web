package org.lanqiao.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.services.IStudentServices;
import org.lanqiao.services.impl.StudentServicesImpl;

public class DeleteStudentByStuNoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int stuNo = Integer.parseInt(request.getParameter("stuNo"));
		IStudentServices services = new StudentServicesImpl();
		if(services.delStudent(stuNo)) {
			request.getRequestDispatcher("QueryAllStudentServlet").forward(request, response);
		}else {
			String msg = "删除学生失败了";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
		
	}


}
