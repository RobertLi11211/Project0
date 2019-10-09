package com.revature.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


import com.revature.service.CarSystem;
import com.revature.sql.dao.CarSQLDAOPostgres;


public class Employee implements EmployeeInterface {
	private int EmployeeID;	
	private String username;
	private String password;

		
	public int getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [username=" + username + ", password=" + password + "]";
	}

	public Employee(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Employee() {
		super();
	}

	@Override
	public void addCar(Car c) {
		CarSQLDAOPostgres carDAO = new CarSQLDAOPostgres();			
		carDAO.createCar(c);
		
	}

	@Override
	public void acceptOffer(double offer, Customer cust, int vin) {
		CarSQLDAOPostgres carDAO = new CarSQLDAOPostgres();
		carDAO.acceptOffer(offer, cust.getUsername(), vin);
		
		
	}

	@Override
	public void rejectOffer(double offer, Customer cust, int vin) {
		CarSQLDAOPostgres carDAO = new CarSQLDAOPostgres();
		carDAO.rejectOffer(offer, cust.getUsername(), vin);
	}

	@Override
	public List<Double> viewPayments(Car c) {
		CarSQLDAOPostgres carDao = new CarSQLDAOPostgres();
		List<Double> payments = carDao.getPayments(c.getVin());
		return payments;
	}

	@Override
	public void removeCar(int vin) {
		CarSQLDAOPostgres carDAO = new CarSQLDAOPostgres();
		carDAO.removeCar(vin);
		
	}

}
