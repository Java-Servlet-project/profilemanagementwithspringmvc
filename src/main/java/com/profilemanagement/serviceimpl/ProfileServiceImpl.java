package com.profilemanagement.serviceimpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.profilemanagement.model.Employee;
import com.profilemanagement.service.ProfileService;
import com.profilemanagement.service.SessionManagementHelper;
import com.profilemanagement.util.IamConstants;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Override
	public ModelAndView getEmployeeProfile(final HttpServletRequest request) {
		System.out.println("HIT ======= ");
		final Cookie[] cookies = request.getCookies();
		System.out.println("HIT 2 ======= ");
		for (final Cookie cookie : cookies) {
			System.out.println(cookie.getName() + "  " + cookie.getValue());
			if (IamConstants.PROFILE_SERVICE_USER.equals(cookie.getName())) {
				System.out.println("Cookie value : " + cookie.getValue());
				ModelAndView modelAndView = null;
				final Employee employee = SessionManagementHelper.getObjectFromSession(request, cookie.getName());
				if (null != employee) {
					System.out.println("Found employee ======");
					modelAndView = new ModelAndView("profilePage", "employee", employee);
				} else {
					System.out.println("Not Found employee ======");
					modelAndView = new ModelAndView("registration");
				}
				return modelAndView;
			}
		}
		return new ModelAndView("home");
	}
	
	@Override
	public ModelAndView saveEmployee(final HttpServletRequest request, final Employee employee) {
		final Cookie[] cookies = request.getCookies();
		for (final Cookie cookie : cookies) {
			if (IamConstants.PROFILE_SERVICE_USER.equals(cookie.getName())) {
				SessionManagementHelper.setObjectInSession(request, cookie.getValue(), employee);
				return new ModelAndView("profilePage", "employee", employee);
			}
		}
		return new ModelAndView("home");
	}
}
