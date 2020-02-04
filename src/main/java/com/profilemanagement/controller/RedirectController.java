package com.profilemanagement.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping(value = "/redirect")
public class RedirectController {
    
    @GetMapping(value = "/facebook")
    public ModelAndView facebook() {
    	System.out.println("Redirecting to - www.facebook.com");
        return new ModelAndView("redirect:http://www.facebook.com");
    }
    
    @GetMapping(value = "/findme")
    public ModelAndView findMe(final ModelMap model) {
    	model.addAttribute("name", "Soumitra");
        return new ModelAndView("redirect:http://www.google.com", model);
    }
    
    @GetMapping(value = "google")
    public String google(final Model model) {
    	model.addAttribute("name", "soumitra");
    	return "redirect:http://google.com";
    }
    
    @GetMapping(value = "search")
    public RedirectView search(final RedirectAttributes attributes) {
    	attributes.addAttribute("name", "soumitra");
    	return new RedirectView("http://www.google.com");
    }
    
    @GetMapping(value = "gotogoogle")
    public void goToGoogle(final HttpServletResponse response) throws IOException {
    	response.sendRedirect("http://www.google.com?name=soumitra");
    }

}
