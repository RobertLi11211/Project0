package com.revature.service;

import java.util.List;
import java.util.Map;

import com.revature.pojos.Car;
import com.revature.pojos.Customer;
import com.revature.pojos.Employee;

public interface CarSystemInterface {
	
	public double calculateMonthlyPayment(Car car);
	
	public void rejectPendingOffer(Car car);
	
	public void createCustomer();
	
	public void createEmployee();
		
	public List<Customer> getCustomerList();
	
	public List<Employee> getEmployeeList();
	
	public Map getCustomerUserAndPass();
	
	public Map getEmployeeUserAndPass();
	
	public boolean customerLogin(String username, String password);
	
	public boolean employeeLogin(String username, String password);
}
