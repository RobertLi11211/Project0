package com.revature.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CustomerList implements Serializable {
	private String[] customerList = null;

	public String[] getCustomerList() {
		return customerList;
	}

	public void setCustomerList(String[] customerList) {
		this.customerList = customerList;
	}

	public CustomerList(String[] customerList) {
		super();
		this.customerList = customerList;
	}

	public CustomerList() {
		super();
		
	}

	@Override
	public String toString() {
		String clist = "Customer List: ";
		for (String c: customerList) {
			clist += c;
		}
		return clist;
	}
	
	
}
