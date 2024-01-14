package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class viewServiceController {
	
	
	@RequestMapping("/showSuccess/{viewName}")
	public String showSuccessPage(@PathVariable("viewName") String view, HttpServletResponse response) throws IOException {
		
		System.out.println(view);
		
		PrintWriter out = response.getWriter();
		out.print(
					 "<script?"
					+ "alert('Sucess');"
					+"</script>"
				);
		
		return "redirect:/"+view;
	}
}
