package com.firstProject.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FirstProject {
	
	private final String url = "jdbc:postgresql://localhost:5432/test";
	private final String user = "postgres";
	private final String password = "Scoobert2021";
	
	private void connect() {
		try(Connection connection = DriverManager.getConnection(url, user, password);) {
			if(connection != null) {
				System.out.println("Connected to PostgreSQL server successfully!");
			} else {
				System.out.println("Failed to connect PostgreSQL server");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		FirstProject sqlConnect = new FirstProject();
		sqlConnect.connect();
		/*
		System.out.println("Creating Bank...");
		
		 Bank bank = new Bank("National Australia Bank");

	     bank.addBranch("Adelaide");

	     bank.addCustomer("Adelaide", "Tim", 50.05);
	     bank.addCustomer("Adelaide", "Mike", 175.34);
	     bank.addCustomer("Adelaide", "Percy", 220.12);

	     bank.addCustomerTransaction("Adelaide", "Tim", 44.22);
	     bank.addCustomerTransaction("Adelaide", "Tim", 12.44);
	     bank.addCustomerTransaction("Adelaide", "Mike", 1.65);

	     bank.listCustomers("Adelaide", true);
	     */
	     
	     

	}
}
