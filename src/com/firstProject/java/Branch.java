package com.firstProject.java;

import java.util.ArrayList;

public class Branch {
	 private String name;
	    private ArrayList<Customer> customers;

	    public Branch(String name) {
	        this.name = name;
	        this.customers = new ArrayList<>();
	    }

	    public String getName() {
	        return name;
	    }

	    public ArrayList<Customer> getCustomers() {
	        return customers;
	    }

	    public boolean newCustomer(String customerName, double initTransaction) {
	        boolean wasAdded = false;
	        this.customers.add(new Customer(customerName, initTransaction));
	        for(Customer customer : this.customers) {
	            if(customerName.equals(customer.getName())) {
	                wasAdded = true;
	            }
	        }
	        return wasAdded;
	    }

	    public boolean addCustomerTransaction(String customerName, double transaction) {
	        boolean wasAdded = false;
	        for(Customer customer : customers) {
	            if(customerName.equals(customer.getName())) {
	                customer.addTransaction(transaction);
	                wasAdded = true;
	            }
	        }
	        return wasAdded;
	    }

	    private Customer findCustomer(String customerName) {
	        Customer customerToReturn = null;
	        for(Customer customer : customers) {
	            if(customerName.equals(customer.getName())) {
	                customerToReturn = customer;
	            }
	        }
	        return customerToReturn;
	    }
}
