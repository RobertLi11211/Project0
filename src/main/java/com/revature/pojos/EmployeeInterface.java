package com.revature.pojos;

import java.util.List;

public interface EmployeeInterface {
	public void addCar(Car c);
	
	public void acceptOffer(double offer, Customer cust, Car c);
	
	public void rejectOffer(double offer, Customer cust, Car c);
	
	public List<Double> viewPayments(Car c);
	
	public void removeCar(Car c);
}
