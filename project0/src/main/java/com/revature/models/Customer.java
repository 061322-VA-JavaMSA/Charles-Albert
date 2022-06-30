package com.revature.models;

import java.util.Objects;

public class Customer extends User{
	
	private String customeAccountNumber;

	public String getCustomeAccountNumber() {
		return customeAccountNumber;
	}

	public void setCustomeAccountNumber(String customeAccountNumber) {
		this.customeAccountNumber = customeAccountNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(customeAccountNumber);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(customeAccountNumber, other.customeAccountNumber);
	}

	@Override
	public String toString() {
		return "Customer [customeAccountNumber=" + customeAccountNumber + "]";
	}

	public void setUserID(int int1) {
		// TODO Auto-generated method stub
		
	}
	
	

}
