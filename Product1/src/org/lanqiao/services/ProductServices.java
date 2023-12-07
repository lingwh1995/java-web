package org.lanqiao.services;

import java.sql.SQLException;
import java.util.List;

import org.lanqiao.dao.ProductDao;
import org.lanqiao.entity.PageBean;
import org.lanqiao.entity.Product;

public class ProductServices {
	ProductDao productDao = new ProductDao();
	public List<Product> queryAllProduct() throws SQLException{
		return productDao.queryAllProduct();
	}
	public void addProduct(Product product) throws SQLException {
		productDao.addProduct(product);
	}
	public Product queryProductById(String id) throws SQLException {
		return new ProductDao().queryProductById(id);
	}
	public boolean updateProductById(Product product) throws SQLException {
		return productDao.updateProductById(product);
	}
	public boolean deleteProductById(String pid) throws SQLException {
		return productDao.deleteProductById(pid);
	}
	public List<Product> QueryProductByCondition(String pname, String keyword) throws SQLException {
		return productDao.QueryProductByCondition(pname,keyword);
	} 
	
	
	/*
	 * 注意:在services层把pageBean封装好
	 */
	
	
	/**
	 * 分页查询商品
	 * @param currentPage	当前页(第几页)
	 * @param pageSize		每页显示的数据量
	 * @return
	 * @throws SQLException 
	 */
	public PageBean<Product> queryProductByPage(int currentPage, int pageSize) throws SQLException {
		//查询当前页数据:limit m,n (当前页-1)*每页显示的数据 ,每页显示条数
		List<Product> list = productDao.queryProductByPage(currentPage,pageSize);
		//查询记录总条数
		int totolCount = productDao.getCount();
		return new PageBean<>(list,currentPage,pageSize,totolCount);
	} 
}
