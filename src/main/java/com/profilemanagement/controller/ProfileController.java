package com.profilemanagement.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.profilemanagement.model.Employee;
import com.profilemanagement.serviceimpl.ProfileServiceImpl;

@Controller
@RequestMapping(value = "/user")
public class ProfileController {
	
	@Autowired
	private ProfileServiceImpl service;
	
	@GetMapping(value = "/profile")
	public ModelAndView userProfile(final HttpServletRequest request) {
		System.out.println("user profile =============");
		return service.getEmployeeProfile(request);
	}
	
	@PostMapping(value = "/registration")
	public ModelAndView userRegistration(final HttpServletRequest request, @ModelAttribute("employee") final Employee employee) {
		System.out.println("registration ==============");
		return service.saveEmployee(request, employee);
	}
}
