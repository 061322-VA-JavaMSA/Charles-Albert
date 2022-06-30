package com.revature.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Inventory;

public interface UserDAO {
	
		// C.R.U.D. 
	
	//create
	void createCustomer(Customer c);
	void createEmployee (Employee e);
	
	//read - retrieve
	Customer retrieveCustomerByID(int id);
	Employee retrieveEmployeeByID(int id);
	Customer retrieveCustomerByUsername(String username);
	Employee retrieveEmployeeByUsername(String username);
	
	List<Customer> retrieveCustomers();
	List<Employee> retrieveEmployees();
	
	// update 
	boolean updateUser(int id, boolean isCust, Scanner sc);
	
	//delete
	boolean deleteByID(int id, boolean isCustomer);
	boolean deleteAll(boolean isCustomer);
	
	//make offer on item in inventory
	void makeOffer(float amount, int userID, int itemID);
	
	//view items already owned by customer
	ArrayList<Inventory> ownedItems(int userID);

	 // view any payments made
	void paymentsLeft(int usedId);
	
	
}  





		
	