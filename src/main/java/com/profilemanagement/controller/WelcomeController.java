package com.profilemanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
    
    @GetMapping(value = "/facebook")
    public String facebook() {
        return "redirect:/www.facebook.com";
    }

}
