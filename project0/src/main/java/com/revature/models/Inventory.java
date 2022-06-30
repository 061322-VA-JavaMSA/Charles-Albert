package com.revature.models;

import java.util.Objects;

public class Inventory  {
	
	private int itemId;
	private String itemName;
	private String itemModel;
	private float itemPrice;
	
	private int buyersId;
	boolean isOwned;
	
	


	public int getBuyersId() {
		return buyersId;
	}


	public void setBuyersId(int buyersId) {
		this.buyersId = buyersId;
	}


	public boolean isOwned() {
		return isOwned;
	}


	public void setOwned(boolean isOwned) {
		this.isOwned = isOwned;
	}


	public Inventory() {
		super();
	}


	public int getItemId() {
		return itemId;
	}


	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public String getItemModel() {
		return itemModel;
	}


	public void setItemModel(String itemModel) {
		this.itemModel = itemModel;
	}


	public float getItemPrice() {
		return itemPrice;
	}


	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}


	@Override
	public int hashCode() {
		return Objects.hash(buyersId, isOwned, itemId, itemModel, itemName, itemPrice);
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
		return buyersId == other.buyersId && isOwned == other.isOwned && itemId == other.itemId
				&& Objects.equals(itemModel, other.itemModel) && Objects.equals(itemName, other.itemName)
				&& Float.floatToIntBits(itemPrice) == Float.floatToIntBits(other.itemPrice);
	}
	
	
	@Override
	public String toString() {
		return "Inventory [itemId=" + itemId + ", itemName=" + itemName + ", itemModel=" + itemModel + ", itemPrice="
				+ itemPrice + ", buyersId=" + buyersId + ", isOwned=" + isOwned + "]";
	}


	public void setStatus(String string) {
		// TODO Auto-generated method stub
		
	}
}
