package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemsDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Items> {

	public static final Logger LOGGER = LogManager.getLogger();

	private ItemsDAO itemsDAO;
	private Utils utils;

	public ItemController(ItemsDAO itemsDAO, Utils utils) {
		super();
		this.itemsDAO = itemsDAO;
		this.utils = utils;
	}

	/**
	 * Reads all items to the logger
	 */
	@Override
	public List<Items> readAll() {
		List<Items> items = itemsDAO.readAll();
		for (Items item : items) {
			LOGGER.info(item);
		}
		return items;
	}

	/**
	 * Creates an item by taking in user input
	 */
	@Override
	public Items create() {
		LOGGER.info("Please enter an item");
		String orderItem = utils.getString();
		LOGGER.info("Please enter an items price");
		Double price = utils.getDouble();
		Items items = itemsDAO.create(new Items(orderItem, price));
		LOGGER.info("Item created");
		return items;
	}

	/**
	 * Updates an existing item by taking in user input
	 */
	@Override
	public Items update() {
		LOGGER.info("Please enter the ItemID of the item you would like to update");
		Long ItemID = utils.getLong();
		LOGGER.info("Please enter an item name");
		String orderItem = utils.getString();
		LOGGER.info("Please enter the items price");
		Double price = utils.getDouble();
		Items items = itemsDAO.update(new Items(ItemID, orderItem, price));
		LOGGER.info("Item Updated");
		return items;
	}

	/**
	 * Deletes an existing item by the ItemID of the customer
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the ItemID of the item you would like to delete");
		Long id = utils.getLong();
		return itemsDAO.delete(itemID);
	}

}


