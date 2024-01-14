package com.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.models.Admin;

import org.hibernate.query.Query;

@Repository
public class AdminDaoImpl {

	@Autowired
	HibernateTemplate template;

	@Transactional
	public Admin getAdminbyUsernameAndPassword(String email, String pass) {
		Admin admin = (Admin) template.execute(s -> {

			String sql = "from Admin where adminEmail=:em and adminPassword=:pwd";

			Query q = s.createQuery(sql);

			q.setParameter("em", email);
			q.setParameter("pwd", pass);

			return q.uniqueResult();
		});

		return admin;
	}
}
