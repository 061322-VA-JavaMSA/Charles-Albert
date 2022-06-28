package com.revature.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.Util.ConnectionUtil;
import com.revature.models.Inventory;
import com.revature.models.User;

public class InventoryDaoImpl implements InventoryDAO {

	Connection connection;

	@Override
	public Inventory create(Object itemname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventory getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventory upDate(Object itemname, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List retrieveIventory(String itemname) {
		String sql = "select * from inventory where intemname = ?;";
	    itemname = null;
		return null;
		
		try(Connection c = ConnectionUtil.getHardcodedConnection();){
			
			}catch (SQLException e)

	@Override
	public boolean updateInventory(Object itemname) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteInventoryById(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	}

}
