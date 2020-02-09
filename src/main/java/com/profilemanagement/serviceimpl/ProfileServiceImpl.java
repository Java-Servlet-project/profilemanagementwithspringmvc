package com.profilemanagement.serviceimpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.profilemanagement.model.Employee;
import com.profilemanagement.service.ProfileService;
import com.profilemanagement.service.SessionManagementHelper;
import com.profilemanagement.util.IamConstants;

@Service
public class ProfileServiceImpl implements ProfileService {
	
	@Override
	public ModelAndView getEmployeeProfile(final Employee emp, final String cookieValue, final HttpServletRequest request) {
		System.out.println("Cookie Value = " + cookieValue);
		if (StringUtils.isNotBlank(cookieValue)) {
			ModelAndView modelAndView = null;
			if (null != emp) {
				modelAndView = new ModelAndView("profilePage", "employee", emp);
			} else {
				modelAndView = new ModelAndView("registration", "employee", new Employee());
			}
			return modelAndView;
		}
		return new ModelAndView("home");
	}
	
	@Override
	public ModelAndView saveEmployee(final String cookieValue, final HttpServletRequest request, final Employee employee) {
		if (StringUtils.isNotBlank(cookieValue)) {
			System.out.println("saving .. Cookie Value = " + cookieValue);
			if (employee != null) {
				return new ModelAndView("profilePage", "employee", employee);
			}
		}
		return new ModelAndView("home");
	}
	
	/*
	 * @ModelAttribute("employee") private Employee save(final Employee employee) {
	 * System.out.println("Saving employee");
	 *return employee;
	}*/

	//@Override
	public ModelAndView getEmployeeProfileYYY(final String cookieValue, final HttpServletRequest request) {
		if (StringUtils.isNotBlank(cookieValue)) {
			System.out.println("Cookie Value = " + cookieValue);
			ModelAndView modelAndView = null;
			final Employee employee = SessionManagementHelper.getObjectFromSession(request, cookieValue);
			if (null != employee) {
				modelAndView = new ModelAndView("profilePage", "employee", employee);
			} else {
				modelAndView = new ModelAndView("registration", "employee", new Employee());
			}
			return modelAndView;
		}
		return new ModelAndView("home");
	}
	
	//@Override
	public ModelAndView saveEmployeeYYY(final String cookieValue, final HttpServletRequest request, final Employee employee) {
		if (StringUtils.isNotBlank(cookieValue)) {
			System.out.println("Cookie Value = " + cookieValue);
			SessionManagementHelper.setObjectInSession(request, cookieValue, employee);
			return new ModelAndView("profilePage", "employee", employee);
		}
		return new ModelAndView("home");
	}
	
	
	
	//@Override
	public ModelAndView getEmployeeProfileXX(final HttpServletRequest request) {
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
	
	//@Override
	public ModelAndView saveEmployeeXX(final HttpServletRequest request, final Employee employee) {
		final Cookie[] cookies = request.getCookies();
		for (final Cookie cookie : cookies) {
			if (IamConstants.PROFILE_SERVICE_USER.equals(cookie.getName())) {
				SessionManagementHelper.setObjectInSession(request, cookie.getValue(), employee);
				final ModelAndView modelAndView = new ModelAndView("profilePage");
				modelAndView.addObject("employee", employee);
				return modelAndView;
			}
		}
		return new ModelAndView("home");
	}
}
