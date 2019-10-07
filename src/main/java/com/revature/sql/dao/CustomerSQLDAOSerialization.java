package com.revature.sql.dao;

import java.sql.Connection;
import java.util.List;

import com.revature.pojos.Customer;
import com.revature.util.ConnectionFactory;

public class CustomerSQLDAOSerialization implements CustomerSQLDAO {
	String sql = "select * from CarCustomers where username = ?";
	private static Connection conn = ConnectionFactory.getConnection();

	@Override
	public Customer getCustomer(String username) {

		return null;
	}

	@Override
	public void createCustomer(Customer c) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Customer> getCustomerList() {
		// TODO Auto-generated method stub
		return null;
	}

}
