package com.revature.service;

import com.revature.dao.CustomerDAOSerialization;

import com.revature.dao.CustomerListDAOSerialization;
import com.revature.dao.EmployeeDAOSerialization;
import com.revature.dao.EmployeeListDAOSerialization;
import com.revature.pojos.Car;
import com.revature.pojos.Customer;
import com.revature.pojos.CustomerList;
import com.revature.pojos.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import static com.revature.util.LoggerUtil.*;

public class CarSystem implements CarSystemInterface {
	Scanner scanner = new Scanner(System.in);

	@Override
	public void checkMain(String s) {
		if (s.contentEquals("main")) {
			showMenu();
		}
	}

	@Override
	public void createCustomer() {
		List<Customer> customerList = getCustomerList();
		Map<String, String> userAndPass = getCustomerUserAndPass();
		String username = loginUsername();

		if (userAndPass.containsKey(username)) {
			System.out.println("Username already taken. \nPlease enter a new username");
			username = loginUsername();
		}

		String password = loginPassword();
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
	public void createEmployee() {
		;
		
	}

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
	public int showMenu() {
		System.out.println("If you would like to register as a customer, press 1." + "\n"
				+ "If you are a customer, press 2." + "\n" + "If you are an employee, press 3.");
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
	public List<Employee> getEmployeeList() {
		EmployeeListDAOSerialization eListGet = new EmployeeListDAOSerialization();
		EmployeeDAOSerialization eDAO = new EmployeeDAOSerialization();
		List<String> eList = eListGet.readEmployeeList();
		List<Employee> employeeList = new ArrayList<>();
		for (String s : eList) {
			employeeList.add(eDAO.readEmployee(s));
		}
		return employeeList;

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

	@Override
	public Map getEmployeeUserAndPass() {
		List<Employee> customerList = getEmployeeList();
		Map<String, String> userAndPass = new HashMap<>();
		for (Employee c : customerList) {
			userAndPass.put(c.getUsername(), c.getPassword());
		}
		return userAndPass;
	}

	@Override
	public void showEmployeeMenu() {
		
	}

	@Override
	public void showCustomerMenu() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean customerLogin(String username, String password) {
		Map<String, String> userAndPass = getCustomerUserAndPass();
		
		if (userAndPass.containsKey(username)) {
			
			String pass = userAndPass.get(username);
			if (password.contentEquals(pass)) {
				return true;
			} else {
				System.out.println("Incorrect password");
				return false;
			}
			
		} else {
			System.out.println("Incorrect username");
			return false;
		}
		
	}

	@Override
	public boolean employeeLogin(String username, String password) {
		Map<String, String> userAndPass = getEmployeeUserAndPass();
		
		if (userAndPass.containsKey(username)) {
			
			String pass = userAndPass.get(username);
			if (password.contentEquals(pass)) {
				return true;
			} else {
				System.out.println("Incorrect password");
				return false;
			}
			
		} else {
			System.out.println("Incorrect username");
			return false;
		}
	}

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

	

}
