package com.profilemanagement.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginLogoutService {
	
	boolean login(HttpServletResponse response, String username, String password);
	
	boolean logout(HttpServletRequest request);
}
