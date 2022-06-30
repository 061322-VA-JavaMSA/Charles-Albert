package com.revature.daos;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.models.Inventory;

public interface InventoryDAO {

	 public Inventory create(Inventory item);
		
	
	//Create items
		Inventory createItem(Inventory i);
		
		//Retrieve item
		Inventory retrieveById(int id);
		Inventory retrieveByName(String name);
		
		//Retrieve list of all items
		ArrayList<Inventory> retrieveInventory();
		
		//View items offer and reject or accept
		boolean itemOffer(int itemID, Scanner sc);
		
		
		//view all payments left
		void viewPayments();
		
		//delete items
		boolean deleteByID(int id);
		boolean deleteAll();
		
		//update item information
		boolean updateItem(int id, Scanner sc);
	 
	
}
