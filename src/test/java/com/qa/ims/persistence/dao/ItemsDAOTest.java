package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.DBUtils;


public final class ItemsDAOTest {
	
	private final ItemsDAO DAO = new ItemsDAO();


	@Before
	public void setup() {
		DBUtils.connect();
		System.out.println("Commencing Test");
		DBUtils.getInstance().init("src/test/resources/sql-Items.sql", "src/test/resources/sql-data-Items.sql");
	}

	@Test
	public void testCreate() {
		final Items created = new Items(2L, "Cheese", 70.4D);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Items> expected = new ArrayList<>();
		expected.add(new Items(1L, "Cheese", 70.4D));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Items(1L, "Cheese", 70.4D), DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Items(ID, "Cheese", 70.4D), DAO.read(ID));
	}

	@Test
	public void testUpdate() {
		final Items updated = new Items(1L, "Twix", 55.5D);
		assertEquals(updated, DAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
}