package com.profilemanagement.serviceimpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.profilemanagement.IamConstants;
import com.profilemanagement.service.LoginLogoutService;

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
}
