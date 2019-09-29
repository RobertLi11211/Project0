package com.revature.pojos;

import java.util.List;

public interface EmployeeInterface {
	public void addCar(Car c);
	
	public void acceptOffer(double offer, String username);
	
	public void rejectOffer(double offer, String username);
	
	public List<Double> viewPayments(Car c);
}
