package com.qa.ims.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;


import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Orders> {

	public static final Logger LOGGER = LogManager.getLogger();
	
	private OrderDAO orderDAO;
	private Utils utils;
	
	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}
	
	
	@Override
	public List<Orders> readAll() {
		// TODO Auto-generated method stub
		List<Orders> orders = orderDAO.readAll();
		for (Orders order : orders) {
			 LOGGER.info(order);
		}
		return orders;
	}

	@Override
	public Orders create() {
		LOGGER.info("Please enter an customerID");
		Long customerID = utils.getLong();
		LOGGER.info("Please enter a itemID");
		Long itemID = utils.getLong();
		LOGGER.info("Please enter a quantity");
		Long quantity = utils.getLong();
		Orders order = orderDAO.create(new Orders(customerID, itemID, quantity));
		LOGGER.info("Customer created");
		return order;
	}

	@Override
	public Orders update() {
		LOGGER.info("Please enter the orderID of the order you would like to update");
		Long orderID = utils.getLong();
		LOGGER.info("Please enter an customerID");
		Long customerID = utils.getLong();	
		LOGGER.info("Please enter an itemID");
		Long itemID = utils.getLong();
		LOGGER.info("Please enter the quantity");
		Long quantity = utils.getLong();
		
		Orders order = orderDAO.update(new Orders(orderID, customerID, itemID, quantity));
		LOGGER.info("Customer Updated");
		return order;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the customer you would like to delete");
		Long orderID = utils.getLong();
		return orderDAO.delete(orderID);
	}

}
