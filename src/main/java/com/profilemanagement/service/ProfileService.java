package com.profilemanagement.service;

import javax.servlet.http.HttpServletRequest;

import com.profilemanagement.model.Employee;

public interface ProfileService {
	
	Employee getEmployeeProfile(HttpServletRequest request);

}
