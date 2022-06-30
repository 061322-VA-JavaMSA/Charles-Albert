package com.revature.models;

import java.util.Objects;

public class Inventory  {
	
	private int itemId;
	private String itemName;
	private float itemPrice;
	private String status;
	private int id;
	
	
	public Inventory() {
		
			super();
		}
	public Inventory( String itemname, float itemprice) {
		
		
		this.itemName = itemname;
		this.itemPrice = itemprice;
		
	}
	public int getId() {
		return id;
	
		 
	}
	public void setId(boolean b) {
		this.id = b;
	}
	public String getItemname() {
		return itemName;
	}
	public void setItemname(String itemname) {
		this.itemName = itemname;
	}
	public float getItemprice() {
		return itemPrice;
	}
	public void setItemprice(float itemprice) {
		this.itemPrice = itemprice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, itemName, itemPrice, status);
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
		return id == other.id && Objects.equals(itemName, other.itemName)
				&& Float.floatToIntBits(itemPrice) == Float.floatToIntBits(other.itemPrice)
				&& Objects.equals(status, other.status);
	}
	@Override
	public String toString() {
		return "Inventory [id=" + id + ", itemname=" + itemName + ", itemprice=" + itemPrice + ", status=" + status
				+ "]";
	}
	public void setId(int int1) {
		// TODO Auto-generated method stub
		
	}
	 
	

}
