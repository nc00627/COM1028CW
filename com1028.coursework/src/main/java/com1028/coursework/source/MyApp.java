package com1028.coursework.source;

import java.util.List;
//interface setup, methods will be implemented into MyAppImpl
public interface MyApp {

	
	public List<Payments> getPayments();
		

	public void showPayments();
	
	
	public List<Employees> getEmployees();
	
	
	public void showEmployees();
	
	
	public List<Orders> getOrders();
	
	
	public void showOrders();
	
	
	public void openConnection();
	
	
	public void closeConnection();




	
}
