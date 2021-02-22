package com.qa.ims.persistence.domain;

public class Items {
	
	private Long itemID;
	private String orderItem;
	private Double price;
	
	public Items(String orderItem, Double price) {
		this.setOrderItem(orderItem);
		this.setPrice(price);
	}

	public Items(Long itemID, String orderItem, Double price) {
		this.setItemID(itemID);
		this.setOrderItem(orderItem);
		this.setPrice(price);
	}

	public Long getItemID() {
		return itemID;
	}

	public void setItemID(Long ItemID) {
		this.itemID = ItemID;
	}

	public String getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(String orderItem) {
		this.orderItem = orderItem;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ItemID:" + itemID + " Item:" + orderItem + " price:" + price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderItem == null) ? 0 : orderItem.hashCode());
		result = prime * result + ((itemID == null) ? 0 : itemID.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Items other = (Items) obj;
		if (getOrderItem() == null) {
			if (other.getOrderItem() != null)
				return false;
		} else if (!getOrderItem().equals(other.getOrderItem()))
			return false;
		if (itemID == null) {
			if (other.itemID != null)
				return false;
		} else if (!itemID.equals(other.itemID))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}

}