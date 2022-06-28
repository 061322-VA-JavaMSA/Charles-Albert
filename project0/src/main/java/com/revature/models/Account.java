package com.revature.models;

import java.util.Objects;

import com.revature.daos.AccountDaoImpl;

public class Account {

	private int id;
	private float accountBal;
	private float accountDep;
	private float accountwithdraw;
	private User userAssigned;
	
	
	public User getUserAssigned() {
		return userAssigned;
	}


	public void setUserAssigned(User userAssigned) {
		this.userAssigned = userAssigned;
	}


	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Account(int id) {
		
		this.id = id;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getAccountBal() {
		return accountBal;
	}
	public void setAccountBal(float accountBal) {
		this.accountBal = accountBal;
	}
	public float getAccountDep() {
		return accountDep;
	}
	public void setAccountDep(float accountDep) {
		this.accountDep = accountDep;
	}
	public float getAccountwithdraw() {
		return accountwithdraw;
	}
	public void setAccountwithdraw(float accountwithdraw) {
		this.accountwithdraw = accountwithdraw;
	}
	@Override
	public int hashCode() {
		return Objects.hash(accountBal, accountDep, accountwithdraw, id, userAssigned);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Float.floatToIntBits(accountBal) == Float.floatToIntBits(other.accountBal)
				&& Float.floatToIntBits(accountDep) == Float.floatToIntBits(other.accountDep)
				&& Float.floatToIntBits(accountwithdraw) == Float.floatToIntBits(other.accountwithdraw)
				&& id == other.id && Objects.equals(userAssigned, other.userAssigned);
	}
	@Override
	public String toString() {
		return "account [id=" + id + ", accountBal=" + accountBal + ", accountDep=" + accountDep + ", accountwithdraw="
				+ accountwithdraw + ", userAssigned=" + userAssigned + "]";
	}


	public static AccountDaoImpl createAccount(Account a) {
		// TODO Auto-generated method stub
		return null;
	}


	public static Account createAccount(AccountDaoImpl a) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
