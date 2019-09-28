package com.revature.service;

import java.util.List;

import com.revature.pojos.Car;
import com.revature.pojos.Customer;

public interface CarSystemInterface {
	
	public double calculateMonthlyPayment(Car car);
	
	public void rejectPendingOffer(Car car);
	
	public void createCustomer(String username, String password);
	
	public String logInUsername();
	
	public String logInPassword();

	public int showMenu();
	
	public List<Customer> getCustomerList();
}
