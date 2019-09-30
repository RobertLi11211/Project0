package com.revature.service;

import java.util.List;

import com.revature.pojos.Car;

public interface CarSystemMenuInterface {
	public String loginUsername();
	
	public String loginPassword();
	
	public boolean checkVin(String s);
	
	public boolean checkUsername(String s);
	
	public void checkMain(String s);
	
	public List<String> showMenu();
	
	public void showEmployeeMenu(String username);
	
	public Car addCarMenu();
	
	public Car removeCarMenu();
	
	public String[] showOffersMenu();
	
	public void showCustomerMenu(String username);
	
	
	
	
}
