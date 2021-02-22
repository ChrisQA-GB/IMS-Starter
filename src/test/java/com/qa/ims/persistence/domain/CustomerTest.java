package com.qa.ims.persistence.domain;

import org.junit.Before;
import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class CustomerTest {

	@Before
	public void beforeTest() {
		System.out.println("COMMENCING TESTING");
	}
	
	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Customer.class).verify();
	}

}
