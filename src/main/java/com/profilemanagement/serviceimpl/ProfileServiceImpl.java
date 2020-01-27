package com.profilemanagement.serviceimpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.profilemanagement.model.Employee;
import com.profilemanagement.service.ProfileService;
import com.profilemanagement.service.SessionManagementHelper;
import com.profilemanagement.util.IamConstants;

public class ProfileServiceImpl implements ProfileService {

	@Override
	public Employee getEmployeeProfile(final HttpServletRequest request) {
		final Cookie[] cookies = request.getCookies();
		Employee employee = null;
		for (Cookie cookie : cookies) {
			if (IamConstants.PROFILE_SERVICE_USER.equals(cookie.getName())) {
				employee = SessionManagementHelper.getObjectFromSession(request, cookie.getName());
			}
		}
		return employee;
	}
}
