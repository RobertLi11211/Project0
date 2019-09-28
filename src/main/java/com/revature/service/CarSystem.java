package com.revature.service;

import com.revature.dao.CustomerListDAOSerialization;
import com.revature.pojos.Car;
import com.revature.pojos.Customer;
import com.revature.pojos.CustomerList;

import java.util.List;
import java.util.Scanner;
import static com.revature.util.LoggerUtil.*;

public class CarSystem implements CarSystemInterface {
	

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
	public void createCustomer(String username, String password) {
		List<Customer> customerList = getCustomerList();
		

	}

	@Override
	public String logInUsername() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter username: ");

		String username = scanner.nextLine();
		scanner.close();
		return username;
	}

	@Override
	public String logInPassword() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter password: ");

		String password = scanner.nextLine();
		scanner.close();
		return password;
	}

	@Override
	public int showMenu() {
		Scanner scanner = new Scanner(System.in);
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
		scanner.close();
		return Integer.parseInt(choice);
	}

	@Override
	public List<Customer> getCustomerList() {
		CustomerListDAOSerialization cListGet = new CustomerListDAOSerialization();
		CustomerList customerList;
		customerList = cListGet.readCustomerList();
		List<Customer> cList = customerList.getCustomerList();
		return cList;
	}

}
