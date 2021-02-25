package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrdersTest {
	
	Orders order= new Orders(1L,1L,1L);

	@Test
	public void testEquals() {
		EqualsVerifier.forClass(Orders.class).verify();
	}
	@Test
	public void OrdersConstructorTest() {
		Orders order = new Orders(1L, 1L, 1L);
		
		assertTrue(order instanceof Orders);
	}
	@Test
	public void OrdersConstructorTest1() {
		Orders order = new Orders(1L, 1L, 1L,1L);
		
		assertTrue(order instanceof Orders);
	}

	@Test
	public void OrdersConstructorTest2() {
		Orders order = new Orders(1L, 1L, 1L,1L,1D);
	
		assertTrue(order instanceof Orders);
}

	public Long getOrderIDTest() {
		order.setOrderID(1L);
		long result = order.getOrderID();
		return result;
}	

	public void setOrderID(Long orderID) {
		order.setOrderID(1L);
		long result = order.getOrderID();
		return result;
}	

	public Long getCustomerID() {
		return customerID;
}

	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
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

	public Double getCost() {
		return cost;
}

	public void setCost(Double cost) {
		this.cost = cost;
}

	@Override
	public String toString() {
	
	return "orderID: " + orderID + " customerID: " + customerID +"\n" + "itemID: " + itemID + " quantity: " + quantity + "\n" + "Cost: " + cost;
}

}


	
	