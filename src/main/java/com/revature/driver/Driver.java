package com.revature.driver;

import java.util.List;

import com.revature.dao.CustomerListDAO;
import com.revature.dao.CustomerListDAOSerialization;
import com.revature.pojos.Customer;
import com.revature.pojos.CustomerList;
import com.revature.service.CarSystem;

public class Driver {
	public static void main(String[] args) {
		CarSystem carSys = new CarSystem();
		List<Customer> customerList =  carSys.getCustomerList();
		//carSys.showMenu();
		
	}
}
