package com.revature.pojos;

import java.util.List;

public interface EmployeeInterface {
	
	public void addCar(Car c);
	
	public Car acceptOffer(double offer, Customer cust, Car c);
	
	public Car rejectOffer(double offer, Customer cust, Car c);
	
	public List<Double> viewPayments(Car c);
	
	public void removeCar(Car c);
}
