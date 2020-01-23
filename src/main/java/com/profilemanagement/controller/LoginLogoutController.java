package com.profilemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.profilemanagement.service.LoginLogoutService;

@Controller
@RequestMapping(value = "/authentication")
public class LoginLogoutController {
	
	@Autowired
	private LoginLogoutService service;
	
	@PostMapping(value = "/login")
	public String login(@RequestParam("usrname") final String username, @RequestParam("pswd") final String password) {
		return service.login(username, password);
	}

}
