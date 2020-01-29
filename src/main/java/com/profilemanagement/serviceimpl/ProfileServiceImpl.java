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
		final Cookie[] cookies = request.getCookies();
		for (final Cookie cookie : cookies) {
			System.out.println(cookie.getName() + "  " + cookie.getValue());
			if (IamConstants.PROFILE_SERVICE_USER.equals(cookie.getName())) {
				ModelAndView modelAndView = null;
				final Employee employee = SessionManagementHelper.getObjectFromSession(request, cookie.getName());
				if (null != employee) {
					modelAndView = new ModelAndView("profilePage", "employee", employee);
				} else {
					modelAndView = new ModelAndView("registration", "employee", new Employee());
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
				
				System.out.println("====" + employee.getFirstName());
				System.out.println("====" + employee.getLastName());
				System.out.println("====" + employee.getSalary());
				
				final ModelAndView modelAndView = new ModelAndView("profilePage");
				modelAndView.addObject("employee", employee);
				return modelAndView;
			}
		}
		return new ModelAndView("home");
	}
}
