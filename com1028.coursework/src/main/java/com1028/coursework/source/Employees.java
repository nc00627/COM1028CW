package com1028.coursework.source;

public class Employees {

	private int employeeNumber;
	private String lastname;
	private String firstname;
	private int officeCode;
	private String jobTitle;
	//constructor 
	public Employees(int employeeNumber, String lastname, String firstname, int officeCode, String jobTitle) {
		super(); //convention
		this.employeeNumber = employeeNumber;
		this.lastname = lastname;
		this.firstname = firstname;
		this.officeCode = officeCode;
		this.jobTitle = jobTitle;
		
	}
	
	public int getEmployeeNumber() {
		return employeeNumber;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public int getOfficeCode() {
		return officeCode;
	}
	
	public String getJobTitle() {
		return jobTitle;
	}
	
}
