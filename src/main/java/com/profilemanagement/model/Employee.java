package com.profilemanagement.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {
	
	@JsonProperty("First Name")
	private String firstName;
	
	private String lastName;
	
	private float salary;
	
	public Employee() {}
	
	public Employee(final String firstName, final String lastName, final float salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(final float salary) {
		this.salary = salary;
	}
}