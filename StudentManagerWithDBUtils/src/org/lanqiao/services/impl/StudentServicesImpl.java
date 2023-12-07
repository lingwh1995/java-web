package org.lanqiao.services.impl;

import java.util.List;

import org.lanqiao.dao.IStudentDAO;
import org.lanqiao.dao.impl.StudentDAOImpl;
import org.lanqiao.entity.Student;
import org.lanqiao.services.IStudentServices;
import org.lanqiao.utils.DBUtil;
/**
 * 注意：DAO中的增删改查是原子性的，Services中的增删改查是逻辑性的
 * @author ronin
 *
 */
public class StudentServicesImpl implements IStudentServices{
	IStudentDAO studentDAO = new StudentDAOImpl();
	@Override
	public boolean addStudent(Student student) {
		return studentDAO.isExist(student.getStuNo())?false:studentDAO.addStudent(student);
	}

	@Override
	public boolean delStudent(int stuNo) {
		return studentDAO.isExist(stuNo)?studentDAO.delStudent(stuNo):false;
	}

	@Override
	public boolean updateStudent(Student stu, int stuNo) {
		return studentDAO.updateStudent(stu, stuNo);
	}

	@Override
	public List<Student> queryAllStudetn() {
		return studentDAO.queryAllStudetn();
	}

	@Override
	public List<Student> queryStudentByName(String name) {
		return studentDAO.queryStudentByName(name);
	}

	@Override
	public boolean isExist(int stuNo) {
		return studentDAO.isExist(stuNo);
	}

	@Override
	public Student queryStudentByNo(int stuNo) {
		return studentDAO.queryStudentByNo(stuNo);
	}

	@Override
	public List<Student> queryStudentByPages(int pageSize, int currentPage) {
		return studentDAO.queryStudentByPages(pageSize, currentPage);
	}

	@Override
	public int getToalCount() {
		return studentDAO.getToalCount();
	}
	
}
