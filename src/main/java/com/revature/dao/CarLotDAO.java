package com.revature.dao;

import java.util.List;

public interface CarLotDAO {
	public void createCarLot(List<String> c);

	public List<String> readCarLotList();
}
