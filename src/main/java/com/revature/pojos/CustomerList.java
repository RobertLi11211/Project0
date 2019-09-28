package com.revature.pojos;

import java.util.ArrayList;
import java.util.List;

public class CustomerList {
	private List<Customer> customerList = new ArrayList();

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	public CustomerList(List<Customer> customerList) {
		super();
		this.customerList = customerList;
	}

	public CustomerList() {
		super();
		
	}
	
	
}
