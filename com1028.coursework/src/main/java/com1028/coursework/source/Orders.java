package com1028.coursework.source;

public class Orders {

	private String customerName;
	private int orderNumber;
	
	public Orders(String customerName, int orderNumber) {
		super();
		this.customerName = customerName;
		this.orderNumber = orderNumber;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public int getOrderNumber() {
		return orderNumber;
	}
	
}
