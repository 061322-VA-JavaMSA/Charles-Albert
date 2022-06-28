package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.Util.ConnectionUtil;
import com.revature.models.Inventory;
import com.revature.models.User;

public class InventoryDaoImpl implements InventoryDAO {

	Connection connection;
	
	public Inventory create(Invetory itemname) {
		System.out.println("this method was called");
		String sql = "insert into Inventory (itemname) values (?);";
		try(Connection c = ConnectionUtil.getHardcodedConnection()){
			PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, itemname.getItemname());
			
			
			int count = ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			
				if (count == 1) {
				
					System.out.println("Item added successfully");
					rs.next();
					int generatedId = rs.getInt(1);
				
					itemname.setId(generatedId);
					return itemname;
				}
			}
			
				catch (SQLException e) {
			
					e.printStackTrace();
					System.out.println("Something went wrong with the insertion");
				}
		return null;
	
	} 
	
	@Override
	public Inventory create(Itemname itemname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventory getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventory upDate(Itemname itemname, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Inventory create(Object itemname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventory upDate(Object itemname, int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
