package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.Util.ConnectionUtil;
import com.revature.models.Inventory;

public class InventoryDaoImpl implements InventoryDAO {

	Connection connection;

	
	public Inventory create( Inventory itemname) {
		System.out.println("this method was called");
		String sql = "insert into inventory (itemname, itemprice) values (?,?);";
		try(Connection c = ConnectionUtil.getHardcodedConnection()){
			PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, itemname.getItemname());
			ps.setFloat(2, itemname.getItemprice());
			
			int count = ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			
				if (count == 1) {
				
					System.out.println("User added successfully");
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
	
	public Inventory retrieveInventoryByItemname(String itemname) {
		String sql = "select * from users where username  = ?;";
		Inventory i = null;
		
		try (Connection c = ConnectionUtil.getHardcodedConnection();){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, itemname); 

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				i = new Inventory();
				i.setId(rs.getInt("id"));
				i.setItemname(rs.getString("itemname"));
				i.setItemprice(rs.getFloat("itemprice"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	@Override
	public Inventory getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventory upDate(Inventory itemname, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Inventory> retrieveIventory(String itemname) {
		String sql = "select * from inventory where intemname = ?;";
	    Inventory item = null;
		
		
		try(Connection c = ConnectionUtil.getHardcodedConnection();){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, itemname);
			
			ResultSet rs = ps.executeQuery();
			item = new Inventory();
			item.setId(rs.getInt("id"));
			item.setItemname(rs.getString("Itemname"));
			item.setItemprice(rs.getInt("itemprice"));
		}catch (SQLException e) {
				e.printStackTrace();
			}return null;
	}
	
	
		
	



	@Override
	public boolean deleteInventoryById(int id) {
		String sql = "delete from inventory where id = ?;";
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
	public boolean updateInventory(Inventory itemname) {
		// TODO Auto-generated method stub
		return false;
	}
	
}



