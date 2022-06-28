package com.revature.services;
import javax.security.auth.login.LoginException;
import com.revature.daos.UserDAO;
import com.revature.daos.UserDaoImpl;

import com.revature.models.User;

public class AuthService {

	private UserDAO ud = new UserDaoImpl();
	
	
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