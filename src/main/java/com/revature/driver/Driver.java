package com.revature.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
import com.revature.service.CarSystemMenu;

import static com.revature.util.LoggerUtil.*;

public class Driver {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		CarSystem carSys = new CarSystem();
		CarSystemMenu carSysMenu = new CarSystemMenu();
		EmployeeDAOSerialization eDAO = new EmployeeDAOSerialization();
		CarDAOSerialization carDAO = new CarDAOSerialization();
		CustomerDAOSerialization custDAO = new CustomerDAOSerialization();
		// Code needed to initialize lists

		/*
		  Employee robert = new Employee("Robert", "11211");
		  eDAO.createEmployee(robert); EmployeeListDAOSerialization eListDAO = new
		  EmployeeListDAOSerialization(); List<String> eListName = new ArrayList<>();
		  eListName.add(robert.getUsername()); eListDAO.createEmployeeList(eListName);
		 */

		/*
		  Customer robert1 = new Customer("Robert", "11211"); CustomerDAOSerialization
		  cDAO = new CustomerDAOSerialization(); cDAO.createCustomer(robert1);
		  CustomerListDAOSerialization cListDAO = new CustomerListDAOSerialization();
		  List<String> cListName = new ArrayList<>();
		  cListName.add(robert1.getUsername()); cListDAO.createCustomerList(cListName);
		  */
		  
		  /*Car testCar = new Car("realVin", "Mazda 3", "Hatchback", "white");
		  carDAO.createCar(testCar); CarLotDAOSerialization carLotDAO = new
		  CarLotDAOSerialization(); List<String> carLotName = new ArrayList<>();
		  carLotName.add(testCar.getVin()); carLotDAO.createCarLot(carLotName);
		 */

		

		carSysMenu.showMenu();

		

	}
}
