package com.revature.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.revature.dao.CarDAOSerialization;
import com.revature.dao.CarLotDAOSerialization;
import static com.revature.util.LoggerUtil.*;

public class Customer implements Serializable, CustomerInterface {
	private int CustID;
	private String username;
	private String password;
	private List<String> carVINs = new ArrayList<>();
	
	
	
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
	
	

	public List<String> getCarVINs() {
		return carVINs;
	}

	public void setCarVINs(List<String> carVINs) {
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
		CarLotDAOSerialization carLotDAO = new CarLotDAOSerialization();
		CarDAOSerialization carDAO = new CarDAOSerialization();
		List<String> carLotVin = carLotDAO.readCarLotList();
		List<Car> ret = new ArrayList<>();
		for (String s : carLotVin) {
			Car c = carDAO.readCar(s);
			if (c.getAcceptedOffer() == 0) {
				ret.add(c);
			}
		}
		for (Car car: ret) {
			System.out.println("VIN: " + car.getVin() + "\nMake: " + car.getMake() + 
					"\nModel: " + car.getModel() + "\nColor: " + car.getColor() + 
					"\nOffers: " + car.getOffers());	
			System.out.println(" ");
		}
		System.out.println("\n");
		return ret;
	}

	@Override
	public List<Car> viewMyCars() {
		// TODO Auto-generated method stub
		List<Car> myCars = new ArrayList<>();
		CarDAOSerialization carDAO = new CarDAOSerialization();
		if (this.carVINs == null) {
			System.out.println("You own no cars");
			return null;
		} else {
			for (String vin : carVINs) {
				myCars.add(carDAO.readCar(vin));
			}
		}
		for (Car car: myCars) {
			System.out.println("VIN: " + car.getVin() + "\nMake: " + car.getMake() + 
					"\nModel: " + car.getModel() + "\nColor: " + car.getColor() + "\n");			
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
		CarDAOSerialization carDAO = new CarDAOSerialization();
		if (c.getAcceptedOffer() == 0) {
			Map<Double, String> carOffers = c.getOffers();
			info("" + carOffers);
			carOffers.put(offer, getUsername());
			info("" + carOffers); 
			c.setOffers(carOffers);
			info("" + c.getOffers());
			carDAO.createCar(c);
			return c;
		} else {
			System.out.println("Car has already been bought");
			return c;
		}
		
	}

}
