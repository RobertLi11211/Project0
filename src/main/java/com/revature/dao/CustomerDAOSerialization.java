package com.revature.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.pojos.Customer;

public class CustomerDAOSerialization implements CustomerDAO {

	@Override
	public void createCustomer(Customer c) {
		String fileName;
		if (c.getUsername() != null) {
			fileName = c.getUsername() + ".dat";
		} else {
			fileName = "MysteryPerson.dat";
		}
		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(c);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Customer readCustomer(String username) {
		String fileName = username + ".dat";
		Customer ret = null;
		try (FileInputStream fis = new FileInputStream(fileName); ObjectInputStream ois = new ObjectInputStream(fis);) {
			ret = (Customer) ois.readObject();
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
