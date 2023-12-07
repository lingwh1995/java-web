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
import org.lanqiao.utils.Page;

public class QueryStudentsByPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cPageStr = request.getParameter("cPage");
		int cPage = cPageStr==null?1:Integer.parseInt(request.getParameter("cPage"));
//		System.out.println(cPage);
		int pSize = 5;
		Page page = new Page();
		//在这里给page赋三个值
		page.setCurrentPage(cPage);//当前页码
//		page.setPageSize(pSize);//页面大小//先总页数再pageSize
		IStudentServices studentServices = new StudentServicesImpl();
		List<Student> students = studentServices.queryStudentByPages(cPage, pSize);
		request.setAttribute("students", students);
		//总数据量
		int toalCount = studentServices.getToalCount();
		page.setTotalCount(toalCount);
		page.setPageSize(pSize);
		//到这一步，page中还差一个学生集合
		page.setStudents(students);
		request.setAttribute("studentPage", page);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
