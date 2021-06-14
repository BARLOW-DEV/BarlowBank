package com.firstProject.java;

import java.util.ArrayList;

public class Bank {
	 String name;
	    ArrayList<Branch> branches;

	    public Bank(String name) {
	        this.name = name;
	        this.branches = new ArrayList<>();
	    }

	    public boolean addBranch(String name) {
	        boolean wasAdded = false;
	        if (findBranch(name) == null) {
	            branches.add(new Branch(name));
	            wasAdded = true;
	        }
	        return wasAdded;
	    }

	    public boolean addCustomer(String branchName, String customerName, double transaction) {
	        boolean wasAdded = false;
	        boolean doesExist = false;
	        Branch branchToAddCust;
	        if(findBranch(branchName) != null) {
	            branchToAddCust = findBranch(branchName);
	            ArrayList<Customer> customers = branchToAddCust.getCustomers();
	            if(customers.size() == 0 ) {
	                for (Branch branch : branches) {
	                    if (branchName.equals(branch.getName())) {
	                        branch.newCustomer(customerName, transaction);
	                        wasAdded = true;
	                    }
	                }
	            } else {
	                for (Customer customer : customers) {
	                    if (customerName.equals(customer.getName())) {
	                        doesExist = true;
	                    }
	                }
	                if (!doesExist) {
	                    for (Branch branch : branches) {
	                        if (branchName.equals(branch.getName())) {
	                            branch.newCustomer(customerName, transaction);
	                            wasAdded = true;
	                        }
	                    }
	                }
	            }
	        }
	        return wasAdded;
	    }


	    public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {
	        boolean wasAdded = false;
	        ArrayList<Customer> customers;
	        for(Branch branch : branches) {
	            if(branchName.equals(branch.getName())) {
	                customers = branch.getCustomers();
	                for(int i = 0; i < customers.size(); i++) {
	                    if(customers.get(i).getName().equals(customerName)) {
	                        customers.get(i).addTransaction(transaction);
	                        wasAdded = true;
	                    }
	                }
	            }
	        }
	        return wasAdded;
	    }

	    private Branch findBranch(String branchName) {
	        Branch found = null;
	        for (Branch branch : branches) {
	            if (branchName.equals(branch.getName())) {
	                found = branch;
	            }
	        }
	        return found;
	    }

	    public boolean listCustomers(String branchName, boolean hastransactions) {
	        boolean doesExist = false;
	        if (hastransactions) {
	            ArrayList<Customer> customers;
	            for (Branch branch : branches) {
	                if (branchName.equals(branch.getName())) {
	                    doesExist = true;
	                    customers = branch.getCustomers();
	                    System.out.println("Customer details for branch " + branch.getName());
	                    for (int i = 0; i < customers.size(); i++) {
	                        System.out.println("Customer: " + customers.get(i).getName() + "[" + (i + 1) + "]");
	                        System.out.println("Transactions");
	                        ArrayList<Double> transactions = customers.get(i).getTransactions();
	                        for (int j = 0; j < transactions.size(); j++) {
	                            System.out.println("[" + (j + 1) + "]" + "  Amount " + transactions.get(j));
	                        }
	                    }
	                }
	            }
	        } else {
	            ArrayList<Customer> customers;
	            for (Branch branch : branches) {
	                if (branchName.equals(branch.getName())) {
	                    doesExist = true;
	                    customers = branch.getCustomers();
	                    System.out.println("Customer details for branch " + branch.getName());
	                    for(int i = 0; i < customers.size(); i++) {
	                        System.out.println("Customer: " + customers.get(i).getName()+ "["+(i+1)+"]");
	                    }
	                }
	            }
	        }
	        return doesExist;
	    }
}
