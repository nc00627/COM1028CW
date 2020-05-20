package com1028.coursework.source;

public class DAOFactory {

	private static final MyApp MYAPPDAO = new MyAppImpl();
	//DAO is calling the methods but using the interface and returning the methods in the form of the interface
	public static MyApp getPaymentsDAO() {
		return DAOFactory.MYAPPDAO;
	}
	
	public static MyApp getEmployeesDAO() {
		return DAOFactory.MYAPPDAO;
	}

	public static MyApp getOrdersDAO() {
		return DAOFactory.MYAPPDAO;
	}	
	
	
}
