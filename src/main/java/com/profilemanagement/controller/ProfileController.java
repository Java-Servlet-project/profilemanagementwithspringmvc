package com.profilemanagement.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.profilemanagement.model.Employee;
import com.profilemanagement.serviceimpl.ProfileServiceImpl;
import com.profilemanagement.util.IamConstants;

@Controller
@RequestMapping(value = "/user")
@SessionAttributes("employee")
public class ProfileController {
	
	@Autowired
	private ProfileServiceImpl service;
	
	@GetMapping(value = "/profile")
	public ModelAndView userProfile(@CookieValue(value = IamConstants.PROFILE_SERVICE_USER, defaultValue = "") final String cookieValue,
			@SessionAttribute(name = "employee", required = false) Employee emp, final HttpServletRequest request) {
		return service.getEmployeeProfile(emp, cookieValue, request);
	}
	
	@PostMapping(value = "/registration")
	public ModelAndView userRegistration(@CookieValue(value = IamConstants.PROFILE_SERVICE_USER, defaultValue = "") final String cookieValue, 
			final HttpServletRequest request, @ModelAttribute("employee") final Employee employee) {
		return service.saveEmployee(cookieValue, request, employee);
	}
}
