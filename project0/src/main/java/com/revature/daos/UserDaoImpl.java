package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.Util.ConnectionUtil;
import com.revature.models.User;

public class UserDaoImpl implements UserDAO{

	
	Connection connection;
	
	public User create(User user) {
		System.out.println("this method was called");
		String sql = "insert into users_info (username, password) values (?,?);";
		try(Connection c = ConnectionUtil.getHardcodedConnection()){
			PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			
			int count = ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			
				if (count == 1) {
				
					System.out.println("User added successfully");
					rs.next();
					int generatedId = rs.getInt(1);
				
					user.setId(generatedId);
					return user;
				}
			}
			
				catch (SQLException e) {
			
					e.printStackTrace();
					System.out.println("Something went wrong with the insertion");
				}
		return null;
	
	} 
		
	

	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User user, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
