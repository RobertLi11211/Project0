package com.revature.driver;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.CustomerDAOSerialization;
import com.revature.dao.CustomerListDAO;
import com.revature.dao.CustomerListDAOSerialization;
import com.revature.pojos.Customer;
import com.revature.pojos.CustomerList;
import com.revature.service.CarSystem;
import static com.revature.util.LoggerUtil.*;

public class Driver {
	public static void main(String[] args) {
		CarSystem carSys = new CarSystem();
		int loginChoice = carSys.showMenu();
		if (loginChoice == 3) {
			carSys.createCustomer();
		}

	}
}
