package com.daos;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.models.Customer;

@Repository
public class CustomerDao {

	@Autowired
	private HibernateTemplate template;

	@Transactional
	public int saveCustomer(Customer customer) {

		return (int) template.save(customer);
	}

	public Customer getCustomerById(int id) {

		return template.get(Customer.class, id);
	}

	@Transactional
	public void updateCustomer(Customer customer) {
		template.update(customer);
	}

	public Customer getByemailAndPassword(String email, String pass) {

		Customer customer = (Customer) template.execute(s -> {
			Query query = s.createQuery("from Customer where email=:em and password=:pwd");
			query.setParameter("em", email);
			query.setParameter("pwd", pass);

			return query.uniqueResult();

		});

		return customer;
	}

}
