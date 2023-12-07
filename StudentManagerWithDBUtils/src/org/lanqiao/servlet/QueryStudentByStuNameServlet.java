package org.lanqiao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Student;
import org.lanqiao.services.IStudentServices;
import org.lanqiao.services.impl.StudentServicesImpl;

public class QueryStudentByStuNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String stuName = request.getParameter("stuName");
		IStudentServices services = new StudentServicesImpl();
		String name = "%"+stuName+"%";
		List<Student> students= services.queryStudentByName(name);
		request.setAttribute("students", students);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}


}
