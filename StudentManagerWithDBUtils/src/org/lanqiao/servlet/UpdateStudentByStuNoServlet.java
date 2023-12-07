package org.lanqiao.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Student;
import org.lanqiao.services.IStudentServices;
import org.lanqiao.services.impl.StudentServicesImpl;

public class UpdateStudentByStuNoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IStudentServices studentService = new StudentServicesImpl();
		int stuNo = Integer.parseInt(request.getParameter("stuNo"));
		String stuName = request.getParameter("stuName");
		int stuAge = Integer.parseInt(request.getParameter("stuAge"));
		Student stu = new Student(stuNo,stuName,stuAge);
		if(studentService.updateStudent(stu, stuNo)) {
			response.sendRedirect("/StudentManagerWithDBUtils/QueryAllStudentServlet");
		}
	}


}
