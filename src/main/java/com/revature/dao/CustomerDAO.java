package com.revature.dao;

import com.revature.pojos.Customer;

public interface CustomerDAO {
	public void createCustomer(Customer c);

	public Customer readCustomer(String username);
}
