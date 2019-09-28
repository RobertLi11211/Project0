package com.revature.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.pojos.Customer;
import com.revature.pojos.CustomerList;

public class CustomerListDAOSerialization implements CustomerListDAO {

	@Override
	public void createCustomerList(CustomerList c) {
		String fileName = "customerList.dat";
		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public CustomerList readCustomerList() {
		String fileName = "customerList.dat";
		CustomerList ret = new CustomerList();
		try (FileInputStream fis = new FileInputStream(fileName); ObjectInputStream ois = new ObjectInputStream(fis);) {
			ret = (CustomerList) ois.readObject();
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
