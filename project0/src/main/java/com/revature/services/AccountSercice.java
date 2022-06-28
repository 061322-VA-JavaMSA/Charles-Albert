package com.revature.services;

import java.util.List;
import java.util.Scanner;

import com.revature.daos.AccountDAO;
import com.revature.daos.AccountDaoImpl;
import com.revature.daos.InventoryDAO;
import com.revature.daos.InventoryDaoImpl;
import com.revature.models.Account;
import com.revature.models.Inventory;
public class AccountSercice {

	private AccountDAO ad =  new AccountDaoImpl();
	
	public Account getAccount(int id) {
		return ad.retrieveAccountById(id);
	}

	
public static Account create(){
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Item name: ");
		String item = scanner.nextLine();
		
		System.out.println("Enter Item price: ");
		String itemprice = scanner.nextLine();
		
		 Account  a1 = new Account ();
		
		System.out.println("This is the account you created:"+ a1.toString());
		
		AccountDaoImpl a = new AccountDaoImpl();
		a1 = Account.createAccount(a);
		
		return a1;
		
	}
}
