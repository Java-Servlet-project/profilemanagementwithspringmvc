package com.profilemanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
    
    @GetMapping(value = "/first")
    public String m1() {
        System.out.println("############# HIT ############");
        return "login";
    }

}
