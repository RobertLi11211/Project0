package com.revature.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.revature.dao.CarDAOSerialization;
import com.revature.dao.CarLotDAOSerialization;
import com.revature.service.CarSystem;

public class Employee implements Serializable, EmployeeInterface {

	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [username=" + username + ", password=" + password + "]";
	}

	public Employee(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addCar(Car c) {
		// TODO Auto-generated method stub
		Car car = new Car(c.getVin(), c.getMake(), c.getModel(), c.getColor());
		CarDAOSerialization carDAO = new CarDAOSerialization();
		carDAO.createCar(car);
		CarLotDAOSerialization carLotDAO = new CarLotDAOSerialization();
		List<String> carLotName = carLotDAO.readCarLotList();
		carLotName.add(car.getVin());
		carLotDAO.createCarLot(carLotName);
	}

	@Override
	public void acceptOffer(double offer, Customer cust, Car c) {
		c.setAcceptedOffer(offer);
		c.setRemainingPayment(offer);
		CarSystem carSys = new CarSystem();
		carSys.rejectPendingOffer(c);
		List<String> custVINs = cust.getCarVINs();
		custVINs.add(c.getVin());
		cust.setCarVINs(custVINs);

	}

	@Override
	public void rejectOffer(double offer, Customer cust, Car c) {
		// TODO Auto-generated method stub
		Map<Double, Customer> offers = c.getOffers();
		if (offers.containsValue(cust)) {
			offers.remove(offer, cust);
		}
		c.setOffers(offers);
	}

	@Override
	public List<Double> viewPayments(Car c) {
		List<Double> payments = c.getPayments();
		return payments;
	}

	@Override
	public void removeCar(Car c) {
		String vin = c.getVin();
		CarLotDAOSerialization cLotDAO = new CarLotDAOSerialization();
		List<String> carLot = cLotDAO.readCarLotList();
		if (carLot.contains(vin)) {
			carLot.remove(vin);
		} else {
			System.out.println("lot does not contain a car with that vin");
		}
		cLotDAO.createCarLot(carLot);
	}

}
