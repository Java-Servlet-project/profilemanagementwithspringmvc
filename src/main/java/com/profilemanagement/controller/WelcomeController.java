package com.profilemanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping(value = "/profilemanagement")
public class WelcomeController {
	
	//@GetMapping(value = "/")
    public String m2() {
        System.out.println("############# //// ############");
        return "home";
    }
    
    @GetMapping(value = "/first")
    public String m1() {
        System.out.println("############# HIT ############");
        return "login";
    }

}
