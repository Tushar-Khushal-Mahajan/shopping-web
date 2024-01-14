package com.daos;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.query.internal.QueryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.models.OrderClass;
import com.models.Product;

@Repository
public class ProductDaoImpl {

	@Autowired
	HibernateTemplate template;

	@Transactional
	public int addProduct(Product product) {
		return (int) template.save(product);
	}

	@Transactional
	public int updateProduct(Product product) {
		template.update(product);
		return 1;
	}

	@Transactional
	public void deleteProduct(int pId) {
		template.delete(pId);
	}

	public List<Product> getAllProducts() {
		return template.loadAll(Product.class);
	}

	public Product getProductById(int id) {
		return template.get(Product.class, id);
	}

	/* ======= PRODUCT ORDER ======= */

	@Transactional
	public int buyProduct(OrderClass ordered) {
		return (int) template.save(ordered);
	}

	public List<OrderClass> getPendingOrders() {

		List<OrderClass> pendingOrders = template.execute(s -> {
			Query q = s.createQuery("FROM OrderClass WHERE isConfirm = 0");

			List<OrderClass> setList = (List<OrderClass>) q.getResultList();

			/* System.out.println("<br>set = " + setList.getClass()); */
			return (List<OrderClass>) setList;
		});

		return pendingOrders;
	}

	public List<OrderClass> getConfirmOrders() {

		List<OrderClass> confirmOrders = template.execute(s -> {
			Query q = s.createQuery("FROM OrderClass WHERE isConfirm = 1 AND isDelivered = 0");

			List<OrderClass> setList = (List<OrderClass>) q.getResultList();

			/* System.out.println("<br>set = " + setList.getClass()); */
			return (List<OrderClass>) setList;
		});

		return confirmOrders;
	}

	public OrderClass getOrderById(int oId) {
		return template.get(OrderClass.class, oId);
	}

	@Transactional
	public void confirmOrder(int oId) {

		OrderClass orderClass = getOrderById(oId);

		orderClass.setConfirm(true);

		template.update(orderClass);
	}

	@Transactional
	public void orderDeliver(int oId) {

		OrderClass orderClass = getOrderById(oId);

		orderClass.setDelivered(true);

		template.update(orderClass);
	}

}
