package org.lanqiao.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class QR<T> {
	private DataSource dataSource;
	
	public QR() {
		super();
	}

	public QR(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}


	/**
	 * 做insert、update、delete
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException 
	 */
	public int update(String sql, Object... params) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = dataSource.getConnection(); 
			ps = conn.prepareStatement(sql);
			//设置条件
			for(int i = 0; i < params.length; i++){
				ps.setObject(i+1, params[i]);
			}
			//返回受影响的记录条数
			return ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException();//抛出一个运行时异常
		}finally {
			//进行排空的原因是因为如果上面的代码没有获取到rs、st、conn这个三个对象，在这里就会产生一个空指针异常
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}
	}
	
	public T query(String sql,RsHandler<T> rh,Object... params){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = dataSource.getConnection(); 
			ps = conn.prepareStatement(sql);
			//设置条件
			for(int i = 0; i < params.length; i++){
				ps.setObject(i+1, params[i]);
			}
			//获取查询结果并处理查询结果
			rs = ps.executeQuery();
			//把ResultSet传递给rh,完成把数据封装到JavBean中
			return rh.handle(rs);
		} catch (Exception e) {
			throw new RuntimeException();//抛出一个运行时异常
		}finally {
			//进行排空的原因是因为如果上面的代码没有获取到rs、st、conn这个三个对象，在这里就会产生一个空指针异常
			try {
				if(rs!=null) rs.close();					
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}


	/**
	 * 这个接口的作用:用来把结果集转换成为需要的类型
	 * @author ronin
	 *
	 * @param <T>
	 */
	interface RsHandler<T> {
		public T handle(ResultSet rs) throws SQLException;
	}
