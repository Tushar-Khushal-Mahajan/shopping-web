package com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daos.AdminDaoImpl;
import com.models.Admin;

@Service
public class AdminService {

	@Autowired
	AdminDaoImpl adminDaoImpl;

	public Admin getAdminbyEmailPassword(String email, String pass) {
		return adminDaoImpl.getAdminbyUsernameAndPassword(email, pass);
	}
}
