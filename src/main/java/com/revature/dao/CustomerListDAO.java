package com.revature.dao;

import com.revature.pojos.Customer;
import com.revature.pojos.CustomerList;

public interface CustomerListDAO {
	public void createCustomerList(CustomerList c);

	public CustomerList readCustomerList();
}
