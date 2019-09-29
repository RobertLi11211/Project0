package com.revature.pojos;

import java.util.Map;

public interface CustomerInterface {
	
	public Map<String, String[]> getCarLot();
		
	public double makeOffer();
	
	public Map<String, String[]> viewMyCars();
	
	public double viewRemainingPayment(Car c);
	
}
