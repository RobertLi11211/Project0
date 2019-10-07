package com.revature.sql.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Car;
import com.revature.pojos.Customer;
import com.revature.util.ConnectionFactory;

public class CustomerSQLDAOPostgres implements CustomerSQLDAO {
	private static Connection conn = ConnectionFactory.getConnection();

	@Override
	public Customer getCustomer(String username) {
		String sql = "select * from CarCustomers where username = ?";
		Customer cust = new Customer();
		PreparedStatement stat;
		try {
			stat = conn.prepareStatement(sql);
			stat.setString(1, username);
			ResultSet rs = stat.executeQuery();
			while (rs.next()) {
				cust.setCustID(rs.getInt(1));
				cust.setUsername(rs.getString(2));
				cust.setPassword(rs.getString(3));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return cust;
	}

	@Override
	public void createCustomer(Customer c) {
		String sql = "insert into CarCustomers (username, password) values(?, ?)";
		PreparedStatement stat;

		try {
			stat = conn.prepareStatement(sql);
			stat.setString(1, c.getUsername());
			stat.setString(2, c.getPassword());
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Customer> getCustomerList() {
		String sql = "select * from CarCustomers";
		List<Customer> custList = new ArrayList<>();
		PreparedStatement stat;
		try {
			Customer cust = new Customer();
			stat = conn.prepareStatement(sql);
			ResultSet rs = stat.executeQuery();
			while (rs.next()) {
				cust.setCustID(rs.getInt(1));
				cust.setUsername(rs.getString(2));
				cust.setPassword(rs.getString(3));
				custList.add(cust);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return custList;
	}

	@Override
	public List<Car> getCustomerCarList(Customer c) {
		String sql = "select vin from CustomerCarList where CustID = ?";
		List<Car> carList = new ArrayList<>();
		List<Integer> carVins = new ArrayList<>();
		PreparedStatement stat;
		Car car = new Car();
		try {
			stat = conn.prepareStatement(sql);
			stat.setInt(1, c.getCustID());
			ResultSet rs = stat.executeQuery();
			while (rs.next()) {
				carVins.add(rs.getInt(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		CarSQLDAOPostgres carDAO = new CarSQLDAOPostgres();
		for (Integer inte: carVins) {
			carList.add(carDAO.getCar(inte));
		}

		return carList;
	}

}
