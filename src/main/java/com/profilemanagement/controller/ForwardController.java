package com.profilemanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.profilemanagement.model.Employee;

@Controller
@RequestMapping(value = "/forward")
public class ForwardController {
	
	@GetMapping(value = "/f1")
	public String f1() {
		System.out.println("forwarded 1 ======");
		return "forward:/profilemanagement/forward/f4?name=soumitraDutta";
	}
	
	@GetMapping(value = "/f2")
	public String f2() {
		System.out.println("forwarded 2 ======");
		return "success";
	}
	
	@GetMapping(value = "/f3")
	public ModelAndView f3(final ModelMap modelMap) {
		System.out.println("forward 3 *******");
		modelMap.addAttribute("name", "Soumitra Dutta");
		return new ModelAndView("forward:/profilemanagement/forward/f4", modelMap);
	}
	
	@GetMapping(value = "/f5")
	public ModelAndView f5(final Model model, final RedirectAttributes attributes) {
		System.out.println("forward 5 *******");
		
		final ModelAndView mav = new ModelAndView();
		final Employee emp = new Employee();
		emp.setFirstName("Soumitra");
		emp.setLastName("Dutta");
		//model.addAttribute("name", "Soumitra Dutta");
		mav.setViewName("forward:/profilemanagement/forward/f6");
		//mav.addObject("employee", emp);
		attributes.addFlashAttribute("employee", emp);
		return mav;
		//return new ModelAndView("forward:/profilemanagement/forward/f6", "employee", emp);
	}
	
	@GetMapping(value = "/f4")
	public void f4(@RequestParam("name") final String name) {
		System.out.println("forwarded 4 ====== name : " + name);
	}
	
	@GetMapping(value = "/f6")
	public String f6(@ModelAttribute("employee") final Employee emp) {
		System.out.println("forwarded 6 ====== ");
		System.out.println(" Firstname =  " + emp.getFirstName());
		System.out.println(" Lastname =  " + emp.getLastName());
		
		return "success";
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


