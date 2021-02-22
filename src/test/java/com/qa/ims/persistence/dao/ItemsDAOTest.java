package com.qa.ims.persistence.dao;

import org.junit.Test;

import com.qa.ims.persistence.domain.Items;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ItemsDAOTest {

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Items.class).verify();
		
		
	}
}
