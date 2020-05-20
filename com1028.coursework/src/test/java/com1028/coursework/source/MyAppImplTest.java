package com1028.coursework.source;

import java.sql.*;
import static org.junit.Assert.*;

import org.junit.*;

// failed the tests despite my code completing the requirements, unsure on how to compare my void methods...
public class MyAppImplTest {
	

	
	public String test()  {

		try {

		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", ""); //password left as blank
			String query = "SELECT * " +
                           "FROM Payments " +
					       "WHERE amount > (SELECT AVG(amount)*2 FROM Payments)";
			
		Statement state = connect.createStatement();
		
		ResultSet rs = state.executeQuery(query);
		
		
		rs.next();
		String load = ("customerNumber: " + rs.getInt("customerNumber") + "\n" + "checkNumber: " + rs.getString("checkNumber") + "\n" + "paymentDate: " + rs.getDate("paymentDate") + "\n" + "amount: " +  rs.getDouble("amount") + "\n");
		return load;
	
	
		
	} 		catch (SQLException e) {
				System.out.println("SQLException occurred regarding files");
				throw new RuntimeException(e);
}
				
	
}
	
	
	@Test
	public void PaymentsTest() {
		MyAppImpl test = new MyAppImpl();
		try {
			//test = DAOFactory.getPaymentsDAO();
			
			
			assertEquals((test.getPayments()).toString(), test()); //tried converting the array to a string so I could compare but failed
		} catch (Exception e) {
			e.printStackTrace();
	}
	
	
}
	
	public String test2()  {

		try {

		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "");
		String query = 	"SELECT * " +
        		"FROM Employees " +
        		"WHERE officeCode = '2'";
			
		Statement state = connect.createStatement();
		
		ResultSet rs = state.executeQuery(query);
		
		
		rs.next();
		String load = ("employeeNumber: " + rs.getInt("employeeNumber") + "\n" + "lastname: " + rs.getString("lastname") + "\n" + "firstname: " + rs.getString("firstname") + "\n" + "officeCode: " +  rs.getInt("officeCode") + "\n" + "jobTitle: " + rs.getString("jobTitle") +"\n");
		return load;
	
	
		
	} 		catch (SQLException e) {
				System.out.println("SQLException occurred regarding files");
				throw new RuntimeException(e);
}
				
	
}
	

	@Test
	public void EmployeesTest() {
		MyAppImpl test = new MyAppImpl();
		try {
			
			
			
			assertEquals((test.getEmployees()).toString(), test()); //tried converting the array to a string so I could compare
		} catch (Exception e) {
			e.printStackTrace();
	}
	
	
}
	
	
	public String test3()  {

		try {

		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "");
		String query = 	"SELECT customerName, Orders.orderNumber " +
        				"FROM Customers " +
        				"JOIN Orders on Orders.customerNumber = Customers.customerNumber " +
        				"JOIN OrderDetails on OrderDetails.orderNumber = Orders.orderNumber " +
        				"GROUP by Orders.orderNumber " +
        				"HAVING sum(quantityOrdered*priceEach) > 25000";
			
		Statement state = connect.createStatement();
		
		ResultSet rs = state.executeQuery(query);
		
		
		rs.next();
		String load = ("customerName: " + rs.getString("customerName") + "\n" + "orderNumber: " + rs.getString("orderNumber") + "\n");
		return load;
	
	
		
	} 		catch (SQLException e) {
				System.out.println("SQLException occurred regarding files");
				throw new RuntimeException(e);
}
				
	
}

	@Test
	public void OrdersTest() {
		MyAppImpl test = new MyAppImpl();
		try {
			
			
			
			assertEquals((test.getOrders()).toString(), test()); //tried converting the array to a string so I could compare
		} catch (Exception e) {
			e.printStackTrace();
	}
	
	
}
	
	
	
	
}

