package com.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.models.Customer;
import com.services.ServiceClass;

@Controller
public class LoginRegister {

	@Autowired
	private ServiceClass serviceClass;

	@RequestMapping(path = "/Login", method = RequestMethod.POST)
	public String getLogin(HttpServletRequest request) {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Customer customer = serviceClass.getByEmailAndPass(email, password);
		// System.out.println(customer);

		if (customer != null) {

			System.out.println("login succ.");
			System.out.println(email + " " + password);

			HttpSession session = request.getSession();
			session.setAttribute("customerId", customer.getCid());

			return "redirect:/Home";
		} else {

			System.out.println("record not found.");
			System.out.println(email + " " + password);

			return "redirect:/";
		}
	}

	@RequestMapping(path = "/Register", method = RequestMethod.POST)
	public String getRegister(@ModelAttribute Customer customer, HttpServletRequest request) {
		System.out.println(customer);

		int i = serviceClass.saveCustomer(customer);
		System.out.println(i);

		HttpSession session = request.getSession();
		session.setAttribute("customerId", i);

		return "redirect:/Home";
	}

}
