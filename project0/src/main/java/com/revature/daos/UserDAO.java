package com.revature.daos;

import java.util.List;

import com.revature.models.User;

public interface UserDAO {
	
	public User create(User user);
	public User getById(int id);
	public User getByUsername(String username);
	public User update(User user, int id);
	
	public void delete(int id); 
	
	
	
}
