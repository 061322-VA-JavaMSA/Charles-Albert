package com.revature.daos;

public interface AccountDAO {
	
	Account createAccount(Account a);
	Account retrieveAccountById(int id);
	List<Account>retrieveAccounts();
	boolean updateAccount (Account a);
	boolean deletAccountbyId(int id);
}
