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

import java.util.HashMap;
import java.util.Map;

import com.revature.pojos.Car;
import com.revature.pojos.Customer;
import com.revature.pojos.Employee;
import com.revature.service.CarSystem;
import com.revature.service.CarSystemMenu;

public class CarSystemTest {
	CarSystem carSys;
	Car car;
	Employee e = new Employee();
	Customer cust = new Customer();
	double offer;
	CarSystemMenu carSysMenu;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		carSys = new CarSystem();
		carSysMenu = new CarSystemMenu();
		cust = new Customer();
		car = new Car();
		offer = 12345.6;
		Map<Double, String> newMap = new HashMap<>();
		newMap.put(12345.6, cust.getUsername());
		car.setOffers(newMap);
	}

	@After
	public void tearDown() throws Exception {
	}

		
	@Test
	public void testCustomerLoginWorks() {
		assertTrue("This should return true", carSys.customerLogin("Robert", "11211"));
	}
	
	@Test
	public void testCustomerLoginWrongPassword() {
		assertFalse("This should return false", carSys.customerLogin("Robert", "11221"));
	}
	
	@Test
	public void testCustomerLoginWrongUsername() {
		assertFalse("This should return false", carSys.customerLogin("Robert1", "11211"));
	}
	
	@Test
	public void testEmployeeLoginWorks() {
		assertTrue("This should return true", carSys.employeeLogin("Robert", "11211"));
	}
	
	@Test
	public void testEmployeeLoginWrongPassword() {
		assertFalse("This should return false", carSys.employeeLogin("Robert", "11221"));
	}
	
	@Test
	public void testEmployeeLoginWrongUsername() {
		assertFalse("This should return false", carSys.employeeLogin("Robert1", "11211"));
	}
	
	@Test
	public void testRejectPendingOffer() {
		carSys.rejectPendingOffer(car);
		assertEquals("There should be no pending offers", new HashMap<Double, Customer>(), car.getOffers());
	}
	
	@Test
	public void testRejectOffer() {
		e.rejectOffer(offer, cust, car.getVin());
		assertEquals("There should be no pending offers", new HashMap<Double, Customer>(), car.getOffers());
	}
	
	@Test
	public void testCorrectVIN() {
		assertTrue("This should return true", carSysMenu.checkVin("realVin"));
	}
	
	@Test
	public void testFalseVin() {
		assertFalse("This should return false", carSysMenu.checkVin("DontUseThis"));
	}
	
	@Test
	public void testCorrectUsername() {
		assertTrue("This should return true", carSysMenu.checkUsername("Robert"));
	}
	
	@Test
	public void testFalseUsername() {
		assertFalse("This should return false", carSysMenu.checkUsername("DontUseThis"));
	}
}
