package com.revature.sql.dao;

import java.util.List;

import com.revature.pojos.Employee;

public interface EmployeeSQLDAO {
	public Employee getEmployee(String username);
	
	public void createEmployee(Employee e);
	
	public List<Employee> getEmployeeList();
	
}
