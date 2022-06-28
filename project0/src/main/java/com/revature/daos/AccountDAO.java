package com.revature.daos;

import java.util.List;

import com.revature.models.Account;

public interface AccountDAO {
	
	public Account createAccount(Account a);
	Account retrieveAccountById(int id);
	List<Account>retrieveAccounts();
	boolean updateAccount (Account a);
	boolean deletAccountbyId(int id);
}
