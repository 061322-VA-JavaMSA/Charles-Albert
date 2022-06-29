package com.revature.models;

import java.util.List;
import java.util.Objects;

public class User {

	private int id;
	private String username;
	private String password;
	private String status;
	private int account_id; 
	private float accountbal;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int id, String username, String password, String status, int account_id, float accouunbal) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.status = status;
		this.account_id = account_id;
		this.accountbal = accountbal;
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public float getAccountbal() {
		return accountbal;
	}

	public void setAccountbal(float accountbal) {
		this.accountbal = accountbal;
	}

	@Override
	public int hashCode() {
		return Objects.hash(account_id, accountbal, id, password, status, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return account_id == other.account_id
				&& Float.floatToIntBits(accountbal) == Float.floatToIntBits(other.accountbal) && id == other.id
				&& Objects.equals(password, other.password) && Objects.equals(status, other.status)
				&& Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username +  ", status=" + status
				+ ", account_id=" + account_id + ", accountbal=" + accountbal + "]";
	}

	public String getByUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}


