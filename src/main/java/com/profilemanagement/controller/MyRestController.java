package com.profilemanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.profilemanagement.model.Employee;

@Controller
@RequestMapping(value = "/restservice")
public class MyRestController {
	
	@GetMapping(value = "/employeelists")
	@ResponseBody
	public List<Employee> getEmployeeList() {
		final List<Employee> employeeList = new ArrayList<>();
		final Employee emp1 = new Employee("Soumitra", "Dutta", 3200000L);
		final Employee emp2 = new Employee("John", "Dutta", 200000L);
		final Employee emp3 = new Employee("Soumitra", "Dutta", 2000000L);
		
		employeeList.add(emp1);
		employeeList.add(emp2);
		employeeList.add(emp3);
		
		return employeeList;		
	}
	
	@GetMapping(value = "/employee/{empId}")
	@ResponseBody
	public Employee getEmployeeById(@PathVariable("empId") final int id) {
		Employee employee = null;
		if (767626 == id) {
			employee =  new Employee("Soumitra", "Dutta", 3200000L);
		}
		return employee;
		
	}
}
