package com.profilemanagement.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.profilemanagement.model.Employee;

public interface ProfileService {
	
	ModelAndView getEmployeeProfile(HttpServletRequest request);
	
	ModelAndView saveEmployee(HttpServletRequest request, Employee employee);

}
