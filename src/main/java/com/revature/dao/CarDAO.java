package com.revature.dao;

import com.revature.pojos.Car;

public interface CarDAO {
	public void createCar(Car c);
	
	
	public Car readCar(String vin);	
	
}
