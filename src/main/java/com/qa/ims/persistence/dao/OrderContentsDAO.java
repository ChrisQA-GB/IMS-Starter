package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.OrderContents;
import com.qa.ims.utils.DBUtils;

public class OrderContentsDAO implements Dao<OrderContents> {

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public OrderContents modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderContentsID = resultSet.getLong("orderContentsID");
		Long orderID = resultSet.getLong("orderID");
		Long itemID = resultSet.getLong("itemID");
		Long quantity = resultSet.getLong("quantity");
		return new OrderContents(orderContentsID, orderID, itemID, quantity);

	}

	@Override
	public List<OrderContents> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");) {
			List<OrderContents> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	@Override
	public OrderContents read(Long ordercontentID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM orderscontents WHERE ordercontentID = ?");) {
			statement.setLong(1, ordercontentID);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	
	
	public OrderContents readLatestOrderContents() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM ordercontents WHERE ordercontentsid = ? ORDER BY ordercontentsID DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public OrderContents create(OrderContents ordercontents) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"INSERT INTO ordercontents(orderID, itemID, quantity) VALUES (?, ?, ?)");) {
			statement.setLong(1, ordercontents.getOrderID());
			statement.setLong(2, ordercontents.getItemID());
			statement.setLong(3, ordercontents.getQuantity());
			statement.executeUpdate();
			
			return readLatestOrderContents();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public OrderContents update(OrderContents ordercontents) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"UPDATE ordercontents SET orderID = ?, itemID = ?, quantity = ? WHERE ordercontentsid = ?");) {
			statement.setLong(1, ordercontents.getOrderID());
			statement.setLong(2, ordercontents.getItemID());
			statement.setLong(3, ordercontents.getQuantity());
			statement.executeUpdate();
			return read(ordercontents.getOrderContentsID());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public int delete(long orderContentsID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM ordercontents WHERE id = ?");) {
			statement.setLong(1, orderContentsID);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}
}

