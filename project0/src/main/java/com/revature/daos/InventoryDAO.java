package com.revature.daos;

import java.util.List;

import com.revature.models.Inventory;

public interface InventoryDAO {

	 public Inventory create(Inventory itemmame);
		
	
	 public Inventory getById(int id);
	 public Inventory getByItemname(String itemname);
	 public Inventory upDate( Inventory item, int id );
	
	 public List<Inventory> retrieveInventory();
	 public Inventory retrieveInventoryByItemname(String itemname);
	 public Inventory retrieveInventoryById(int id);
	 boolean deleteInventoryById(int id);
	 
	
}
