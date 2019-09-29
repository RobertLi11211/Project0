package com.revature.dao;

import java.util.List;

import com.revature.pojos.Car;
import com.revature.pojos.Employee;

public interface EmployeeDAO {
	public void createEmployee(Employee e);

	public Employee readEmployee(String username);
}
