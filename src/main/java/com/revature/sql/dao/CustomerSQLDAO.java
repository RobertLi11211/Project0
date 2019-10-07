package com.revature.sql.dao;

import java.util.List;

import com.revature.pojos.Customer;

public interface CustomerSQLDAO {
	public Customer getCustomer(String username);
	
	public void createCustomer(Customer c);
	
	public List<Customer> getCustomerList();
}
