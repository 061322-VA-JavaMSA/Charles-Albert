package com.revature.services;

import java.util.List;
import java.util.Scanner;

import com.revature.daos.InventoryDAO;
import com.revature.daos.InventoryDaoImpl;
import com.revature.daos.UserDAO;
import com.revature.daos.UserDaoImpl;
import com.revature.models.Inventory;
import com.revature.models.User;

public class InventoryService {
	private UserDaoImpl iD = new UserDaoImpl();
	
	public  List<Iventory> getIventory(){
		return iD.retrievIventory();
	}
	
	
public static Inventory create(){
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Item name: ");
		String itemname = scanner.nextLine();
		
		System.out.println("Enter Item price: ");
		String itemprice = scanner.nextLine();
		
		 Inventory  itemname = new Inventory (itemname, itemprice);
		
		System.out.println("This is the user you created:"+ itemname.toString());
		
		InventoryDAO DAO = new InventoryDaoImpl();
		itemname = InventoryDAO.create(itemname);
		
		return itemname;
		
	}
}
