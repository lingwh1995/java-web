package org.lanqiao.dao;

import java.util.List;

import org.lanqiao.entity.Student;

public interface IStudentDAO {
	//增加学生
	public abstract boolean addStudent(Student student);
	//删除学生
	public abstract boolean delStudent(int stuNo);
	//修改学生
	public abstract boolean updateStudent(Student stu,int stuNo);
	//查询全部
	public abstract List<Student> queryAllStudetn();
	//(模糊查询)根据名字查询
	public abstract List<Student> queryStudentByName(String name);
	//是否存在
	public abstract boolean isExist(int stuNo);
	//精确查询(根据学号查询)
	public abstract Student queryStudentByNo(int stuNo);
	//查询第currentPage页的数据,每页显示pageSize条数据
	List<Student> queryStudentByPages(int pageSize,int currentPage);
	//查询总共有多少条数据
	public abstract int getToalCount();
}
