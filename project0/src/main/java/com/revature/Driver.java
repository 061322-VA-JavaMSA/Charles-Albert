package com.revature;
import java.util.List;
import java.util.Scanner;

import com.revature.daos.UserDaoImpl;
import com.revature.exceptions.LoginException;
import com.revature.services.AuthService;
import com.revature.services.UserService;
import com.revature.models.User;

public class Driver {
		public static Scanner scan;
		public static AuthService as;
		public static UserService us;
		public static UserDaoImpl useDaoImpl;
 public static void main( String[]args ) {
	 
	 	scan = new Scanner(System.in);
		as = new AuthService();
		us = new UserService();
		useDaoImpl = new UserDaoImpl();
	 boolean flag = true;
	 while (flag == true) {
		 
		String username = null;
		String password = null;
		 
		 System.out.println("Choose an option: ");
		 System.out.println("1. Register a User ");
		 System.out.println("2. quit ");
		 System.out.println("3. login ");
		 int choice;
		 
		 Scanner scanner = new Scanner(System.in);
		 choice = scanner.nextInt();
		 switch (choice) {
		 
		 	case 1:
				 UserService.create();
				 break;
			 
		 	case 2:
		 		System.out.println("quiting now");
		 		flag = false;
		 		break;
		 	case 3: 
		 		System.out.println("Please enter username:");
				username = scan.nextLine();
				System.out.println("Please enter password:");
				password = scan.nextLine();
		 		
				try {
					
					System.out.println(as.login(username, password));
					
				} catch (LoginException | javax.security.auth.login.LoginException e) {
					System.out.println("Invalid credentials.");
					System.out.println("Create username:");
					String uname = scan.nextLine();
					System.out.println("Create, password:");
					String pass = scan.nextLine();
					User userTBC = new User();
					userTBC.setUsername(uname);
					userTBC.setPassword(pass);
					
					//e.printStackTrace();
				}
				}  
		 		
		 		
		 }		
			 	
		 
	 }
	 
	 
	 
	 
	 
 
	
/*	static Scanner scan;
	static AuthService as;
	static UserService us;
	static InventoryService is;
	static UserDaoImpl userDaoImpl;
	public static void main(String[] args) {
		
		
		scan = new Scanner(System.in);
		as = new AuthService();
		us = new UserService();
		is = new InventoryService();
		userDaoImpl = new UserDaoImpl();
		String username = null;
		String password = null;
		
		System.out.println("Please enter username:");
		username = scan.nextLine();
		System.out.println("Please enter password:");
		password = scan.nextLine();
		
		try {
			
			System.out.println(as.login(username, password));
			
		} catch (LoginException e) {
			System.out.println("Invalid credentials.");
			System.out.println("Create username:");
			String uname = scan.nextLine();
			System.out.println("Create, password:");
			String pass = scan.nextLine();
			User userTBC = new User();
			userTBC.setUsername(uname);
			userTBC.setPassword(pass);
			userDaoImpl.create(userTBC);
			e.printStackTrace();
		}
		
		
			List<User> users = us.getUsers();
				for(User u : users) {
					System.out.println(u);
				}	
		
		//System.out.println("Retrieve inventory list");
		//List<Inventory> inventory = is.getIventory();
		//for(Inventory i : inventory ) {
		//	System.out.println(i);
		scan.close();
	}
		
		
	
*/
}
