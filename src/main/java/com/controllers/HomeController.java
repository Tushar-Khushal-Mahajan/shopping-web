package com.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
//import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.models.Customer;
import com.models.OrderClass;
import com.models.Product;
import com.services.ProductService;
import com.services.ServiceClass;

@Controller
public class HomeController {

	@Autowired
	private ServiceClass service;

	@Autowired
	private ProductService productService;

	private Customer customer;
	private Integer custId; // var. initialize by session

	@RequestMapping("/Home")
	public String getHome(HttpServletRequest request, Model model) {

		HttpSession session = request.getSession();
		
		System.out.println(session.getServletContext().getRealPath("/"));

		this.custId = (Integer) session.getAttribute("customerId");

		if (this.custId != null) {

			System.out.println("Customer id = " + this.custId);

			List<Product> pdList = productService.getAllProducts();
			model.addAttribute("pdList", pdList);
			model.addAttribute("cId", this.custId);

			return "Home";
		}

		else
			return "redirect:/";
	}

	@ResponseBody
	@RequestMapping("/About")
	public String abc() {
		return "About page <br> remainig to create";
	}

	@RequestMapping("/My-section")
	public String getMe(Model model, HttpServletRequest request) {

		if (this.custId != null) {

			/*
			 * Get customer by Customer Id
			 */

			this.customer = service.getByCid(this.custId);
//			System.out.println(customer);

			// for display a form
			model.addAttribute("customer", customer);

			return "My-section";
		}

		else {
			/*
			 * REDIRECTING TO LOGIN - REGISTER WINDOW
			 */
			return "redirect:/";
		}

	}

	@ResponseBody
	@RequestMapping("/updateCustomer")
	public void updateCustomer(HttpServletRequest request, @ModelAttribute Customer customerForm) {

		customerForm.setCid(this.customer.getCid());
		customerForm.setPassword(this.customer.getPassword());

		System.out.println(customerForm);

		service.updateCustomer(customerForm);

		// model.addAttribute("update", "true");

		// return "redirect:/My-section";
	}

	@ResponseBody
	@RequestMapping("/productBuy/{pId}")
	public String buy(@PathVariable("pId") String id) {

		return id;
	}

	@ResponseBody
	@RequestMapping("/buyWait")
	public String buyWait(@ModelAttribute() OrderClass ordered) {
		System.out.println(ordered);

		productService.buyProduct(ordered);

		return "product save into db";
	}

}
