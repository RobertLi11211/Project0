package com.revature.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class CarLotDAOSerialization implements CarLotDAO {

	@Override
	public void createCarLot(List<String> c) {
		String fileName = "CarLot.dat";
		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(c);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<String> readCarLotList() {
		String fileName = "CarLot.dat";
		List<String> ret = null;
		try (FileInputStream fis = new FileInputStream(fileName); ObjectInputStream ois = new ObjectInputStream(fis);) {
			ret = (List<String>) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return ret;
	}

}
