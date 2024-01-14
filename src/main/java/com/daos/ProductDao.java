package com.daos;

import java.util.List;

import com.models.Product;

public interface ProductDao {
	
	public int addProduct(Product product);
	
	public int updateProduct(Product product);
	
	public void deleteProduct(int pId);
	
	public List<Product> getAllProducts();
	
	public Product getProductById(int id);
}
