package org.lanqiao.services;

import java.sql.SQLException;
import java.util.List;

import org.lanqiao.dao.ProductDao;
import org.lanqiao.entity.Product;

public class ProductServices {
	ProductDao productDao = new ProductDao();
	public List<Product> queryAllProduct() throws SQLException{
		return productDao.queryAllProduct();
	}
	public void addProduct(Product product) throws SQLException {
		productDao.addProduct(product);
	}
}
