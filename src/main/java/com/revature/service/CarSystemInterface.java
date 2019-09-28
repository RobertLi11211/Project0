package com.revature.service;

import java.util.List;
import java.util.Map;

import com.revature.pojos.Car;
import com.revature.pojos.Customer;

public interface CarSystemInterface {
	
	public double calculateMonthlyPayment(Car car);
	
	public void rejectPendingOffer(Car car);
	
	public void createCustomer();
	
	public String logInUsername();
	
	public String logInPassword();

	public int showMenu();
	
	public List<Customer> getCustomerList();
	
	public Map getCustomerUserAndPass();
}
