package com.revature.models;

import java.util.Objects;

public class Inventory  {
	
	private int itemId;
	private String itemName;
	private String itemModel;
	public String getItemModel() {
		return itemModel;
	}
	public void setItemModel(String itemModel) {
		this.itemModel = itemModel;
	}
	private float itemPrice;
	
	private int buyerId;
	private boolean isOwned;
	
	
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
	public void setId(boolean b) {
		this.itemId = b;
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
	
	@Override
	public int hashCode() {
		return Objects.hash(buyerId, isOwned, itemId, itemModel, itemName, itemPrice);
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
		return buyerId == other.buyerId && isOwned == other.isOwned && itemId == other.itemId
				&& Objects.equals(itemModel, other.itemModel) && Objects.equals(itemName, other.itemName)
				&& Float.floatToIntBits(itemPrice) == Float.floatToIntBits(other.itemPrice);
	}
	@Override
	public String toString() {
		return "Inventory [itemId=" + itemId + ", itemName=" + itemName + ", itemModel=" + itemModel + ", itemPrice="
				+ itemPrice + ", buyerId=" + buyerId + ", isOwned=" + isOwned + "]";
	}
	public void setId(int int1) {
		// TODO Auto-generated method stub
		
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	 
	

}
