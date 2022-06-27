package com.revature.models;

import java.util.Objects;

public class Inventory {
	
	private int item_id;
	private String item_name;
	private String item_status;
	
	
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getItem_id() {
		return item_id;
	}


	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}


	public String getItem_name() {
		return item_name;
	}


	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}


	public String getItem_status() {
		return item_status;
	}


	public void setItem_status(String item_status) {
		this.item_status = item_status;
	}


	@Override
	public int hashCode() {
		return Objects.hash(item_id, item_name, item_status);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inventory other = (Inventory) obj;
		return item_id == other.item_id && Objects.equals(item_name, other.item_name)
				&& Objects.equals(item_status, other.item_status);
	}


	@Override
	public String toString() {
		return "Inventory [item_id=" + item_id + ", item_name=" + item_name + ", item_status=" + item_status + "]";
	}
	
	
	

}
