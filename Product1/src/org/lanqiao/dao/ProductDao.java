package org.lanqiao.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.lanqiao.entity.Product;
import org.lanqiao.utils.DataSourcesUtils;

public class ProductDao {
	QueryRunner qr = new QueryRunner(DataSourcesUtils.getDataSource());
	String sql = null;
	/**
	 * 查询所有商品
	 * @return
	 * @throws SQLException 
	 */
	public List<Product> queryAllProduct() throws SQLException{
		sql = "select * from product";
		return (List<Product>) qr.query(sql,new BeanListHandler<>(Product.class));
	}
	
	/**
	 * 根据id查询商品
	 * @return
	 * @throws SQLException 
	 */
	public List<Product> queryAllProductById() throws SQLException{
		sql = "select * from product";
		return (List<Product>) qr.query(sql,new BeanListHandler<>(Product.class));
	}
	
	
	/**
	 * 添加商品
	 * @param product
	 * @throws SQLException 
	 */
	public void addProduct(Product product) throws SQLException {
		sql = "insert into product(pid,pname,market_price,shop_price,pdate,pdesc) values(?,?,?,?,?,?)";
		Object[] params = {product.getPid(),product.getPname(),product.getMarket_price(),product.getShop_price(),product.getPdate(),product.getPdesc()};
		int update = qr.update(sql,params);
	}

	public Product queryProductById(String id) throws SQLException {
		sql = "select * from product where pid = ?";
		Object[] params = {id};
		return qr.query(sql,new BeanHandler<>(Product.class), params);
	}

	public boolean updateProductById(Product product) throws SQLException {
		boolean flag = false;
		sql = "update product set pname = ?,market_price=? ,shop_price = ? ,pdesc = ? where pid = ?";
		Object[] params = {product.getPname(),product.getMarket_price(),product.getShop_price(),product.getPdesc(),product.getPid()};
		int count = qr.update(sql,params);
		if(count>0){
			flag = true;
		}
		return flag;
	}

	public boolean deleteProductById(String pid) throws SQLException {
		boolean flag = false;
		sql = "delete from product where pid = ?";
		Object[] params = {pid};
		int count = qr.update(sql,params);
		if(count>0){
			flag = true;
		}
		return flag;
	}

	/**
	 * 多条件查询+模糊查询
	 * @param pname
	 * @param keyword
	 * @return
	 * @throws SQLException 
	 */
	public List<Product> QueryProductByCondition(String pname, String keyword) throws SQLException {
		//存放参数
		ArrayList<String> params = new ArrayList<String>();
		String sql = "select * from product where 1 = 1";
		if(pname!=null && pname.trim().length()>0){
			//编写sql
			sql += (" and pname like ?");
			//设置参数
			params.add("%"+pname+"%");
		}
		
		if(keyword!=null && keyword.trim().length()>0){
			//编写sql
			sql += (" and pdesc like ?");
			//设置参数
			params.add("%"+keyword+"%");
		}
		return qr.query(sql, new BeanListHandler<>(Product.class),params.toArray());
	}
	
	/**
	 * 查询第几页的数据
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @throws SQLException 
	 */
	public List<Product> queryProductByPage(int currentPage, int pageSize) throws SQLException {
		sql = "select * from product limit ?,?";
		Object[] params = {(currentPage-1)*pageSize,pageSize};
		return qr.query(sql, new BeanListHandler<>(Product.class),params);
	}

	/**
	 * 查询总条数
	 * @return
	 * @throws SQLException 
	 */
	public int getCount() throws SQLException {
		sql = "select count(*) from product";
		//把		long-->int类型数据
		//((Long) qr.query(sql, new ScalarHandler())).intValue()
		return ((Long) qr.query(sql, new ScalarHandler())).intValue();
	}
}
