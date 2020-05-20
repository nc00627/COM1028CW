package com1028.coursework.source;

import java.sql.*;
import java.util.*;
import java.util.Date;

// implementing the interface
public class MyAppImpl implements MyApp {


	private Connection connect;
	private Statement statement;

	public MyAppImpl() {
		
		super();
		this.connect = null;
		this.statement = null;
		this.openConnection();	
		
	}
			
	public void openConnection() {

		// if null, attempt to connect, throw exception otherwise
		try {
			
			if (this.connect == null || this.connect.isClosed()) {
				this.connect = DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/classicmodels",
								"root", "legend@1823");
			}
			
			if (this.statement == null || this.statement.isClosed()) {
				this.statement = this.connect.createStatement();
			}

		} catch (SQLException e) {
			System.out
					.println("ERROR: Failed to connect");
			throw new RuntimeException(e);
		}
	}
	
	
	// closes connection
	public void closeConnection() {

		try {

			if (this.statement != null) {
				this.statement.close();
			}
			if (this.connect != null) {
				this.connect.close();
			}
			System.out.println("Connection closed");
		} catch (Exception e) {
			System.out
					.print("ERROR: Failed to connect");
			throw new RuntimeException(e);
		}
	}
	
	
	// list of type Payments, creating an array called payments and then adding data through the constructor 
	public List<Payments> getPayments() {
		ArrayList<Payments> payments = new ArrayList<Payments>();
		try {
			String query = 	"SELECT * " +
	                		"FROM Payments " +
	                		"WHERE amount > (SELECT AVG(amount)*2 FROM Payments)"; 
			ResultSet results = this.statement.executeQuery(query);
			
			while (results.next()) {
				int customerNumber = results.getInt("customerNumber");
				String checkNumber = results.getString("checkNumber");
				Date paymentDate = results.getDate("paymentDate");
				double amount = results.getDouble("amount");
				payments.add(new Payments(customerNumber, checkNumber, paymentDate, amount));
			}
		} catch (SQLException e) {
			System.out.println("SQLException occurred regarding files");
	throw new RuntimeException(e);
	}
	return payments;
		
	}
	//same type of methods but instead iterates through using iterator function
	public void showPayments() {

		List<Payments> payments = getPayments();
		Iterator<Payments> iter = payments.iterator();
		
		Payments tmpPayments;
		while (iter.hasNext()) {
			tmpPayments = iter.next();			
			System.out.println("customerNumber: " + tmpPayments.getCustomerNumber());
			System.out.println("checkNumber: " + tmpPayments.getCheckNumber());
			System.out.println("paymentDate: " + tmpPayments.getPaymentDate());
			System.out.println("amount: " + tmpPayments.getAmount() + "\n");
		}
	}	

	public List<Employees> getEmployees() {
		ArrayList<Employees> employees = new ArrayList<Employees>();
		try {
			String query = 	"SELECT * " +
                    		"FROM Employees " +
                    		"WHERE officeCode = '2'";
			ResultSet results = this.statement.executeQuery(query);
			
			while (results.next()) {
				int employeeNumber = results.getInt("employeeNumber");
				String lastname = results.getString("lastname");
				String firstname = results.getString("firstname");
				int officeCode = results.getInt("officeCode");
				String jobTitle = results.getString("jobTitle");
				employees.add(new Employees(employeeNumber, lastname, firstname, officeCode, jobTitle));
			}
		} catch (SQLException e) {
			System.out.println("SQLException occurred regarding files");
	throw new RuntimeException(e);
}
return employees;
		
	}
	
	public void showEmployees() {

		List<Employees> employees = getEmployees();
		Iterator<Employees> iter = employees.iterator();
		
		Employees tmpEmployees;
		while (iter.hasNext()) {
			tmpEmployees = iter.next();
			System.out.println("employeeNumber: " + tmpEmployees.getEmployeeNumber());
			System.out.println("lastname: " + tmpEmployees.getLastname());
			System.out.println("firstname: " + tmpEmployees.getFirstname());
			System.out.println("officeCode: " + tmpEmployees.getOfficeCode());
			System.out.println("jobTitle: " + tmpEmployees.getJobTitle() + "\n");			
		}
	}	
	
	public List<Orders> getOrders() {
		ArrayList<Orders> orders = new ArrayList<Orders>();
		try {
			String query = 	"SELECT customerName, Orders.orderNumber " +
                    		"FROM Customers " +
                    		"JOIN Orders on Orders.customerNumber = Customers.customerNumber " +
                    		"JOIN OrderDetails on OrderDetails.orderNumber = Orders.orderNumber " + // couldn't get a way in java working so I did it in SQL as it did end up working
                    		"GROUP by Orders.orderNumber " +
                    		"HAVING sum(quantityOrdered*priceEach) > 25000";
			ResultSet results = this.statement.executeQuery(query);
			
			while (results.next()) {
				String customerName = results.getString("customerName");
				int orderNumber = results.getInt("orderNumber");
				orders.add(new Orders(customerName, orderNumber));
			}
		} catch (SQLException e) {
			System.out.println("SQLException occurred regarding files");
	throw new RuntimeException(e);
}
return orders;
		
	}	
	
	public void showOrders() {
		// iterator built in function
		List<Orders> orders = getOrders();
		Iterator<Orders> iter = orders.iterator();
		
		Orders tmpOrders;
		while (iter.hasNext()) {
			tmpOrders = iter.next();
			System.out.println("customerName: " + tmpOrders.getCustomerName());
			System.out.println("orderNumber: " + tmpOrders.getOrderNumber() + "\n");
		
		}
	}	
	
}
