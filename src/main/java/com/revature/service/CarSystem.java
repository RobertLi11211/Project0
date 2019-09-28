package com.revature.service;

import com.revature.dao.CustomerDAOSerialization;

import com.revature.dao.CustomerListDAOSerialization;
import com.revature.pojos.Car;
import com.revature.pojos.Customer;
import com.revature.pojos.CustomerList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import static com.revature.util.LoggerUtil.*;

public class CarSystem implements CarSystemInterface {
	Scanner scanner = new Scanner(System.in);

	@Override
	public double calculateMonthlyPayment(Car car) {
		// TODO Auto-generated method stub
		double monthlyPayment = 0;
		return monthlyPayment;
	}

	@Override
	public void rejectPendingOffer(Car car) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createCustomer() {
		List<Customer> customerList = getCustomerList();
		Map<String, String> userAndPass = getCustomerUserAndPass();
		String username = logInUsername();

		if (userAndPass.containsKey(username)) {
			System.out.println("Username already taken. \nPlease enter a new username");
			username = logInUsername();
		}

		String password = logInPassword();
		Customer newCustomer = new Customer(username, password);
		customerList.add(newCustomer);
		CustomerListDAOSerialization cDAO = new CustomerListDAOSerialization();
		CustomerDAOSerialization custDAO = new CustomerDAOSerialization();
		custDAO.createCustomer(newCustomer);
		List<String> customers = cDAO.readCustomerList();
		customers.add(newCustomer.getUsername());
		cDAO.createCustomerList(customers);

	}

	@Override
	public String logInUsername() {
		System.out.println("Enter username. \nTo return to the main menu, type main ");
		String username = scanner.nextLine();
		if (username.contentEquals("main")) {
			showMenu();
			return "";
		}

		return username;
	}

	@Override
	public String logInPassword() {
		System.out.println("Enter password. \nTo return to the main menu, type main ");
		// info("reached pass succesfully");
		String password = scanner.nextLine();

		if (password.contentEquals("main")) {
			showMenu();
			return "";
		}

		return password;
	}

	@Override
	public int showMenu() {
		System.out.println("If you are an employee, press 1." + "\n" + "If you are a customer, press 2." + "\n"
				+ "If you would like to register as a customer, press 3.");
		String choice = scanner.nextLine();
		if (choice.contentEquals("1") || choice.contentEquals("2") || choice.contentEquals("3")) {
			info("chose " + choice);
			return Integer.parseInt(choice);
		} else {
			System.out.println("Did not pick 1, 2, or 3. \nPlease pick 1, 2, or 3");
			info("did not choose 1 2 or 3");
			showMenu();
		}

		return Integer.parseInt(choice);
	}

	@Override
	public List<Customer> getCustomerList() {
		CustomerListDAOSerialization cListGet = new CustomerListDAOSerialization();
		CustomerDAOSerialization cDAO = new CustomerDAOSerialization();
		List<String> cList = cListGet.readCustomerList();
		List<Customer> customerList = new ArrayList<>();
		for (String s : cList) {
			customerList.add(cDAO.readCustomer(s));
		}
		return customerList;
	}

	@Override
	public Map getCustomerUserAndPass() {
		List<Customer> customerList = getCustomerList();
		Map<String, String> userAndPass = new HashMap<>();
		for (Customer c : customerList) {
			userAndPass.put(c.getUsername(), c.getPassword());
		}
		return userAndPass;
	}

}
