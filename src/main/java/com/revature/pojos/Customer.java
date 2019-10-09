package com.revature.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.revature.sql.dao.CarSQLDAOPostgres;
import com.revature.sql.dao.CustomerSQLDAOPostgres;

import static com.revature.util.LoggerUtil.*;

public class Customer implements  CustomerInterface {
	private int CustID;
	private String username;
	private String password;
	private List<Integer> carVINs = new ArrayList<>();

	public int getCustID() {
		return CustID;
	}

	public void setCustID(int custID) {
		CustID = custID;
	}

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

	public List<Integer> getCarVINs() {
		return carVINs;
	}

	public void setCarVINs(List<Integer> carVINs) {
		this.carVINs = carVINs;
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
		CarSQLDAOPostgres carDAO = new CarSQLDAOPostgres();
		List<Car> ret = carDAO.getCarLot();
		for (Car car : ret) {
			if (car.getAcceptedOffer() == 0) {
				car.setOffers(carDAO.getOffers(car.getVin()));
				System.out.println("VIN: " + car.getVin() + "\nMake: " + car.getMake() + "\nModel: " + car.getModel()
					+ "\nColor: " + car.getColor() + "\nOffers: " + car.getOffers());
				System.out.println(" ");
			}
		}
		System.out.println("\n");
		return ret;
	}

	@Override
	public List<Car> viewMyCars() {
		CustomerSQLDAOPostgres custDAO = new CustomerSQLDAOPostgres();
		List<Car> myCars = custDAO.getCustomerCarList(this);
		
		CarSQLDAOPostgres carDAO = new CarSQLDAOPostgres();
		
		if (this.carVINs == null) {
			System.out.println("You own no cars");
			return null;
		} else {
			for (Integer vin : carVINs) {
				myCars.add(carDAO.getCar(vin));
			}
		}
		info("my vins " + this.carVINs);
		info("my cars + " + myCars);
		for (Car car : myCars) {
			System.out.println("VIN: " + car.getVin() + "\nMake: " + car.getMake() + "\nModel: " + car.getModel()
					+ "\nColor: " + car.getColor() + "\nMonthly Payment: " + car.getAcceptedOffer() / 12 + "\n");
		}
		return myCars;
	}

	@Override
	public double viewRemainingPayment(Car c) {
		// TODO Auto-generated method stub

		return c.getRemainingPayment();
	}

	@Override
	public void makePayment(double payment, Car c) {
		List<Car> myCars = viewMyCars();
		if (myCars.contains(c)) {
			double remainingPayment = c.getRemainingPayment();
			remainingPayment -= payment;
			if (remainingPayment <= 0) {
				System.out.println("Car is paid off");
			}
			c.setRemainingPayment(remainingPayment);
		} else {
			System.out.println("Not your car");
		}

	}

	@Override
	public Car makeOffer(double offer, Car c) {
		CarSQLDAOPostgres carDAO = new CarSQLDAOPostgres();
		if (c.getAcceptedOffer() == 0) {
			carDAO.updateOffers(c.getVin(), offer, this.username);
			return c;
		} else {
			System.out.println("Car has already been bought");
			return c;
		}

	}

}
