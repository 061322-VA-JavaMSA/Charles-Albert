package com.revature.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.daos.InventoryDAO;
import com.revature.daos.InventoryDaoImpl;
import com.revature.models.Inventory;

public class InventoryService {
	
	 InventoryDAO id = new InventoryDaoImpl();
	
	public  List<Inventory> getInventory(){
		return id.retrieveInventory();
	}
	
		
	public Inventory createItem(Inventory i) {
		Inventory item = id.createItem(i);
		return item;
	
	}
	
	
	
	public Inventory retrieveByName(String name) {
		Inventory item = id.retrieveByName(name);
		//System.out.println("Item: " + item + "was retrieved");
		return item;
	}
	
	public void retrieveInventory(){
		ArrayList<Inventory> inventory = id.retrieveInventory();
		//System.out.println(inventory.size());
		for(int i = 0; i<inventory.size(); i++) {
			System.out.println("\tItem ID: " + inventory.get(i).getItemId());
			System.out.println("\tItem Name: " + inventory.get(i).getItemName());
			System.out.println("\tItem Description: " + inventory.get(i).getItemModel());
			System.out.println("\tItem Cost: " + inventory.get(i).getItemPrice());
		}
	}
	
	
	public boolean itemOffer(int itemID, Scanner sc) {
		return id.itemOffer(itemID, sc);
	}
	
	public void viewPayments() {
		id.viewPayments();
	}
	
	
	public boolean deleteAll() {
		return id.deleteAll();
	}


	public void updateItem(int id2, Scanner sc) {
		// TODO Auto-generated method stub
		
	}


	public void deleteByID(int id2) {
		// TODO Auto-generated method stub
		
	}
}
