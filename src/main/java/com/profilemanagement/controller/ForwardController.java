package com.profilemanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/forward")
public class ForwardController {
	
	@GetMapping(value = "/f1")
	public String f1() {
		System.out.println("forwarded 1 ======");
		return "forward:/profilemanagement/forward/f2";
	}
	
	@GetMapping(value = "/f2")
	public String f2() {
		System.out.println("forwarded 2 ======");
		return "success";
	}
	
	@GetMapping(value = "/f3")
	public ModelAndView f3(final ModelMap modelMap) {
		modelMap.addAttribute("name", "Soumitra Dutta");
		return new ModelAndView("forward:/profilemanagement/forward/f4", modelMap);
	}
	
	@GetMapping(value = "/f4")
	public void f4(@RequestParam("name") final String name) {
		System.out.println("forwarded 4 ====== name : " + name);
	}
	
	/**
	 * redirect
forward
java config
@Cookie
@SessionAttribute/s

MOdelAndView vs Model vs ModelMap

validation
	 */

}


