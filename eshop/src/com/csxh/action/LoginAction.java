package com.csxh.action;

import org.apache.struts2.ServletActionContext;

import com.csxh.model.Cart;
import com.csxh.model.Customer;
import com.csxh.util.JdbcUtil;
import com.csxh.util.ServletSessionUtil;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	Customer customer;

	public void setCustomer(Customer c) {

		this.customer = c;
		
	}

	public Customer getCustomer() {
		return customer;
	}

	public String handle() {

		if (this.customer == null) {
			return "input";
		}

		// ��֤�ʼ�������
		// SQL ע�빥�� ��һ��where�������ɶ������������ʱ�����п�����Ϊ����һ��Ϊ������� 1=1 and 2=2
		Customer customer = JdbcUtil.queryForObject(Customer.class, "email='" + this.customer.getEmail() + "'");

		if (customer == null || !customer.getPassword().equals(this.customer.getPassword())) {
			// ����û��ͨ��
			return "input";
		}

		boolean b = ServletSessionUtil.loginSuccess(ServletActionContext.getRequest(), customer);
		if (b) {
		
			System.out.println(ServletActionContext.getRequest().getSession().getAttribute("ctx"));
			
			return "cart";
		} else {
			return "index";
		}

	}

	public void validate() {

	}

}
