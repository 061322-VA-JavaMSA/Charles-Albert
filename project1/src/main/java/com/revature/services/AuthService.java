package com.revature.services;



import com.revature.daos.UserDAO;
import com.revature.daos.UserHibernate;
import com.revature.exceptions.LoginException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;


public class AuthService {

	private UserDAO ud = new UserHibernate();
	
	
	public User login(String username, String password) throws UserNotFoundException, LoginException {
		
		// principal refers to "currently logged in user"
		User principal;
		
		principal = ud.getUserByUsername(username);
		
		
		if(principal == null) {
			throw new UserNotFoundException();
		}
		
		
		if(!principal.getPassword().equals(password)){
			throw new LoginException();
		}
		
		return principal;
	}
}
