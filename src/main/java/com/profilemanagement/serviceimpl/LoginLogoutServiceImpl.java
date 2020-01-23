package com.profilemanagement.serviceimpl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.profilemanagement.service.LoginLogoutService;

@Service
public class LoginLogoutServiceImpl implements LoginLogoutService {
	
	@Override
	public String login(final String username, final String password) {
		if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password) 
				&& StringUtils.equals("admin", password)) {
			System.out.println("######### Success");
			return "success";
		} else {
			System.out.println("######### Error");
			return "error";
		}
	}

}
