package com.revature.daos;

import java.util.List;

import com.revature.models.Inventory;

public interface InventoryDAO {

	 static Inventory create( Inventory item) {
		// TODO Auto-generated method stub
		return null;
	}
	 Inventory getById(int id);
	 Inventory upDate( Inventory item, int id);
	
	 List<Inventory> retrieveIventory(String itemname);
	 boolean updateInventory(Inventory  itemname);
	 boolean deleteInventoryById(int id);
	 
	
}
