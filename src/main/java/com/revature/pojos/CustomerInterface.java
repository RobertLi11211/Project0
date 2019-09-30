package com.revature.pojos;

import java.util.List;
import java.util.Map;

public interface CustomerInterface {
	
	public List<Car> getCarLot();
		
	public Map<Double, Customer> makeOffer(double offer, Car c);
	
	public List<Car> viewMyCars();
	
	public double viewRemainingPayment(Car c);
	
	public void makePayment(double payment, Car c);
	
}
