package com.revature;
import java.util.Scanner;

import com.revature.Util.ConnectionUtil;
import com.revature.services.InventoryService;
import com.revature.services.CustomerService;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Inventory;

public class Driver {
static Scanner sc;
	
	static boolean loginOptionSelected;
	static boolean storeMenuSelected;
	static boolean isCustomer;
	
	static CustomerService cs;
	static InventoryService is;
	static Employee e;
	static Customer c ;
	
	static void menuScreen(String input) {
		switch(input) {
		case "1":
			System.out.println("Create Account");
			System.out.println("Do you have an access badge number? [Y] or [N]");
			if(sc.nextLine().equals("Y")) {
				e = new Employee();
				System.out.println("Please enter your name");
				e.setName(sc.nextLine());
				System.out.println("Please enter your Username");
				e.setUserName(sc.nextLine());
				System.out.println("Please enter your Password");
				e.setUserPassword(sc.nextLine());
				System.out.println("Please enter your badge number");
				if(!e.checkemployeeAccess(sc.nextLine())) {
					System.out.println("Incorrect credentials. Exiting.");
					break;
				}
				isCustomer = false;
				cs.createEmployee(e);
				loginOptionSelected = true;
				
			
			}else if(sc.nextLine().equals("N")) {
				c = new Customer();
				System.out.println("Please enter your name");
				c.setName(sc.nextLine());
				System.out.println("Please enter your Username");
				c.setUserName(sc.nextLine());
				System.out.println("Please enter your Password");
				c.setUserPassword(sc.nextLine());
				System.out.println("Please enter your account nummber");
				c.setCustomeAccountNumber(sc.nextLine());
				cs.createCustomer(c);
				isCustomer = true;
				loginOptionSelected = true;
			
			}else {
				System.out.println("Input not recognized. Please try again.");
			}	
			break;
		case "2":
			System.out.println("Login");
			System.out.println("if you want to log in as a Customer enter 1 for, enter 2  for Employee ");
			String choice = sc.nextLine();
			if(choice.equals("1")) {
				isCustomer = true;
			}else if(choice.equals("2")) {
				isCustomer = false;
			}else {
				System.out.println("Input not understood.");
				break;
			}
			System.out.println("Please enter your username");
			String username = sc.nextLine();
			System.out.println("Please enter your password");
			String password = sc.nextLine();
			
			if(isCustomer) {
				c = cs.retrieveCByUsername(username);
				if(c.getUserPassword().equals(password)){
					System.out.println("Login Successful");
				}else {
					System.out.println("Invalid password");
					break;
				}
				}else {
					e = cs.retrieveEByUsername(username);
					if(e.getUserPassword().equals(password)){
						System.out.println("Login Successful");
					
					}else {
						System.out.println("Invalid password");
						break;
					}
				}
			
			
			
		case "3":
			System.out.println("Thank you for shopping with us today. Goodbye.");
			loginOptionSelected = true;
			break;
		default:
			System.out.println("Input not found. Please try again.");
			break;
		}
			
		}
	
	
	static void storeMenuCustomer() {
		System.out.println("Please select an option from below. \n 1: Show Store Inventory\n 2: Make a Purchase\n 3: Show Owned Items\n 4: Update Account\n 5: Show current payments\n 6: Quit");
		String input = sc.nextLine();
		switch(input) {
		case "1":
			showInventory();
			//storeMenuSelected = true;
			break;
		case "2":
			makePurchase();
			//storeMenuSelected = true;
			break;
		case "3":
			showOwnedItems();
			//storeMenuSelected = true;
			break;
		case "4":
			account(true);
			break;
		case "5":
			showPayments();
			break;
		case "6":
			//quit
			System.out.println("Thank you for shopping with us today. Goodbye.");
			storeMenuSelected = true;
			break;
		default:
			System.out.println("Input not found. Please try again.");
			break;
		}
	}
	

