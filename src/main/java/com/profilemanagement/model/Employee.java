package com.profilemanagement.model;

public class Employee {
	
	private String firstName;
	
	private String lastName;
	
	private Long salary;
	
	public Employee(final String firstName, final String lastName, final Long salary) {
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

	public Long getSalary() {
		return salary;
	}

	public void setSalary(final Long salary) {
		this.salary = salary;
	}
}