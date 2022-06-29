package com.revature.services;

import java.util.List;
import java.util.Scanner;

import com.revature.daos.InventoryDAO;
import com.revature.daos.InventoryDaoImpl;
import com.revature.models.Inventory;

public class InventoryService {
	
	private InventoryDAO id = new InventoryDaoImpl();
	
	public  List<Inventory> getInventory(){
		return id.retrieveInventory();
	}
	
	
public static Inventory create(){
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Item name: ");
		String itemname = scanner.nextLine();
		
		System.out.println("Enter Item price: ");
		float itemprice = scanner.nextFloat();
		
		 Inventory  item = new Inventory (itemname, itemprice);
		
		System.out.println("This is the iventory you created:"+ item.toString());
		
		InventoryDAO inventoryDAO = new InventoryDaoImpl();
		item = inventoryDAO.create(item);
		
		return item;
		
	}
}
