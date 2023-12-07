package org.lanqiao.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.lanqiao.dao.IStudentDAO;
import org.lanqiao.entity.Student;
import org.lanqiao.utils.DBUtil;
import org.lanqiao.utils.Page;

public class StudentDAOImpl implements IStudentDAO{
	@Override
	public boolean addStudent(Student student) {
		String sql = "INSERT INTO STUDENT VALUES(?,?,?)";
		Object[] params = {student.getStuNo(),student.getStuName(),student.getStuAge()};
		boolean result = false;
		try {
			result =  DBUtil.executeUpdate(sql, params);
//			result =  DBUtil.executeUpdate(sql, new Object[] {5,"xx",15});
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean delStudent(int stuNo) {
		String sql = "DELETE FROM STUDENT WHERE STUNO = ?";
		Object[] params = {stuNo};
		boolean result = false;
		try {
			result =  DBUtil.executeUpdate(sql, params);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean updateStudent(Student student, int stuNo) {
		String sql = "UPDATE STUDENT SET STUNO = ?,STUNAME = ?,STUAGE = ? WHERE STUNO = ?";
		Object[] params = {student.getStuNo(),student.getStuName(),student.getStuAge(),stuNo};
		boolean result = false;
		try {
			result =  DBUtil.executeUpdate(sql, params);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Student> queryStudent(String sql ,Object[] params) {
		//查询全部和按姓名查询sql、参数这两个部分不一样
		List<Student> student = new ArrayList<Student>();
		ResultSet rs = null;
		try {
			rs = DBUtil.executQuery(sql, params);
		
			while(rs.next()) {
				int stuno = rs.getInt("stuno");
				String stuname = rs.getString("stuname");
				int stuage = rs.getInt("stuage");
				Student stu = new Student(stuno,stuname,stuage);
				student.add(stu);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, DBUtil.getPs(), DBUtil.getConn());
		}
		return student;
	}
	
	@Override
	public List<Student> queryAllStudetn() {
		//调用queryStudent()方法
		return queryStudent("select * from student ",null);
	}
	@Override
	public List<Student> queryStudentByName(String name) {
		//调用queryStudent()方法
		return queryStudent("select * from student where stuname like ?",new Object[] {name});
	}

	@Override
	public boolean isExist(int stuNo) {
		//判断此人是否存在，调用根据学号查询queryStudentByNo()
		return queryStudentByNo(stuNo)==null?false:true;
	}

	@Override
	public Student queryStudentByNo(int stuNo) {
		//调用queryStudent()方法
			//千万注意这里的返回值，注意下面的写法
		List<Student> queryStudent = queryStudent("select * from student where stuno = ?",new Object[] {stuNo});
		return queryStudent.size()==0?null:queryStudent.get(0);
	}
	@Override
	public List<Student> queryStudentByPages(int pageSize, int currentPage) {
		String sql = "select * from ((select rownum as r ,s.* from student s where rownum <=?*?))where r>(?-1)*?" ;
		Object[] params = {pageSize,currentPage,pageSize,currentPage};
		List<Student> students = queryStudent(sql, params);
		return students;
	}

	@Override
	public int getToalCount() {
		int count = -1;
		try {
			count = DBUtil.getToalCount("select count(*) from student");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(DBUtil.getRs(), DBUtil.getPs(), DBUtil.getConn());
		}
		return count;
	}
}
