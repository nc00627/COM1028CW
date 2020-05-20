package com1028.coursework.source;

import java.util.*;

public class Payments {

	private int customerNumber;
	private String checkNumber;
	private Date paymentDate;
	private double amount;
	
	public Payments(int customerNumber, String checkNumber, Date paymentDate, double amount) {		
		super();
		this.customerNumber = customerNumber;
		this.checkNumber = checkNumber;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}
	
	
	public int getCustomerNumber() {
		return customerNumber; 
	}
	
	public String getCheckNumber() {
		return checkNumber; 
	}
	
	public Date getPaymentDate() {
		return paymentDate; 
	}
	
	public double getAmount() {
		return amount; 
	}
	
	
}
