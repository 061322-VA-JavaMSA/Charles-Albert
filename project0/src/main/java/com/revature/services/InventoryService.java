package com.revature.services;

import java.util.List;
import java.util.Scanner;

import com.revature.daos.InventoryDAO;
import com.revature.daos.InventoryDaoImpl;
import com.revature.models.Inventory;

public class InventoryService {
	//private UserDaoImpl iD = new UserDaoImpl();
	private InventoryDAO id = new InventoryDaoImpl();
	public  List<Inventory> getIventory(String item){
		return id.retrieveIventory( item);
	}
	
	
public static Inventory create(){
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Item name: ");
		String item = scanner.nextLine();
		
		System.out.println("Enter Item price: ");
		String itemprice = scanner.nextLine();
		
		 Inventory  item1 = new Inventory ();
		
		System.out.println("This is the user you created:"+ item1.toString());
		
		InventoryDAO DAO = new InventoryDaoImpl();
		item1 = InventoryDAO.create(item1);
		
		return item1;
		
	}
}
