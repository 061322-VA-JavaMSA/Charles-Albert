package com.revature.models;

import java.util.Objects;

public class account {

	private int id;
	private float accountBal;
	private float accountDep;
	private float accountwithdraw;
	
	
	
	public account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public account(int id) {
		
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
		return Objects.hash(accountBal, accountDep, accountwithdraw, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		account other = (account) obj;
		return Float.floatToIntBits(accountBal) == Float.floatToIntBits(other.accountBal)
				&& Float.floatToIntBits(accountDep) == Float.floatToIntBits(other.accountDep)
				&& Float.floatToIntBits(accountwithdraw) == Float.floatToIntBits(other.accountwithdraw)
				&& id == other.id;
	}
	@Override
	public String toString() {
		return "account [id=" + id + ", accountBal=" + accountBal + ", accountDep=" + accountDep + ", accountwithdraw="
				+ accountwithdraw + "]";
	}
	
	
}
