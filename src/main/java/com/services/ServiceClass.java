package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daos.CustomerDao;
import com.daos.ProductDaoImpl;
import com.models.Customer;
import com.models.Product;

@Service
public class ServiceClass {

	@Autowired
	private CustomerDao cDao;
	
	@Autowired
	private ProductDaoImpl productDaoImpl;

	public int saveCustomer(Customer customer) {
		return cDao.saveCustomer(customer);
	}

	public Customer getByCid(int id) {
		return cDao.getCustomerById(id);
	}

	public void updateCustomer(Customer customer) {
		cDao.updateCustomer(customer);
	}

	public Customer getByEmailAndPass(String email, String pass) {
		return cDao.getByemailAndPassword(email, pass);
	}

	/* ================================================================== */
	
	  public int saveProduct(Product product) { return
	  productDaoImpl.addProduct(product); }
	  
	  public int updateProduct(Product product) { return
	  productDaoImpl.updateProduct(product); }
	  
	  public void deleteProduct(int pId) { productDaoImpl.deleteProduct(pId); }
	  
	  public List<Product> getAllProducts(){ return
	  productDaoImpl.getAllProducts(); }
	  
	  public Product getProductById(int pId) { return
	  productDaoImpl.getProductById(pId); }
	 
}
