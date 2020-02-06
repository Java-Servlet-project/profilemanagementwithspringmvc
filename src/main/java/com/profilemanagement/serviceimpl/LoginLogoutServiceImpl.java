package com.profilemanagement.serviceimpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CookieValue;

import com.profilemanagement.util.CookieHelper;
import com.profilemanagement.util.IamConstants;
import com.profilemanagement.service.LoginLogoutService;
import com.profilemanagement.service.SessionManagementHelper;

@Service
public class LoginLogoutServiceImpl implements LoginLogoutService {
	
	@Override
	public boolean login(final HttpServletResponse response, final String username, final String password) {
		boolean canLogIn = Boolean.FALSE;
		if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password) 
				&& StringUtils.equals("admin", password)) {
			canLogIn = Boolean.TRUE;
			final Cookie cookie = CookieHelper.newCookie(username, 60 * 2);
			response.addCookie(cookie);
		}
		return canLogIn;
	}
	
	//@Override
	//Without @CookieValue
	public boolean logoutXX(final HttpServletRequest request, final HttpServletResponse response) {
		boolean loggedOut = Boolean.FALSE;
		final Cookie[] cookies = request.getCookies();
		for (final Cookie cookie : cookies) {
			if (IamConstants.PROFILE_SERVICE_USER.equals(cookie.getName())) {
				SessionManagementHelper.removeObjectFromSession(request, cookie.getName());
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
		return loggedOut;
	}
	
	@Override
	public boolean logout(final String cookieValue, final HttpServletRequest request, final HttpServletResponse response) {
		boolean loggedOut = Boolean.FALSE;
		if (StringUtils.isNotBlank(cookieValue)) {
			SessionManagementHelper.removeObjectFromSession(request, cookieValue);
		}
		final Cookie cookie = CookieHelper.newCookie("", -1);
		response.addCookie(cookie);
		return loggedOut;
	}
}
