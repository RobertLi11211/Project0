package com.revature.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.pojos.Car;

public class CarDAOSerialization implements CarDAO {

	@Override
	public void createCar(Car c) {
		String fileName;
		//FileOutputStream fos = null;
		//ObjectOutputStream oos = null;
		if (c.getVin() != null) {
			fileName = c.getVin() + ".dat";
		} else {
			fileName = "MysteryMachine.dat";
		}
		
		/*
		 * try { fos = new FileOutputStream(fileName); oos = new
		 * ObjectOutputStream(fos); oos.writeObject(c); } catch (FileNotFoundException
		 * e) { e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); } finally { if (oos != null) { try {
		 * oos.close(); } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } } if (fos != null) { try { fos.close(); } catch
		 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); } }
		 * }
		 */
		
		try (FileOutputStream fos = new FileOutputStream(fileName); ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Car readCar(String vin) {
		String fileName = vin + ".dat";
		// FileInputStream fis = null;
		// ObjectInputStream ois = null;

		Car ret = null;

		// try with resources
		try (FileInputStream fis = new FileInputStream(fileName); ObjectInputStream ois = new ObjectInputStream(fis);) {
			ret = (Car) ois.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ret;
	}

}
