package com.revature.service;

import static com.revature.util.LoggerUtil.info;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.pojos.Car;
import com.revature.pojos.Customer;
import com.revature.pojos.Employee;
import com.revature.sql.dao.CarSQLDAOPostgres;
import com.revature.sql.dao.CustomerSQLDAOPostgres;
import com.revature.sql.dao.EmployeeSQLDAOPostgres;

import static com.revature.util.LoggerUtil.*;

public class CarSystemMenu implements CarSystemMenuInterface {
	// This class contains all the menus
	

	// DAOs
	CarSQLDAOPostgres carDAO = new CarSQLDAOPostgres();
	CustomerSQLDAOPostgres custDAO = new CustomerSQLDAOPostgres();
	EmployeeSQLDAOPostgres eDAO = new EmployeeSQLDAOPostgres();	

	// Creating objects
	CarSystem carSys = new CarSystem();
	Scanner scanner = new Scanner(System.in);
	

	@Override
	public String loginUsername() {
		System.out.println("Enter username. \nTo return to the main menu, type main ");
		String username = scanner.nextLine();
		checkMain(username);
		return username;
	}

	@Override
	public String loginPassword() {
		System.out.println("Enter password. \nTo return to the main menu, type main ");
		info("reached pass succesfully");
		String password = scanner.nextLine();
		checkMain(password);
		return password;
	}

