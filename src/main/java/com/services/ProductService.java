package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daos.ProductDaoImpl;
import com.models.OrderClass;
import com.models.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDaoImpl productDaoImpl;

	public int saveProduct(Product product) {
		return productDaoImpl.addProduct(product);
	}

	public int updateProduct(Product product) {
		return productDaoImpl.updateProduct(product);
	}

	public void deleteProduct(int pId) {
		productDaoImpl.deleteProduct(pId);
	}

	public List<Product> getAllProducts() {
		return productDaoImpl.getAllProducts();
	}

	public Product getProductById(int pId) {
		return productDaoImpl.getProductById(pId);
	}

	/* ========== BUY PRODUCT ======== */

	public int buyProduct(OrderClass ordered) {

		return productDaoImpl.buyProduct(ordered);

	}

	public List<OrderClass> getPendingOrders() {
		return productDaoImpl.getPendingOrders();
	}

	public List<OrderClass> getConfirmOrders() {
		return productDaoImpl.getConfirmOrders();
	}

	public void confirmOrder(int oId) {
		productDaoImpl.confirmOrder(oId);
	}
	
	public void orderDeliver(int oId) {
		productDaoImpl.orderDeliver(oId);
	}

}
