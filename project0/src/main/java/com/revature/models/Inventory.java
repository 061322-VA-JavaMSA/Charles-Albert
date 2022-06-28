package com.revature.models;

import java.util.Objects;

public class Inventory {
	
	private int id;
	private String itemname;
	private float itemprice;
	private String status;
	
	
	public Inventory() {
		
			super();
		}
	public Inventory(int id, String itemname, float itemprice, String status) {
		
		this.id = id;
		this.itemname = itemname;
		this.itemprice = itemprice;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public float getItemprice() {
		return itemprice;
	}
	public void setItemprice(float itemprice) {
		this.itemprice = itemprice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, itemname, itemprice, status);
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
		return id == other.id && Objects.equals(itemname, other.itemname)
				&& Float.floatToIntBits(itemprice) == Float.floatToIntBits(other.itemprice)
				&& Objects.equals(status, other.status);
	}
	@Override
	public String toString() {
		return "Inventory [id=" + id + ", itemname=" + itemname + ", itemprice=" + itemprice + ", status=" + status
				+ "]";
	}
	
	

}
