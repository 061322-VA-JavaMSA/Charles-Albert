package com.revature.models;

import java.util.Objects;

public class Inventory  {
	
	private int itemId;
	private String itemName;
	private float itemPrice;
	private String status;
	
	
	public Inventory() {
		
			super();
		}
	public Inventory( String itemname, float itemprice) {
		
		
		this.itemName = itemname;
		this.itemPrice = itemprice;
		
	}
	public int getId() {
		return itemId;
	
		 
	}
	public void setId(int id) {
		this.itemId = id;
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
		return Objects.hash(itemId, itemName, itemPrice, status);
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
		return itemId == other.itemId && Objects.equals(itemName, other.itemName)
				&& Float.floatToIntBits(itemPrice) == Float.floatToIntBits(other.itemPrice)
				&& Objects.equals(status, other.status);
	}
	@Override
	public String toString() {
		return "Inventory [id=" + itemId + ", itemname=" + itemName + ", itemprice=" + itemPrice + ", status=" + status
				+ "]";
	}
	 
	

}
