package com.profilemanagement.serviceimpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

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
			final Cookie cookie = new Cookie(IamConstants.PROFILE_SERVICE_USER, username);
			cookie.setMaxAge(120);
			response.addCookie(cookie);
		}
		return canLogIn;
	}
	
	@Override
	public boolean logout(final HttpServletRequest request) {
		boolean loggedOut = Boolean.FALSE;
		final Cookie[] cookies = request.getCookies();
		for (final Cookie cookie : cookies) {
			if (IamConstants.PROFILE_SERVICE_USER.equals(cookie.getName())) {
				SessionManagementHelper.removeObjectFromSession(request, cookie.getName());
			}
		}
		return loggedOut;
	}
}
