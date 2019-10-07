package com.revature.sql.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Customer;
import com.revature.pojos.Employee;
import com.revature.util.ConnectionFactory;

public class EmployeeSQLDAOPostgres implements EmployeeSQLDAO {
	
	private static Connection conn = ConnectionFactory.getConnection();

	@Override
	public Employee getEmployee(String username) {
		String sql = "select * from CarEmployees where username = ?";
		Employee e = new Employee();
		PreparedStatement stat;
		try {
			stat = conn.prepareStatement(sql);
			stat.setString(1, username);
			ResultSet rs = stat.executeQuery();
			while (rs.next()) {
				e.setEmployeeID(rs.getInt(1));
				e.setUsername(rs.getString(2));
				e.setPassword(rs.getString(3));
			}
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}

		return e;
	}

	@Override
	public void createEmployee(Employee e) {
		String sql = "insert into CarEmployees (username, password) values(?, ?)";
		PreparedStatement stat;

		try {
			stat = conn.prepareStatement(sql);
			stat.setString(1, e.getUsername());
			stat.setString(2, e.getPassword());
			stat.executeUpdate();
		} catch (SQLException f) {
			f.printStackTrace();
		}

	}

	@Override
	public List<Employee> getEmployeeList() {
		String sql = "select * from CarEmployees";
		List<Employee> empList = new ArrayList<>();
		PreparedStatement stat;
		try {
			Employee e = new Employee();
			stat = conn.prepareStatement(sql);
			ResultSet rs = stat.executeQuery();
			while (rs.next()) {
				e.setEmployeeID(rs.getInt(1));
				e.setUsername(rs.getString(2));
				e.setPassword(rs.getString(3));
				empList.add(e);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return empList;
	}

}
