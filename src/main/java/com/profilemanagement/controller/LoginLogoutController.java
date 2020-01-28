package com.profilemanagement.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.profilemanagement.serviceimpl.LoginLogoutServiceImpl;

@Controller
@RequestMapping(value = "/authentication")
public class LoginLogoutController {
	
	@Autowired
	private LoginLogoutServiceImpl service;
	
	@PostMapping(value = "/login")
	public String login(final HttpServletResponse response, @RequestParam("usrname") final String username, @RequestParam("pswd") final String password) {
		if (service.login(response, username, password))
			return "success";
		else
			return "error";
	}
	
	@GetMapping(value = "/logout")
	public String logout(final HttpServletRequest request, final HttpServletResponse response) {
		if (service.logout(request, response)) {
			return "home";
		} else {
			return "error";
		}
		
	}

}
