package org.lanqiao.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Student;
import org.lanqiao.services.IStudentServices;
import org.lanqiao.services.impl.StudentServicesImpl;


public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//通常只需要处理request乱码
		request.setCharacterEncoding("utf-8");
		int stuNo = Integer.parseInt(request.getParameter("stuNo"));
		String stuName = request.getParameter("stuName");
		int stuAge = Integer.parseInt(request.getParameter("stuAge"));
		IStudentServices studentServices = new StudentServicesImpl();
		Student stu = new Student(stuNo,stuName,stuAge);
		if(studentServices.addStudent(stu)) {
			request.getRequestDispatcher("QueryAllStudentServlet").forward(request, response);
		}else {
			String msg = "添加学生失败了";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
	}
}
