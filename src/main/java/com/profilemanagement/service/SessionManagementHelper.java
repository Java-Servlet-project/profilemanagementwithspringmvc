package com.profilemanagement.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public final class SessionManagementHelper {
	
	public static void setObjectInSession(final HttpServletRequest request, final String attrName, final Object attrValue) {
		final HttpSession session = request.getSession(true);
		session.setAttribute(attrName, attrValue);
		session.setMaxInactiveInterval(60 * 60);		
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getObjectFromSession(final HttpServletRequest request, final String attrName) {
		final HttpSession session = request.getSession(false);
		Object object = null;
		if (null != session) {
			object = session.getAttribute(attrName);
		}
		return (T) object;
	}
	
	public static void removeObjectFromSession(final HttpServletRequest request, final String attrName) {
		final HttpSession session = request.getSession(false);
		if (null != session) {
			session.removeAttribute(attrName);
		}
		invalidateCurrentSessionForUser(request);
	}
	
	private static void invalidateCurrentSessionForUser(final HttpServletRequest request) {
		final HttpSession session = request.getSession(false);
		if (null != session) {
			session.invalidate();
		}
	}

}
