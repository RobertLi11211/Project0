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
		 * Employee robert = new Employee("Robert", "11211");
		 * eDAO.createEmployee(robert); EmployeeListDAOSerialization eListDAO = new
		 * EmployeeListDAOSerialization(); List<String> eListName = new ArrayList<>();
		 * eListName.add(robert.getUsername()); eListDAO.createEmployeeList(eListName);
		 */

		/*
		 * Customer robert = new Customer("Robert", "11211"); CustomerDAOSerialization
		 * cDAO = new CustomerDAOSerialization(); cDAO.createCustomer(robert);
		 * CustomerListDAOSerialization cListDAO = new CustomerListDAOSerialization();
		 * List<String> cListName = new ArrayList<>();
		 * cListName.add(robert.getUsername()); cListDAO.createCustomerList(cListName);
		 * 
		 * Car testCar = new Car("realVin", "Mazda 3", "Hatchback", "white");
		 * carDAO.createCar(testCar); CarLotDAOSerialization carLotDAO = new
		 * CarLotDAOSerialization(); List<String> carLotName = new ArrayList<>();
		 * carLotName.add(testCar.getVin()); carLotDAO.createCarLot(carLotName);
		 */

		

		carSysMenu.showMenu();

		/*
		 * if (customerChoice == 1) { List<Car> CarLot = cust.getCarLot(); }else if
		 * (customerChoice == 2) { List<Car> carLot = cust.getCarLot(); List<String>
		 * vins = new ArrayList<>(); for (Car c: carLot) { vins.add(c.getVin()); }
		 * System.out.
		 * println("Please write the vin number of the car for which you wish to offer"
		 * ); String vin = scanner.nextLine();
		 * 
		 * while (vins.contains(vin) == false) { if (vin == "back") { }
		 * carSysMenu.showCustomerMenu(cust.getUsername()); }
		 * System.out.println("Please input a valid vin");
		 * System.out.println("If you wish to go back, type back"); vin =
		 * scanner.nextLine(); }
		 * 
		 * car = carDAO.readCar(vin); System.out.println("Please input your offer: ");
		 * double offer = scanner.nextDouble(); cust.makeOffer(offer, car);
		 * System.out.println("Offer made!"); //showCustomerMenu(cust.getUsername()); }
		 * else if (customerChoice == 3) { List<Car> myCars = cust.viewMyCars();
		 * //showCustomerMenu(cust.getUsername()); } else if (customerChoice == 4) {
		 * List<Car> myCars = cust.viewMyCars(); List<String> vins = new ArrayList<>();
		 * for (Car c: myCars) { vins.add(c.getVin()); }
		 * System.out.println("Please input vin number of car you would like to see");
		 * String vin = scanner.nextLine();
		 * 
		 * 
		 * while (vins.contains(vin) == false) { if (vin == "back") {
		 * //carSysMenu.showCustomerMenu(cust.getUsername()); }
		 * System.out.println("Please input a valid vin");
		 * System.out.println("If you wish to go back, type back"); vin =
		 * scanner.nextLine(); }
		 * 
		 * 
		 * car = carDAO.readCar(vin); cust.viewRemainingPayment(car);
		 * //showCustomerMenu(cust.getUsername()); } else if (customerChoice == 5) {
		 * //showMenu();
		 * 
		 * } if (employeeChoice == 1) { car = carSysMenu.addCarMenu(); emp.addCar(car);
		 * System.out.println("Car successfully added"); //showEmployeeMenu(username); }
		 * else if (employeeChoice == 2) { car = carSysMenu.removeCarMenu();
		 * emp.removeCar(car); System.out.println("Car successfully removed");
		 * //showEmployeeMenu(username); } else if (employeeChoice == 3) { String[]
		 * theOffer = carSysMenu.showOffersMenu(); String vin = theOffer[0]; username =
		 * theOffer[1]; double offer = Double.parseDouble(theOffer[2]);
		 * emp.acceptOffer(offer, custDAO.readCustomer(username), carDAO.readCar(vin));
		 * //showEmployeeMenu(e.getUsername()); } else if (employeeChoice == 4) {
		 * String[] theOffer = carSysMenu.showOffersMenu(); String vin = theOffer[0];
		 * username = theOffer[1]; double offer = Double.parseDouble(theOffer[2]);
		 * emp.rejectOffer(offer, custDAO.readCustomer(username), carDAO.readCar(vin));
		 * //showEmployeeMenu(e.getUsername()); } else if (employeeChoice == 5) {
		 * System.out.println("Please enter the VIN for the car you wish to view: ");
		 * String vin = scanner.nextLine(); car = carDAO.readCar(vin);
		 * System.out.println(emp.viewPayments(car));
		 * //showEmployeeMenu(e.getUsername()); } else if (employeeChoice == 6) {
		 * //showMenu(); }
		 */

	}
}
