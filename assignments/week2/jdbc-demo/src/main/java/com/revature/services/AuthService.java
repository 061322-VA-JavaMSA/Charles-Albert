package com.revature.services;

import com.revature.daos.UserDAO;
import com.revature.daos.UserPostgres;
import com.revature.exceptions.LoginException;
import com.revature.models.User;

public class AuthService {

	private UserDAO ud = new UserPostgres();
	
	
	public User login(String username, String password) throws LoginException {
		
		if(username == null || password == null) {
			throw new LoginException();
		}
		
		User u = ud.retrieveUserByUsername(username);
		
		if(u == null || !u.getPassword().equals(password)) {
			throw new LoginException();
		}
		return u;
		
		
	}
}