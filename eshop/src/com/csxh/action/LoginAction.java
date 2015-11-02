package com.csxh.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.csxh.model.Cart;
import com.csxh.model.Customer;
import com.csxh.util.JdbcUtil;
import com.csxh.util.ServletSessionUtil;

public class LoginAction {

	HttpServletRequest req;

	public void setRequest(HttpServletRequest req) {
		// TODO Auto-generated method stub
		this.req = req;
	}

	Customer customer;

	public void setCustomer(Customer c) {
		// TODO Auto-generated method stub
		this.customer = c;
	}

	public String handle() {

		if (!validate()) {
			// 如果输入格式验证没有通过，让其重新登录
			return "input";
		}

		// 验证邮件与密码
		//SQL 注入攻击 当一个where条件是由多个子条件构造时，就有可能人为构造一个为真的条件 1=1 and 2=2
		Customer customer = JdbcUtil.queryForObject(Customer.class, "email='" + this.customer.getEmail() + "'");

		if(customer==null || !customer.getPassword().equals(this.customer.getPassword())){
			//内容没有通过
			return "fail";					
		}
		
		boolean b=ServletSessionUtil.loginSuccess(this.req, customer);
		if(b){
			return "cart";
		}else{
			return "index";
		}
		
	}

	public boolean validate() {
		// TODO Auto-generated method stub
		return true;
	}

}
