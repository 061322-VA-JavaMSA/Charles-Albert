package com.revature.daos;

import com.revature.models.Inventory;

public interface InventoryDAO {

	public Inventory create(Itemname itemname);
	public Inventory getById(int id);
	public Inventory upDate(Itemname itemname, int id);
	
	public void delete (int id);
	
}
