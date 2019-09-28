package com.revature.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import com.revature.service.CarSystem;

public class CarSystemTest {
	CarSystem carSys;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		carSys = new CarSystem();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLogInUsername() {
		assertEquals("The username should be Robert", "Robert", carSys.logInUsername());
	}
	
	@Test
	public void testLogInPassword() {
		assertEquals("The password should be 11211", "11211", carSys.logInPassword());
	}
	
	/*
	 * @Test public void testMenu() { assertEquals("The choice is 1", new
	 * Integer(1), carSys.showMenu()); }
	 */
	
	@Test
	public void testGoToMain() {
		assertEquals("This should go to main", "", carSys.logInPassword());
	}
}
