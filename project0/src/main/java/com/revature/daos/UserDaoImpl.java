package com.revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.Util.ConnectionUtil;
import com.revature.models.User;
import com.revature.services.Iventory;

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
		
	
	public List<User> retrieveUsers(){
		String sql = "select * from users;";
		List<User> users = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getHardcodedConnection()){
			
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				
				users.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
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


	public boolean deleteUserById(int id) {
		String sql = "delete from users where id = ?;";
		int rowsChanged = -1;
		try(Connection c = ConnectionUtil.getHardcodedConnection()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);
			rowsChanged = ps.executeUpdate();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rowsChanged < 1) {
			return false;
		}
		return true;
	}
			
	


	@Override
	public List<User> retrievUsers() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public User retrieveUserByUsername(String username) {
		String sql = "select * from users where username  = ?;";
		User u = null;
		
		try (Connection c = ConnectionUtil.getHardcodedConnection();){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, username); 

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				u = new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
			} 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
	}
	
	@Override
	public User retrieveUserById(int id) {
		String sql = "select * from users where id = ?;";
		User user = null;
		
		try(Connection c = ConnectionUtil.getHardcodedConnection()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, id); // this refers to the 1st ? in the sql String
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}


	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}


	public List<Iventory> retrievIventory() {
		// TODO Auto-generated method stub
		return null;
	}

}
