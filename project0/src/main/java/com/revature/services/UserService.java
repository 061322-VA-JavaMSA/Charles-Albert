package com.revature.services;

import java.util.Scanner;

import com.revature.daos.UserDAO;
import com.revature.daos.UserDaoImpl;
import com.revature.models.User;

public class UserService {

	public static User create(){
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter username: ");
		String username = scanner.nextLine();
		
		System.out.println("Enter password: ");
		String password = scanner.nextLine();
		
		User user = new User(username, password);
		
		System.out.println("This is the user you created:"+ user.toString());
		
		UserDAO userDAO = new UserDaoImpl();
		user = userDAO.create(user);
		
		return user;
		
	}
}
