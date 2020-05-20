package com1028.coursework.source;

public class Main {

	public static void main(String[] args) {
		MyApp myapp = null;
		try {
			myapp = DAOFactory.getPaymentsDAO(); //executes the getPayment method in relation to the requirement 
			System.out.println("-- All payments greater than twice the average payment ************************************************* \n"); //title
			myapp.showPayments(); //puts it in a format 
			myapp = DAOFactory.getEmployeesDAO();
			System.out.println("-- Boston Employees ************************************************* \n");
			myapp.showEmployees();
			myapp = DAOFactory.getOrdersDAO();
			System.out.println("-- Orders with a value greater than $25000 ************************************************* \n");
			myapp.showOrders();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (myapp != null) {          //when not null, connection will forcibly close
				myapp.closeConnection();
			}
		}
	}

}
