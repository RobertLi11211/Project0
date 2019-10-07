package com.revature.service;

import com.revature.pojos.Car;
import com.revature.pojos.Customer;
import com.revature.pojos.CustomerList;
import com.revature.pojos.Employee;
import com.revature.sql.dao.CustomerSQLDAOPostgres;
import com.revature.sql.dao.EmployeeSQLDAOPostgres;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import static com.revature.util.LoggerUtil.*;

public class CarSystem implements CarSystemInterface {
	Scanner scanner = new Scanner(System.in);
	//CarSystemMenu carSysMenu = new CarSystemMenu();
	
	public String loginUsername() {
		System.out.println("Enter username. \nTo return to the main menu, type main ");
		String username = scanner.nextLine();
		//checkMain(username)
		return username;
	}
	
	public String loginPassword() {
		System.out.println("Enter password. \nTo return to the main menu, type main ");
		info("reached pass succesfully");
		String password = scanner.nextLine();
		//checkMain(password);
		return password;
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
		CustomerSQLDAOPostgres custDAO = new CustomerSQLDAOPostgres();
		custDAO.createCustomer(newCustomer);
		System.out.println("\nAccount succesfully created. Please login again. \n");

	}
	

	@Override
	public void createEmployee() {
		;

	}

	@Override
	public List<Customer> getCustomerList() {
		CustomerSQLDAOPostgres custDAO = new CustomerSQLDAOPostgres();
		return custDAO.getCustomerList();
	}

	@Override
	public List<Employee> getEmployeeList() {
		EmployeeSQLDAOPostgres eDAO = new EmployeeSQLDAOPostgres();		
		return eDAO.getEmployeeList();

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
			info(c.toString());
			userAndPass.put(c.getUsername(), c.getPassword());
		}
		return userAndPass;
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
		monthlyPayment = car.getAcceptedOffer() / 12;
		return monthlyPayment;
	}

	@Override
	public void rejectPendingOffer(Car car) {
		//should be automatically completed by carDAO
		car.setOffers(new HashMap<Double, String>());
	}

}
