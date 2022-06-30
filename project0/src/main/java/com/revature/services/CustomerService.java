package com.revature.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.revature.daos.UserDaoImpl;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Inventory;

public class CustomerService {
	UserDaoImpl udi = new UserDaoImpl();
		
	public void createCustomer(Customer c) {
		udi.createCustomer(c);
		
	}
	
	public void createEmployee(Employee e) {
		udi.createEmployee(e);
		
	}
	

	public Customer retrieveCByID(int id) {
		Customer cc = udi.retrieveCustomerByID(id);
		
		return cc;
	}
	
	
	public Employee retrieveEByID(int id) {
		Employee ee = udi.retrieveEmployeeByID(id);
		
		return ee;
	}
	
	public Customer retrieveCByUsername(String customer_name) {
		Customer cc = udi.retrieveCustomerByUsername(customer_name);
		
		return cc;
	}
	
	public Employee retrieveEByUsername(String username) {
		Employee ee = udi.retrieveEmployeeByUsername(username);
		return ee;
	}
	
	public void retrieveCustomers(){
		List<Customer> customers = udi.retrieveCustomers();
		System.out.println("Your customers are: ");
		for(int i = 0; i< customers.size(); i++) {
			//log.info("Customer: " + customers.get(i).toString());
			System.out.println("\tCustomer ID: " + customers.get(i).getUserId());
			System.out.println("\tCustomer Name: " + customers.get(i).getName());
		}
	}
	
	public void retrieveEmployees(){
		List<Employee> employees = udi.retrieveEmployees();
		System.out.println("Your customers are: ");
		for(int i = 0; i< employees.size(); i++) {
			//log.info("Employee: " + employees.get(i).toString());
			System.out.println("\tEmployee ID: " + employees.get(i).getUserId());
			System.out.println("\tEmployee Name: " + employees.get(i).getName());
		}
	}
	
	
	public boolean deleteByID(int id, boolean isCustomer) {
		return udi.deleteByID(id, isCustomer);
	}
	public boolean deleteAll(boolean isCustomer) {
		return udi.deleteAll(isCustomer);
	}
	
	//update User info
	public void updateUser(int id, boolean isCustomer, Scanner sc) {
		udi.updateUser(id, isCustomer, sc);
	}
	
	//make offer for item
	public void makeOffer(float amount, int userID, int itemID) {
		udi.makeOffer(amount, userID, itemID);
	}
	
	//view all owned items
	public void ownedItems(int userID){
		ArrayList<Inventory> ownerInv = udi.ownedItems(userID);
		System.out.println("Your owned items: ");
		for(int i = 0; i< ownerInv.size(); i++) {
			//log.info("Item: " + ownerInv.get(i).toString());
			System.out.println("\tItem ID: "+ ownerInv.get(i).getItemId());
			System.out.println("\tItem Name: " + ownerInv.get(i).getItemId());
			System.out.println("\tItem Description: " + ownerInv.get(i).getItemModel());
		}
	}
	
	//view payments left
	public void paymentsLeft(int userID) {
		udi.paymentsLeft(userID);
	}
	
		
	
		
	
	
	
	
	
	
}
