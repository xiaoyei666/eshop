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

		// 验证邮件与密码
		// SQL 注入攻击 当一个where条件是由多个子条件构造时，就有可能人为构造一个为真的条件 1=1 and 2=2
		Customer customer = JdbcUtil.queryForObject(Customer.class, "email='" + this.customer.getEmail() + "'");

		if (customer == null || !customer.getPassword().equals(this.customer.getPassword())) {
			// 内容没有通过
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