	static void storeMenuEmployee() {
		System.out.println("Please select an option from below. \n 1: Show Store Inventory\n 2: Show Purchase History\n 3: Create an Item\n 4: View Item Offers\n 5: Delete a Single Item\n 6: Delete All Items\n 7: Update an Item\n 8: Update Account\n 9: Quit");
	  	String input = sc.nextLine();
	  	
		switch(input) {
		case "1":
			showInventory();
			
			break;
		case "2":
			purchaseHistory();
			
			break;
		case "3":
			createItem();
			
			break;
		case "4":
			viewItemOffers();
			break;
		case "5":
			deleteID();
			break;
		case "6":
			deleteAll();
			break;
		case "7":
			updateItem();
			break;
		case "8":
			account(false);
			;
			break;
		case "9":
			
			System.out.println("Thank you for shopping with us today. Goodbye.");
			storeMenuSelected = true;
			break;
		default:
			System.out.println("Input not found. Please try again.");
			break;
		}
	}
	

	static void showInventory() {
		System.out.println("Inventory\nPlease note the Item ID of any items you would like.");
		is.retrieveInventory();
	}
	
	static void makePurchase() {
		System.out.println("What is the item ID?");
		int itemID = sc.nextInt();
		sc.nextLine();
		
		System.out.println("How much would you like to offer for this item?");
		cs.makeOffer(sc.nextFloat(), c.getUserId(), itemID);
		sc.nextLine();
	}
	
	static void showPayments() {
		System.out.println("Your current payments");
		cs.paymentsLeft(c.getUserId());
	}
	
	static void viewItemOffers() {
		System.out.println("What is the id of the item you want to view?");
		int id = sc.nextInt();
		sc.nextLine();
		is.itemOffer(id, sc);
	}
	
	static void deleteID() {
		System.out.println("What is the id number of the item you want to delete?");
		int id = sc.nextInt();
		sc.nextLine();
		is.deleteByID(id);
	}
	
	static void deleteAll() {
		System.out.println("Are you sure you want to delete all? [Y] or [N]");
		String choice = sc.nextLine();
		if(choice.equals("Y")) {
			is.deleteAll();
		}
		
	}
	
	static void updateItem() {
		System.out.println("What is the id number of the item you want to update?");
		int id = sc.nextInt();
		sc.nextLine();
		is.updateItem(id,sc);
	}
	
	static void purchaseHistory() {
		if(isCustomer) {
			cs.ownedItems(c.getUserId());
		}
		else {
			is.viewPayments();
		}
	}
	
	static void createItem() {
		Inventory i = new Inventory();
		System.out.println("Enter Item Name");
		i.setItemName(sc.nextLine());
		System.out.println("Enter Item Cost");
		i.setItemPrice(sc.nextFloat());
		sc.nextLine();
		System.out.println("Enter Item Description");
		i.setItemModel(sc.nextLine());
		is.createItem(i);
	}
	
	static void account(boolean isCust) {
		if(isCust) {
			cs.updateUser(c.getUserId(), isCustomer,sc);
		}else {

				cs.updateUser(e.getUserId(), isCustomer,sc);
			}
		}
	
	
	static void showOwnedItems() {
		cs.ownedItems(c.getUserId());
	}

	
	
	public static void main(String[] args) {
	//	cs = new CustomerService();
		//is = new InventoryService();

		try {
			ConnectionUtil.getConnectionFromFile();
		}catch (Exception e) {
			
		}
		
		sc = new Scanner(System.in);
		
		System.out.println("Welcome to the Revature Car lot!");
		System.out.println("Please choose an option: \n 1: Register a new account\n 2: Login \n 3: Exit the program");
		
		String choice = sc.nextLine();
		
		while(loginOptionSelected == false){
			Driver.menuScreen(choice);
		}
		 
		if(isCustomer) {
			System.out.println("Welcome " + c.getName());
			while(storeMenuSelected == false){
				storeMenuCustomer();
			}
			}else {
				System.out.println("Welcome " + e.getName());
				while(storeMenuSelected == false){
					storeMenuEmployee();
				}
			}
			
		}
		
		
		
	

     //sc.close();
     }
     


