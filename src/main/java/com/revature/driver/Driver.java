package com.revature.driver;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.CarDAOSerialization;
import com.revature.dao.CarLotDAOSerialization;
import com.revature.dao.CustomerDAOSerialization;
import com.revature.dao.CustomerListDAO;
import com.revature.dao.CustomerListDAOSerialization;
import com.revature.dao.EmployeeDAOSerialization;
import com.revature.dao.EmployeeListDAOSerialization;
import com.revature.pojos.Car;
import com.revature.pojos.Customer;
import com.revature.pojos.CustomerList;
import com.revature.pojos.Employee;
import com.revature.service.CarSystem;
import static com.revature.util.LoggerUtil.*;

public class Driver {
	public static void main(String[] args) {
		CarSystem carSys = new CarSystem();

		/*
		 * Employee robert = new Employee("Robert", "11211"); EmployeeDAOSerialization
		 * eDAO = new EmployeeDAOSerialization(); eDAO.createEmployee(robert);
		 * EmployeeListDAOSerialization eListDAO = new EmployeeListDAOSerialization();
		 * List<String> eListName = new ArrayList<>();
		 * eListName.add(robert.getUsername()); eListDAO.createEmployeeList(eListName);
		 */

		/*
		 * Customer robert = new Customer("Robert", "11211"); CustomerDAOSerialization
		 * cDAO = new CustomerDAOSerialization(); cDAO.createCustomer(robert);
		 * CustomerListDAOSerialization cListDAO = new CustomerListDAOSerialization();
		 * List<String> cListName = new ArrayList<>();
		 * cListName.add(robert.getUsername()); cListDAO.createCustomerList(cListName);
		 */
		
		/*
		 * Car car = new Car("realVin", "Mazda 3", "Hatchback", "white");
		 * CarDAOSerialization carDAO = new CarDAOSerialization();
		 * carDAO.createCar(car); CarLotDAOSerialization carLotDAO = new
		 * CarLotDAOSerialization(); List <String> carLotName = new ArrayList<>();
		 * carLotName.add(car.getVin()); carLotDAO.createCarLot(carLotName);
		 */

		int loginChoice = carSys.showMenu();
		String username;
		if (loginChoice == 1) {
			carSys.createCustomer();
			carSys.showMenu();
		}else if (loginChoice == 2) {
			username = carSys.loginUsername();
			String password = carSys.loginPassword();
			boolean custLogin = carSys.customerLogin(username, password);
		}else if (loginChoice == 3) {
			username = carSys.loginUsername();
			String password = carSys.loginPassword();
			boolean empLogin = carSys.employeeLogin(username, password);
		}
		
	}
}
