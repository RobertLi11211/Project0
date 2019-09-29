package com.revature.dao;

import java.util.List;

public interface EmployeeListDAO {
	public void createEmployeeList(List<String> c);

	public List<String> readEmployeeList();
}
