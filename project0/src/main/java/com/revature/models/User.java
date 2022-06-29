package com.revature.models;

import java.util.Objects;

public abstract class User {

	private int userId;
	private String userName;
	private String userPassword;
	private String name;
	
	
	User(){}
	
	
	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getUserPassword() {
		return userPassword;
	}



	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}


	@Override
	public int hashCode() {
		return Objects.hash(name, userId, userName, userPassword);
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
		return Objects.equals(name, other.name) && userId == other.userId && Objects.equals(userName, other.userName)
				&& Objects.equals(userPassword, other.userPassword);
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", name=" + name
				+ "]";
	}



	
	
	
	
	
	
	
}


