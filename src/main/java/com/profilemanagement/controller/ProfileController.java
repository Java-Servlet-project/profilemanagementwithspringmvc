package com.profilemanagement.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.profilemanagement.model.Employee;
import com.profilemanagement.service.ProfileService;

@Controller
@RequestMapping(value = "/user")
public class ProfileController {
	
	@Autowired
	private ProfileService service;
	
	@GetMapping(value = "/profile")
	public ModelAndView userProfile(final HttpServletRequest request) {
		ModelAndView modelAndView = null;
		final Employee employee = service.getEmployeeProfile(request);
		if (null != employee) {
			modelAndView = new ModelAndView("profilePage", "employee", employee);
		} else {
			//modelAndView = 
		}
		
		
		return modelAndView;
		
	}

}
