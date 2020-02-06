package com.profilemanagement.util;

import javax.servlet.http.Cookie;

public final class CookieHelper {
	
	public static Cookie newCookie(final String username, final int maxAge) {
		final Cookie cookie = new Cookie(IamConstants.PROFILE_SERVICE_USER, username);
		cookie.setMaxAge(maxAge);
		cookie.setPath("/ProfileManagementMvc");
		return cookie;
	}
}
