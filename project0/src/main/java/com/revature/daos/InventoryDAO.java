package com.revature.daos;

import java.util.List;

import com.revature.models.Inventory;

public interface InventoryDAO<Itemname> {

	 Inventory create(Itemname itemname);
	 Inventory getById(int id);
	 Inventory upDate(Itemname itemname, int id);
	 List<Inventory> retrieveIventory(String itemname);
	 boolean updateInventory(Itemname itemname);
	 boolean deleteInventoryById(int id);
	 
	
}
