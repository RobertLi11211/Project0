package com.revature.sql.dao;

import java.util.List;
import java.util.Map;

import com.revature.pojos.Car;

public interface CarSQLDAO {
	public Car getCar(int vin);
	
	public void createCar(Car c);
	
	public List<Car> getCarLot();
	
	public Map<Double, String> getOffers(int vin);
	
	public List<Double> getPayments(int vin);
	
	public void updateOffers(int vin, Double offer, String username);
	
	public void acceptOffer(Double offer, String username, int vin);
	
	public void rejectOffer(Double offer, String username, int vin);
	
	public void updatePayment(Double payment, int vin);
	
	public void removeCar(int vin);
	
	
}