	@Override
	public boolean checkVin(int vin) {
		List<Car> cars = carDAO.getCarLot();
		List<Integer> vins = new ArrayList<>();
		for (Car car:cars) {
			vins.add(car.getVin());
		}
		if (vins.contains(vin)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean checkUsername(String s) {
		List<Customer> custList = custDAO.getCustomerList();		
		List<String> usernames = new ArrayList<>();
		for (Customer cust:custList) {
			usernames.add(cust.getUsername());
		}
		if (usernames.contains(s)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean checkMain(String s) {
		if (s.contentEquals("main")) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void showMenu() {
		System.out.println("If you would like to register as a customer, press 1." + "\n"
				+ "If you are a customer, press 2." + "\n" + "If you are an employee, press 3."
				+ "\nIf you would like to exit, press 4.");
		String choice = scanner.nextLine();
		int loginChoice = Integer.parseInt(choice);
		List<String> ret = new ArrayList<>();
		String username;
		boolean custLogin;
		boolean empLogin;
		if (loginChoice == 1) {
			carSys.createCustomer();
			showMenu();
			
		} else if (loginChoice == 2) {
			username = loginUsername();
			String password = loginPassword();
			custLogin = carSys.customerLogin(username, password);
			if (custLogin) {
				showCustomerMenu(username);
				/*
				 * ret.add("customer"); ret.add(username); return ret;
				 */
			} else {
				System.out.println("Incorrect username/password");
				showMenu();
			}

		} else if (loginChoice == 3) {
			username = loginUsername();
			String password = loginPassword();
			empLogin = carSys.employeeLogin(username, password);
			if (empLogin) {
				showEmployeeMenu(username);
				/*
				 * ret.add("employee"); ret.add(username); return ret;
				 */
			} else {
				System.out.println("Incorrect username/password");
				showMenu();
			}
			

		} else if (loginChoice == 4) {
			System.exit(0);
		}
		else {
			System.out.println("Please input 1, 2, 3, or 4");
			showMenu();
			
		}
		
		String type = ret.get(0);
		username = ret.get(1);
		int customerChoice = 0;
		int employeeChoice = 0;
		if (type.contentEquals("customer")) {
			showCustomerMenu(username);
			// cust = custDAO.readCustomer(username);
		} else if (type.contentEquals("employee")) {
			showEmployeeMenu(username);
			// emp = eDAO.readEmployee(username);
		}
		
	}

	@Override
	public void showEmployeeMenu(String username) {
		String vin;
		Employee e = eDAO.getEmployee(username);
		String choice;
		Car car;
		System.out.println("Would you like to: \n1. Add a car to the lot"
				+ "\n2. Remove a car from the lot \n3. Accept an offer \n4. Reject an offer"
				+ "\n5. View all payments for a car \n6. Go back to main menu");
		choice = scanner.nextLine();
		int employeeChoice = 0;
		if (choice.contentEquals("1") || choice.contentEquals("2") || choice.contentEquals("3")
				|| choice.contentEquals("4") || choice.contentEquals("5") || choice.contentEquals("6")) {
			info("chose " + choice);
			employeeChoice = Integer.parseInt(choice);
		} else {
			System.out.println("Did not pick a number between 1 and 6 \nPlease pick a number 1-6");
			info("did not choose 1-6");
			showEmployeeMenu(username);
		}
		// return employeeChoice;

		if (employeeChoice == 1) {
			car = addCarMenu();
			e.addCar(car);
			System.out.println("Car successfully added");
			showEmployeeMenu(username);
		} else if (employeeChoice == 2) {
			int carvin = removeCarMenu();
			e.removeCar(carvin);
			System.out.println("Car successfully removed");
			showEmployeeMenu(username);
		} else if (employeeChoice == 3) {
			String[] theOffer = showOffersMenu();
			vin = theOffer[0];
			username = theOffer[1];
			double offer = Double.parseDouble(theOffer[2]);
			e.acceptOffer(offer, custDAO.getCustomer(username), Integer.parseInt(vin));
			showEmployeeMenu(e.getUsername());
			System.out.println("Offer accepted!");
		} else if (employeeChoice == 4) {
			String[] theOffer = showOffersMenu();
			vin = theOffer[0];
			username = theOffer[1];
			double offer = Double.parseDouble(theOffer[2]);
			e.rejectOffer(offer, custDAO.getCustomer(username), Integer.parseInt(vin));
			showEmployeeMenu(e.getUsername());
			System.out.println("Offer rejected");
		} else if (employeeChoice == 5) {
			System.out.println("Please enter the VIN for the car you wish to view: ");
			vin = scanner.nextLine();
			car = carDAO.getCar(Integer.parseInt(vin));
			System.out.println(e.viewPayments(car)); 
			showEmployeeMenu(e.getUsername());
		} else if (employeeChoice == 6) {
			showMenu();
		}

	}

	@Override
	public void showCustomerMenu(String username) {
		String choice;
		Customer cust = custDAO.getCustomer(username);
		System.out.println("Would you like to: \n1. View Car Lot \n2. Make offer"
				+ "\n3. View your cars \n4. View remaining payments \n5. Go back to main menu");
		choice = scanner.nextLine();
		if (choice.contentEquals("1") || choice.contentEquals("2") || choice.contentEquals("3")
				|| choice.contentEquals("4") || choice.contentEquals("5")) {
			info("chose " + choice);

		} else {
			System.out.println("Did not pick a number between 1 and 5 \nPlease pick a number 1-5");
			info("did not choose 1-6");
			showCustomerMenu(cust.getUsername());
		}
		int customerChoice = Integer.parseInt(choice);
		// return customerChoice;

		if (customerChoice == 1) {
			List<Car> CarLot = cust.getCarLot();
			showCustomerMenu(cust.getUsername());
		} else if (customerChoice == 2) {
			List<Car> carLot = cust.getCarLot();
			List<Integer> vins = new ArrayList<>();
			for (Car c : carLot) {
				vins.add(c.getVin());
			}
			System.out.println("Please write the vin number of the car for which you wish to offer");
			int vin = scanner.nextInt();

			while (vins.contains(vin) == false) {
				if (vin == 0) {
					showCustomerMenu(cust.getUsername());
				}
				System.out.println("Please input a valid vin");
				System.out.println("If you wish to go back, type 0");
				vin = scanner.nextInt();
			}

			Car car = carDAO.getCar(vin);
			System.out.println("Please input your offer: ");
			double offer = scanner.nextDouble();
			scanner.nextLine();
			car = cust.makeOffer(offer, car);
			System.out.println("Offer made!");
			showCustomerMenu(cust.getUsername());
		} else if (customerChoice == 3) {
			List<Car> myCars = cust.viewMyCars();
			showCustomerMenu(cust.getUsername());
		} else if (customerChoice == 4) {
			List<Car> myCars = cust.viewMyCars();
			List<Integer> vins = new ArrayList<>();
			for (Car c : myCars) {
				vins.add(c.getVin());
			}
			System.out.println("Please input vin number of car you would like to see");
			int vin = scanner.nextInt();

			while (vins.contains(vin) == false) {
				if (vin == 0) {
					showCustomerMenu(cust.getUsername());
				}
				System.out.println("Please input a valid vin");
				System.out.println("If you wish to go back, type back");
				vin = scanner.nextInt();
			}

			Car car = carDAO.getCar(vin);
			cust.viewRemainingPayment(car);
			showCustomerMenu(cust.getUsername());
		} else if (customerChoice == 5) {
			showMenu();
		}

	}

	@Override
	public Car addCarMenu() {
		Car c = new Car();
		/*
		 * System.out.println("Please enter VIN number: "); int vin = scanner.nextInt();
		 */
		System.out.println("Please enter make: ");
		String make = scanner.nextLine();
		System.out.println("Please enter model: ");
		String model = scanner.nextLine();
		System.out.println("Please enter color: ");
		String color = scanner.nextLine();

		c.setMake(make);
		c.setModel(model);
		c.setColor(color);
		return c;
	}

	@Override
	public int removeCarMenu() {
		Customer cust = new Customer();
		cust.getCarLot();
		System.out.println("Please enter vin number of car to be removed: ");
		int vin = scanner.nextInt();
		String doubleInput = scanner.nextLine();
		return vin;

	}

	@Override
	public String[] showOffersMenu() {
		
		List<Car> carLot = carDAO.getCarLot();
		for (Car car:carLot) {
			car.setOffers(carDAO.getOffers(car.getVin()));
			System.out.println("VIN: " + car.getVin() + "\nMake: " + car.getMake() + "\nModel: " + car.getModel()
				+ "\nColor: " + car.getColor() + "\nOffers: " + car.getOffers());
			System.out.println(" ");
		}
		String[] ret = new String[3];
		System.out.println("Please type the car's vin: ");
		ret[0] = scanner.nextLine();
		if (!checkVin(Integer.parseInt(ret[0]))) {
			System.out.println("Incorrect vin. Try again");
			showOffersMenu();
		}
		System.out.println("Please type the customer's username: ");
		ret[1] = scanner.nextLine();
		
		System.out.println("Please type the offer amount: ");
		ret[2] = scanner.nextLine();
		return ret;

	}

}
