package com.profilemanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.profilemanagement.model.Employee;

@RestController
//@Controller
@RequestMapping(value = "/restservice")
//@ResponseBody
public class MyRestController {
	
	@GetMapping(value = "/employeelists")
	public List<Employee> getEmployeeList() {
		System.out.println("### rest service hit 1 #########");
		final List<Employee> employeeList = new ArrayList<>();
		final Employee emp1 = new Employee("Soumitra", "Dutta", 3200000f);
		final Employee emp2 = new Employee("John", "Dutta", 200000f);
		final Employee emp3 = new Employee("Soumitra", "Dutta", 2000000f);
		
		employeeList.add(emp1);
		employeeList.add(emp2);
		employeeList.add(emp3);
		
		return employeeList;		
	}
	
	@GetMapping(value = "/employee/{empId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployeeById(@PathVariable("empId") final int id) {
		System.out.println("### rest service hit 2 #########");
		Employee employee = null;
		if (767626 == id) {
			employee =  new Employee("Soumitra", "Dutta", 3200000f);
		}
		return employee;	
	}
	
	@GetMapping(value = "/employee", produces = MediaType.APPLICATION_XML_VALUE)
	public Employee getEmployee() {
		System.out.println("### rest service hit 3 #########");
		return new Employee("Soumitra", "Dutta", 3200000f);
	}
}
