package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.exceptions.LoginException;
import com.revature.models.User;
import com.revature.services.AuthService;
//import com.revature.services.TaskService;
import com.revature.services.UserService;

public class Driver {
		
	static Scanner scan;
	static AuthService as;
	static UserService us;
	//static TaskService ts;
	
	public static void main(String[] args) {
		
		
		scan = new Scanner(System.in);
		as = new AuthService();
		us = new UserService();
		//ts = new TaskService();
		
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
			e.printStackTrace();
		}

	}
}
