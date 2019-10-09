package com.revature.sql.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.revature.util.ConnectionFactory;
import com.revature.pojos.Car;
import com.revature.pojos.Customer;

public class CarSQLDAOPostgres implements CarSQLDAO {

	private static Connection conn = ConnectionFactory.getConnection();

	@Override
	public Car getCar(int vin) {
		String sql = "select * from CarLot where vin = ?";
		PreparedStatement stat;
		Car car = new Car();
		try {
			stat = conn.prepareStatement(sql);
			stat.setInt(1, vin);
			ResultSet rs = stat.executeQuery();
			while (rs.next()) {
				car.setVin(rs.getInt(1));
				car.setMake(rs.getString(2));
				car.setModel(rs.getString(3));
				car.setColor(rs.getString(4));
				car.setAcceptedOffer(rs.getDouble(5));
				car.setRemainingPayment(rs.getDouble(6));
				car.setOwner(rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return car;
	}

	@Override
	public void createCar(Car c) {
		String sql = "insert into carlot (make, model, color, acceptedoffer, remainingpayment, owner)"
				+ " values (?, ?, ?, ?, ?, ?)";
		PreparedStatement stat;

		try {
			stat = conn.prepareStatement(sql);
			stat.setString(1, c.getMake());
			stat.setString(2, c.getModel());
			stat.setString(3, c.getColor());
			stat.setDouble(4, c.getAcceptedOffer());
			stat.setDouble(5, c.getRemainingPayment());
			stat.setString(6, c.getOwner());

			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Car> getCarLot() {
		String sql = "select * from CarLot order by vin";
		PreparedStatement stat;
		List<Car> carLot = new ArrayList<>();
		try {
			stat = conn.prepareStatement(sql);
			ResultSet rs = stat.executeQuery();
			while (rs.next()) {
				Car car = new Car();
				car.setVin(rs.getInt(1));
				car.setMake(rs.getString(2));
				car.setModel(rs.getString(3));
				car.setColor(rs.getString(4));
				car.setAcceptedOffer(rs.getDouble(5));
				car.setRemainingPayment(rs.getDouble(6));
				car.setOwner(rs.getString(7));
				carLot.add(car);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return carLot;
	}

	@Override
	public Map<Double, String> getOffers(int vin) {
		String sql = "select * from CarOffers where vin = ?";
		PreparedStatement stat;
		Map<Double, String> offers = new HashMap<>();

		try {
			stat = conn.prepareStatement(sql);
			stat.setInt(1, vin);
			ResultSet rs = stat.executeQuery();
			while (rs.next()) {
				Double offer = rs.getDouble(3);
				String username = rs.getString(4);
				offers.put(offer, username);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return offers;
	}

	@Override
	public List<Double> getPayments(int vin) {
		String sql = "select * from CarPayments where vin = ?";
		PreparedStatement stat;
		List<Double> payments = new ArrayList<>();

		try {
			stat = conn.prepareStatement(sql);
			stat.setInt(1, vin);
			ResultSet rs = stat.executeQuery();
			while (rs.next()) {
				Double payment = rs.getDouble(2);
				payments.add(payment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return payments;
	}

	@Override
	public void updateOffers(int vin, Double offer, String username) {
		String sql = "insert into CarOffers (vin, OfferAmount, OfferBy) " + "values (?, ?, ?)";
		PreparedStatement stat;

		try {
			stat = conn.prepareStatement(sql);
			stat.setInt(1, vin);
			stat.setDouble(2, offer);
			stat.setString(3, username);
			stat.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void acceptOffer(Double offer, String username, int vin) {
		// set accepted offer in carlot
		String sql = "update CarLot " + "Set acceptedOffer = ?, owner = ?" + "where vin = ?";
		PreparedStatement stat;

		try {
			stat = conn.prepareStatement(sql);
			stat.setDouble(1, offer);
			stat.setString(2, username);
			stat.setInt(3, vin);
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// reject pending offers
		String sql2 = "delete from CarOffers where vin = ?";
		PreparedStatement stat2;

		try {
			stat2 = conn.prepareStatement(sql2);
			stat2.setInt(1, vin);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// add vin to customer's car lot
		CustomerSQLDAOPostgres custDAO = new CustomerSQLDAOPostgres();
		Customer c = custDAO.getCustomer(username);
		String sql3 = "insert into CustomerCarList (CustID, vin) values (?, ?)";
		PreparedStatement stat3;
		try {
			stat3 = conn.prepareStatement(sql3);
			stat3.setInt(1, c.getCustID());
			stat3.setInt(2, vin);
			stat3.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void rejectOffer(Double offer, String username, int vin) {

		String sql = "Delete from CarOffers where OfferAmount = ? and OfferBy = ? and vin = ?";
		PreparedStatement stat;
		try {
			stat = conn.prepareStatement(sql);
			stat.setDouble(1, offer);
			stat.setString(2, username);
			stat.setInt(3, vin);
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updatePayment(Double payment, int vin) {
		String sql = "insert into CarPayments (vin, Payment) values (?, ?)";
		PreparedStatement stat;
		try {
			stat = conn.prepareStatement(sql);
			stat.setInt(1, vin);
			stat.setDouble(2, payment);
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void removeCar(int vin) {

		PreparedStatement stat;
		String sql = "Delete from caroffers where vin = ?";
		try {
			stat = conn.prepareStatement(sql);
			stat.setInt(1, vin);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String sql2 = "Delete from carpayments where vin = ?";
		try {
			stat = conn.prepareStatement(sql2);
			stat.setInt(1, vin);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String sql3 = "Delete from customercarlist where vin = ?";
		try {
			stat = conn.prepareStatement(sql3);
			stat.setInt(1, vin);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String sql4 = "Delete from carlot where vin = ?";
		try {
			stat = conn.prepareStatement(sql4);
			stat.setInt(1, vin);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
