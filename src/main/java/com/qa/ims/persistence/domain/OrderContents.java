package com.qa.ims.persistence.domain;

public class OrderContents {
	
	private Long orderContentsID;
	private Long orderID;
	private Long itemID;
	private Long quantity;
	
	public OrderContents(Long orderID,Long itemID, Long quantity) {
		
		this.setOrderID(orderID);
		this.setItemID(itemID);
		this.setQuantity(quantity);
		
	}
public OrderContents(Long orderContentsID, Long orderID, Long itemID, Long quantity) {
		
		this.setOrderContentsID(orderContentsID);
		this.setOrderID(orderID);
		this.setItemID(itemID);
		this.setQuantity(quantity);
}

	
	public Long getOrderContentsID() {
		
		return orderContentsID;
	}

	public void setOrderContentsID(Long orderContentsID) {
		
		this.orderContentsID = orderContentsID;
	}

	public Long getOrderID() {
		
		return orderID;
	}

	public void setOrderID(Long orderID) {
		
		this.orderID = orderID;
	}

	public Long getItemID() {
		return itemID;
	}

	public void setItemID(Long itemID) {
		this.itemID = itemID;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemID == null) ? 0 : itemID.hashCode());
		result = prime * result + ((orderContentsID == null) ? 0 : orderContentsID.hashCode());
		result = prime * result + ((orderID == null) ? 0 : orderID.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
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
		OrderContents other = (OrderContents) obj;
		if (itemID == null) {
			if (other.itemID != null)
				return false;
		} else if (!itemID.equals(other.itemID))
			return false;
		if (orderContentsID == null) {
			if (other.orderContentsID != null)
				return false;
		} else if (!orderContentsID.equals(other.orderContentsID))
			return false;
		if (orderID == null) {
			if (other.orderID != null)
				return false;
		} else if (!orderID.equals(other.orderID))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}
	
	
	
	
	

}
