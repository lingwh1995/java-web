package org.lanqiao.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.entity.Student;

public class DBUtil_V1 {
	private final static String DRIVER = "oracle.jdbc.driver.OracleDriver" ;
	private final static String URL = "jdbc:oracle:thin:@localhost:1521:orcl" ;//mysql3306  sqlserver1433
	private final static String USERNAME = "scott";
	private final static String PASSWORD = "tiger";
	private static ResultSet rs = null;
	
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	public static boolean executeUpdate(String sql,Object[] params) {
		boolean flag = false;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			System.out.println("数据库已经获取连接");
			ps = conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++) {
				ps.setObject((i+1), params[i]);
			}
			int result = ps.executeUpdate();
			if(result>0) {
				flag = true;
			}
			//注意:不用提交，直接就可以成功
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}catch (Exception e2) {
			}
		}
		return flag;
	}
	public static <T> List<T>  executeQuery(String sql,Object[] params,List<T> obList) {
		List<T> obs = new ArrayList<T> ();
		int k = 0;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			System.out.println("-----数据库已获取连接------");
			ps = conn.prepareStatement(sql);
			if(params!=null) {//不排空会出现空指针异常
				for(int i=0;i<params.length;i++) {
					ps.setObject((i+1), params[i]);
				}
			}
			rs = ps.executeQuery();
			while(rs.next()) {
//				T ob = new T();//目的，产生对象，可以通过直接传入一个对象而不通过new产生
				Field[] fileds = obList.get(k).getClass().getDeclaredFields();
				for(int i=0;i<fileds.length;i++) {
					Object value = rs.getObject(i+1);
					String fileName = fileds[i].getName();
//					System.out.print(fileds[i].getName()+"---"+value+"\t");
					Method[] methods = obList.get(k).getClass().getDeclaredMethods();
					for(Method method:methods ) {
						//获取javaBean中的set方法，以方便给对象赋值
						if(method.getName().startsWith("set") && method.getName().toLowerCase().indexOf(fileName.toLowerCase())>-1) {
							//method.setName(xxx)
							method.invoke(obList.get(k), value);
						}
					}
				}
				System.out.println();
				obs.add(obList.get(k));
				k++;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return obs;
	}
	public static void main(String[] args) {
		//测试增加数据
//		String sql = "insert into student values(?,?,?)";
//		Object[] params = {4,4,4};
//		boolean executeUpdate = executeUpdate(sql,params );
//		System.out.println(executeUpdate);
		
		//测试删除数据
//		String sql = "delete from student where stuno = ?";
//		Object[] params = {2};
//		boolean executeUpdate = executeUpdate(sql,params );
//		System.out.println(executeUpdate);
		
		//测试查询数据
//		String sql = "SELECT * FROM STUDENT WHERE STUNAME = ?";
//		Object[] obj = {"sq"};
		
		String sql = "SELECT * FROM STUDENT ORDER BY 1";
		Object[] obj = null;
		List<Student> stuList = new ArrayList<Student>();
		for(int i=0;i<4;i++) {
			Student stu = new Student();
			stuList.add(stu);
		}
		List<Student> list = executeQuery(sql,obj,stuList);
	}
}
