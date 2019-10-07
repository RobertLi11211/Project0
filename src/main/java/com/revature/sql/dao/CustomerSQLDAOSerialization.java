package com.revature.sql.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.revature.pojos.Customer;
import com.revature.util.ConnectionFactory;

public class CustomerSQLDAOSerialization implements CustomerSQLDAO {
	private static Connection conn = ConnectionFactory.getConnection();

	@Override
	public Customer getCustomer(String username) {
		String sql = "select * from CarCustomers where username = ?";
		Customer cust = new Customer();
		PreparedStatement stat = conn.prepareStatement(sql);
		try {
			stat.setString(1, username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
