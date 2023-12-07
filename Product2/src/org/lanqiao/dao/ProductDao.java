package org.lanqiao.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
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
	 * 添加商品
	 * @param product
	 * @throws SQLException 
	 */
	public void addProduct(Product product) throws SQLException {
		sql = "insert into product(pid,pname,market_price,shop_price,pdate,pdesc) values(?,?,?,?,?,?)";
		Object[] params = {product.getPid(),product.getPname(),product.getMarket_price(),product.getShop_price(),product.getPdate(),product.getPdesc()};
		int update = qr.update(sql,params);
	}
}
