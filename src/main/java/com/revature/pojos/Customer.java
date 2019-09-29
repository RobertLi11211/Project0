package com.revature.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.revature.dao.CarDAOSerialization;
import com.revature.dao.CarLotDAOSerialization;

public class Customer implements Serializable, CustomerInterface {
	private String username;
	private String password;
	private List<String> carVINs = new ArrayList<>();

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

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carVINs == null) ? 0 : carVINs.hashCode());
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
		Customer other = (Customer) obj;
		if (carVINs == null) {
			if (other.carVINs != null)
				return false;
		} else if (!carVINs.equals(other.carVINs))
			return false;
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
		return "Customer [username=" + username + ", password=" + password + ", carVINs=" + carVINs + "]";
	}

	@Override
	public List<Car> getCarLot() {
		CarLotDAOSerialization carLotDAO = new CarLotDAOSerialization();
		CarDAOSerialization carDAO = new CarDAOSerialization();
		List<String> carLotVin = carLotDAO.readCarLotList();
		List<Car> ret = new ArrayList<>();
		for (String s : carLotVin) {
			ret.add(carDAO.readCar(s));
		}
		return ret;
	}

	@Override
	public double makeOffer(double offer, String vin) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Car> viewMyCars() {
		// TODO Auto-generated method stub
		List<Car> myCars = new ArrayList<>();
		CarDAOSerialization carDAO = new CarDAOSerialization();
		if (this.carVINs == null) {
			System.out.println("You own no cars");
			return null;
		}
		else {
			for (String vin: carVINs) {
				myCars.add(carDAO.readCar(vin));
			}
		}
		return myCars;
	}

	@Override
	public double viewRemainingPayment(Car c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void makePayment(double payment) {
		// TODO Auto-generated method stub

	}

}
