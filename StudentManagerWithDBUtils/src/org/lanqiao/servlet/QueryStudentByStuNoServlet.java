package org.lanqiao.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Student;
import org.lanqiao.services.IStudentServices;
import org.lanqiao.services.impl.StudentServicesImpl;


public class QueryStudentByStuNoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int flag = Integer.parseInt(request.getParameter("flag"));
		int stuNo = Integer.parseInt(request.getParameter("stuNo"));
		IStudentServices services = new StudentServicesImpl();
		Student student = services.queryStudentByNo(stuNo);
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(student);
		request.setAttribute("students", students);
		if(flag==1) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("views/viewStudent.jsp").forward(request, response);
		}
	}


}
