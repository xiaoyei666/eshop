package com.csxh.action;

import javax.servlet.http.HttpServletRequest;

import com.csxh.model.Customer;

public class CustomerAction {

	HttpServletRequest req;
	public void setRequest(HttpServletRequest req) {
		// TODO Auto-generated method stub
		this.req=req;
	}

	Customer customer;
	public void setCustomer(Customer c) {
		// TODO Auto-generated method stub
		this.customer=c;
	}

	public String handle() {
		
		
		
		return null;
	}

}
