package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.Util.ConnectionUtil;
import com.revature.daos.UserDAO;



public class UserPostgres implements UserDAO{
	
	@Override
	public User createUser(User u) {
		String sql = "insert into users_info (username, password) values (?,?) returning id;";
		try(Connection c = ConnectionUtil.getHardcodedConnection()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			
			ResultSet rs = ps.executeQuery(); 
			if(rs.next()) {
				u.setId(rs.getInt("id"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
	}

	@Override
	public User retrieveUserById(int id) {
		
		
		return null;
	}

	@Override
	public List<User> retrieveUsers(){
		String sql = "select * from users_info;";
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
	public User retrieveUserByUsername(String username) {
		String sql = "select * from users_info where username  = ?;";
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
				u.setStatus(rs.getString("status"));;
			} 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
	}

	@Override
	public boolean updateUser(User u) {
		String sql = "update users_info set username = ?, password = ? where id = ?;";
		int rowsChanged = -1;
		
		try(Connection c = ConnectionUtil.getHardcodedConnection()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setInt(3, u.getId());
			
			rowsChanged = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rowsChanged < 1) {
			return false;
		}
		return true;
	}

	

}
