package com.revature.dao;

import java.util.List;

import com.revature.pojos.Customer;
import com.revature.pojos.CustomerList;

public interface CustomerListDAO {
	public void createCustomerList(List<String> c);

	public List<String> readCustomerList();
}
