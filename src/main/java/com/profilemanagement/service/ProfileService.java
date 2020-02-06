package com.profilemanagement.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.profilemanagement.model.Employee;

public interface ProfileService {
	
	ModelAndView getEmployeeProfile(Employee emp, String cookieValue, HttpServletRequest request);
	
	ModelAndView saveEmployee(String cookieValue, HttpServletRequest request, Employee employee);

}
