package com.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.daos.ProductDaoImpl;
import com.models.Admin;
import com.models.OrderClass;
import com.models.Product;
import com.services.AdminService;
import com.services.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	ProductDaoImpl productDaoImpl;

	@Autowired
	AdminService adminService;

	@Autowired
	private ProductService productService;

	private HttpSession session;

	// ========================================================

	/* DEFAULT PAGE LOGIN PAGE */
	@RequestMapping("")
	public String adminLogin() {
		return "AdminLogin";
	}

	/*
	 * THIS METHOD IS AN INTERMIDIATER BETWEEN ADMIN LOGIN AND HOME PAE..
	 */
	@RequestMapping("/checkLogin")
	public String getAdminHome(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpServletRequest request) {
		Admin admin = adminService.getAdminbyEmailPassword(email, password);

		// ==creating admin session==
		session = request.getSession();
		session.setAttribute("admin", admin);
		/// ======
		if (session.getAttribute("admin") != null) { // GO TO ADMIN HOME Mapping..
			System.out.println("Admin Id = " + session.getAttribute("admin"));
			return "redirect:/admin/homePage";
		} else { // GO TO ADMIN LOGIN PAGE..
			return "redirect:/admin";
		}
	}

	/*
	 * RESPONSIBLE TO SHOW HOME PAGE..
	 */
	@RequestMapping("/homePage")
	public String getHomePage(HttpServletRequest request) {
		session = request.getSession();

		if (session.getAttribute("admin") != null) { // SHOW HOME PAGE
			return "HomePage";
		} else { // GO-TO ADMIN LOGIN PAGE..
			return "redirect:/admin";
		}
	}

	@RequestMapping("/orders")
	public String adminOrdersPage(HttpServletRequest request, Model model) {

		session = request.getSession();

		if (session.getAttribute("admin") != null) {

			/*
			 * GET PENDING ORDERS DATA AND SEND THROUGH MODEL TO VIEW
			 */

			List<OrderClass> pendingOrders = productService.getPendingOrders();
			List<OrderClass> confirmOrders = productService.getConfirmOrders();

			System.out.println("pending orders = " + pendingOrders);
			System.out.println("confirm orders = " + confirmOrders);

			model.addAttribute("pendingOrders", pendingOrders);
			model.addAttribute("confirmOrders", confirmOrders);

			return "AdminOrderPage";
		} else {
			return "redirect:/admin";
		}
	}

	@RequestMapping("/users")
	public String adminUsers(HttpServletRequest request) {
		session = request.getSession();

		if (session.getAttribute("admin") != null) {
			return "AdminUsers";
		} else {
			return "redirect:/admin";
		}

	}

	@RequestMapping("/sales")
	public String adminSales(HttpServletRequest request) {
		session = request.getSession();

		if (session.getAttribute("admin") != null) {
			return "AdminSales";
		} else {
			return "redirect:/admin";
		}

	}

	@RequestMapping("/logOut")
	public String logOut(HttpServletRequest request) {

		session = request.getSession();
		session.removeAttribute("admin");
		return "redirect:/admin";
	}

	/*
	 * SHOWING addProduct.jsp FORM..
	 */
	@RequestMapping("/productForm")
	public String product(HttpServletRequest request) {

		session = request.getSession();

		if (session.getAttribute("admin") != null) { // SHOW ADD PRODUCT FORM
			return "addProducts";
		} else { // GO-TO ADMIN LOGIN PAGE..
			return "redirect:/admin";
		}

	}

	/**
	 * BELOW METHOD RESPONSIBLE TO STORE PRODUCT DETAILS INTO DB. <br/>
	 * called from addProducts.jsp page
	 **/
	@ResponseBody
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String getAdminForm(@ModelAttribute Product product, @RequestParam("image") CommonsMultipartFile file,
			HttpSession session) {

		byte[] image = file.getBytes();

		String path = session.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "resources"
				+ File.separator + "images" + File.separator + file.getOriginalFilename();
		System.out.println("save file location =" + path);

		try {
			FileOutputStream fos = new FileOutputStream(path);

			fos.write(image);

			fos.close();

			System.out.println("File upload");

			product.setImgPath(file.getOriginalFilename());

			System.out.println(product);

			productDaoImpl.addProduct(product);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("faild to write image");
		}

		return "product add";
	}

	/* ========================================= */

	@RequestMapping("/showPendingOrders")
	public String showPendingOrders(Model model) {
		List<OrderClass> pendingOrders = productService.getPendingOrders();

		model.addAttribute("pendingOrders", pendingOrders);

		return "services/showPendingOrders";
	}

	@RequestMapping("/showConfirmOrders")
	public String showConfirmOrders(Model model) {
		List<OrderClass> confirmOrders = productService.getConfirmOrders();

		model.addAttribute("confirmOrders", confirmOrders);

		return "services/showConfirmOrders";
	}

	/* ================================= */

	/*
	 * THIS METHOD IS RESPONSIBLE FOR CONFIRM THE ORDERS...
	 */
	@ResponseBody
	@RequestMapping("/confirmOrder")
	public String confirmOrder(@RequestParam("oId") int oId) {

		productService.confirmOrder(oId);
		return "confirm";
	}

	/*
	 * THIS METHOD IS RESPONSIBLE FOR DELIVER THE PRODUCT.. <br> used in
	 * "AdminOrderPage"
	 */
	@ResponseBody
	@RequestMapping("/orderDeliver")
	public String orderDeliver(@RequestParam("oId") int oId) {

		productService.orderDeliver(oId);

		return "confirm";
	}
}
